package sample.Vidmot;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Vinnsla.DatabaseManager;
import sample.Vinnsla.Daytrip;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailsController implements Initializable{
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tripPhoto.setPreserveRatio(true);
        tripPhoto.setFitHeight(500);
        tripDesc.setWrapText(true);
    }

    public void setDaytrip(Daytrip selectedItem) {
        tripTitle.setText(selectedItem.getTitle());
        tripDesc.setText(selectedItem.getDescription());
        tripPhoto.setImage(new Image(selectedItem.getPhoto()));
        dateText.setText("Ferðadagsetning: "+selectedItem.getDate());
        timeText.setText("Ferðatími: "+selectedItem.getStartTime()+" ~ "+selectedItem.getEnd_time());
        priceText.setText("Verð: "+selectedItem.getPrice()+" per mann");
        int max =selectedItem.getAvailable_seats();
        seatsText.setText("Velja lausa sæti");
        ObservableList<Integer> seats = FXCollections.observableArrayList();
        for(int i = 1; i <= max; i++){
            seats.add(i);
        }
        seatPicker.setItems(seats);
    }


    public void selectSeats(ActionEvent actionEvent) {
    }


}
