package sample.Vidmot;

import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import sample.Vinnsla.Booking;
import sample.Vinnsla.Customer;
import sample.Vinnsla.DatabaseManager;
import sample.Vinnsla.Daytrip;

import javax.imageio.ImageIO;
import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class BookingController implements Initializable {
    @FXML
    private VBox mainVBox;
    @FXML
    private Label phoneLabel;
    @FXML
    private TextField nameInput;
    @FXML
    private TextField phoneInput;
    @FXML
    private TextField emailInput;
    @FXML
    private Button confirmButton;
    @FXML
    private TableView<Daytrip> bookingTable;

    private boolean phoneInputIsCorrect;
    private ObservableList<Daytrip> cartList;
    private Controller controller;
    private DatabaseManager dbm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookingTable.getColumns().clear();
        confirmButton.setDisable(true);
        confirmButton.disableProperty().bind(
                Bindings.createBooleanBinding( () -> nameInput.getText().trim().isEmpty(), nameInput.textProperty())
                .or ( Bindings.createBooleanBinding( () -> phoneInput.getText().trim().isEmpty() || phoneInputIsCorrect, phoneInput.textProperty())
                        .or ( Bindings.createBooleanBinding( () -> emailInput.getText().isEmpty(),emailInput.textProperty())
        )));

        phoneInput.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String old, String s) {
                if (!s.matches("\\d{7}")) {
                    phoneInputIsCorrect = false;
                    phoneLabel.setText("Símanúmer þarf að vera 7 stafa númer");
                } else {
                    phoneInputIsCorrect = true;
                    phoneLabel.setText("Símanúmer");
                }
            }
        });
        TableColumn<Daytrip,String> titleCol = new TableColumn<Daytrip,String>("Ferð");
        titleCol.setCellValueFactory(new PropertyValueFactory<Daytrip,String>("title"));
        TableColumn<Daytrip,LocalDate> dateCol = new TableColumn<Daytrip,LocalDate>("Dagsetning");
        dateCol.setCellValueFactory(new PropertyValueFactory<Daytrip,LocalDate>("date"));
        TableColumn<Daytrip,String> hotelCol = new TableColumn<Daytrip,String>("Sótt frá");
        hotelCol.setCellValueFactory(new PropertyValueFactory<Daytrip,String>("pickupLocation"));
        TableColumn<Daytrip, LocalTime> startCol = new TableColumn<Daytrip,LocalTime>("Brottför");
        startCol.setCellValueFactory(new PropertyValueFactory<Daytrip,LocalTime>("startTime"));
        TableColumn<Daytrip, LocalTime> endCol = new TableColumn<Daytrip,LocalTime>("Koma");
        endCol.setCellValueFactory(new PropertyValueFactory<Daytrip,LocalTime>("endTime"));
        TableColumn<Daytrip,Integer> seatsCol = new TableColumn<Daytrip,Integer>("Fjölda sæti");
        seatsCol.setCellValueFactory(new PropertyValueFactory<Daytrip,Integer>("bookedSeats"));
        TableColumn<Daytrip,Integer> priceCol = new TableColumn<Daytrip,Integer>("Verð per mann");
        priceCol.setCellValueFactory(new PropertyValueFactory<Daytrip,Integer>("price"));
        TableColumn<Daytrip,Integer> costCol = new TableColumn<Daytrip,Integer>("Verð samtals");
        costCol.setCellValueFactory(cellData -> {
            int price = cellData.getValue().getPrice();
            int seat = cellData.getValue().getBookedSeats();
            if(cellData.getValue() != null){
                int cost = price*seat;
                return new SimpleIntegerProperty(cost).asObject();
            }
            return null;
        });
        bookingTable.getColumns().addAll(titleCol, dateCol, hotelCol, startCol, endCol, seatsCol, priceCol,costCol);
    }

    public void setDaytripList(ObservableList<Daytrip> cartList) {
        this.cartList = cartList;
        bookingTable.setItems(cartList);
    }

    //create new Customer
    //reduce available seats per daytrip
    //create new Booking per daytrip
    public void createBooking(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        dbm = new DatabaseManager();
        Customer cust = new Customer(nameInput.getText(),emailInput.getText(),phoneInput.getText());
        dbm.registerCustomer(cust);
        for(Daytrip d : cartList){
            String bookingNum = dbm.registerBooking(d,cust);
            dbm.registerCustomerInBooking(bookingNum,cust);
            d.reduceAvailableSeats();
            dbm.updateDaytripAvailability(d);
        }
        ObservableList<Booking> bl = dbm.fetchBookingsForCustomer(cust);
        cust.setBookings(bl);
        displayBooking(cust);
        controller.getCartList().clear();
        controller.updateListView();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void displayBooking(Customer c) throws SQLException, ClassNotFoundException {
        mainVBox.getChildren().clear();
        Label name = new Label("Nafn: "+c.getName());
        Label phone = new Label("Símanúmer: "+c.getPhone());
        Label email = new Label("Netfang: "+c.getEmail());
        TableView<Booking> tv = new TableView<>();
        TableColumn<Booking,String> titleCol = new TableColumn<Booking,String>("Ferð");
        titleCol.setCellValueFactory(new PropertyValueFactory<Booking,String>("title"));
        TableColumn<Booking,LocalDate> dateCol = new TableColumn<Booking,LocalDate>("Dagsetning");
        dateCol.setCellValueFactory(new PropertyValueFactory<Booking,LocalDate>("date"));
        TableColumn<Booking,String> hotelCol = new TableColumn<Booking,String>("Sótt frá");
        hotelCol.setCellValueFactory(new PropertyValueFactory<Booking,String>("hotel"));
        TableColumn<Booking, LocalTime> startCol = new TableColumn<Booking,LocalTime>("Brottför");
        startCol.setCellValueFactory(new PropertyValueFactory<Booking,LocalTime>("startTime"));
        TableColumn<Booking, LocalTime> endCol = new TableColumn<Booking,LocalTime>("Koma");
        endCol.setCellValueFactory(new PropertyValueFactory<Booking,LocalTime>("endTime"));
        TableColumn<Booking,Integer> seatsCol = new TableColumn<Booking,Integer>("Fjölda sæti");
        seatsCol.setCellValueFactory(new PropertyValueFactory<Booking,Integer>("bookedSeats"));
        TableColumn<Booking,Integer> costCol = new TableColumn<Booking,Integer>("Kostnaður");
        costCol.setCellValueFactory(new PropertyValueFactory<Booking,Integer>("totalCost"));
        tv.getColumns().addAll(titleCol,seatsCol,dateCol,hotelCol,startCol,endCol,costCol);
        tv.setItems(dbm.fetchBookingsForCustomer(c));
        Button downloadButton = new Button();
        downloadButton.setText("Hlaða niður bókun");
        downloadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                WritableImage image = mainVBox.snapshot(new SnapshotParameters(), null);
                File file = new File("bookings.png");
                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        mainVBox.getChildren().addAll(name, phone, email, tv, downloadButton);
    }
}
