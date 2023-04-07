package sample.Vidmot;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Vinnsla.DatabaseManager;
import sample.Vinnsla.Daytrip;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class DetailsController implements Initializable{
    @FXML
    private ComboBox<String> hotelPicker;
    @FXML
    private TitledPane reviewText;
    @FXML
    private Button bookSeatsButton;
    @FXML
    private Label dateText;
    @FXML
    private Label timeText;
    @FXML
    private Label priceText;
    @FXML
    private Label seatsText;
    @FXML
    private ComboBox<Integer> seatPicker;
    @FXML
    private ImageView tripPhoto;
    @FXML
    private Label tripDesc;
    @FXML
    private Label tripTitle;

    private int seats;
    private Controller c;
    private Daytrip daytrip;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tripPhoto.setPreserveRatio(true);
        tripPhoto.setFitHeight(500);
        tripDesc.setWrapText(true);
        bookSeatsButton.setDisable(true);
        reviewText.setExpanded(false);
    }

    public void setDaytrip(Daytrip selectedItem) {
        daytrip = selectedItem;
        tripTitle.setText(daytrip.getTitle());
        tripDesc.setText(daytrip.getDescription());
        tripPhoto.setImage(new Image(daytrip.getPhoto()));
        dateText.setText("Ferðadagsetning: "+daytrip.getDate());
        timeText.setText("Ferðatími: "+daytrip.getStartTime()+" ~ "+daytrip.getEnd_time());
        priceText.setText("Verð: "+daytrip.getPrice()+" per mann");
        int max = daytrip.getAvailable_seats();
        seatsText.setText("Velja lausa sæti");
        ObservableList<Integer> seats = FXCollections.observableArrayList();
        for(int i = 1; i <= max; i++){
            seats.add(i);
        }
        seatPicker.setItems(seats);
        String[] h = daytrip.getHotels();
        ObservableList<String> hotels = FXCollections.observableArrayList();
        for(int j = 0; j < 3; j++){
            System.out.println(h[j]);
            hotels.add(h[j]);
        }
        hotelPicker.setItems(hotels);
        String[] r = daytrip.getReviews();
        reviewText.setText("Athugasemdir ("+r.length+")");
        ObservableList<String> reviewList = FXCollections.observableArrayList();
        ListView<String> ls = new ListView<>();
        reviewList.addAll(Arrays.asList(r));
        ls.setItems(reviewList);
        reviewText.setContent(ls);
    }

    /**
     * Handler fyrir ComboBox sem sér um fjölda sæti sem notandinn vilja bóka
     * @param actionEvent sér um val fjölda sæti
     */
    public void selectSeats(ActionEvent actionEvent) {
        bookSeatsButton.setDisable(false);
        seats = seatPicker.getSelectionModel().getSelectedItem();
    }

    /**
     * Handler fyrir takka til að bóka sæti sem notandinn hafði valið
     * @param actionEvent sér um að færa ferðina í körfu og loka núverandi glugga þegar notandinn ýtir á takkann
     */
    public void bookSeats(ActionEvent actionEvent) {
        c.setToCart(daytrip, seats);
        Stage stage = (Stage) bookSeatsButton.getScene().getWindow();
        stage.close();
    }

    public void setController(Controller controller) {
        c = controller;
    }
}
