package sample.Vidmot;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import sample.Vinnsla.Booking;
import sample.Vinnsla.Customer;
import sample.Vinnsla.Daytrip;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BookingController implements Initializable {
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

    private Booking customer;

    public Booking addBooking(Daytrip daytrip, Customer customer){
        return this.customer;
    }

    public Booking removeBooking(Daytrip daytrip){
        return this.customer;
    }

    public void setDaytripList(ObservableList<Daytrip> cartList) {
        bookingTable.setItems(cartList);
    }

    public void createBooking(ActionEvent actionEvent) {
        System.out.println("create booking");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookingTable.getColumns().clear();
        confirmButton.setDisable(true);
        confirmButton.disableProperty().bind(
                Bindings.createBooleanBinding( () -> nameInput.getText().trim().isEmpty(), nameInput.textProperty())
                .or ( Bindings.createBooleanBinding( () -> phoneInput.getText().isEmpty(),phoneInput.textProperty())
                        .or ( Bindings.createBooleanBinding( () -> emailInput.getText().isEmpty(),emailInput.textProperty())
        )));
        TableColumn<Daytrip,String> titleCol = new TableColumn<Daytrip,String>("Ferð");
        titleCol.setCellValueFactory(new PropertyValueFactory<Daytrip,String>("title"));
        TableColumn<Daytrip,LocalDate> dateCol = new TableColumn<Daytrip,LocalDate>("Dagsetning");
        dateCol.setCellValueFactory(new PropertyValueFactory<Daytrip,LocalDate>("date"));
        TableColumn<Daytrip,Integer> seatsCol = new TableColumn<Daytrip,Integer>("Fjöldi sæta");
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

        bookingTable.getColumns().addAll(titleCol, dateCol, seatsCol, priceCol,costCol);
    }
}
