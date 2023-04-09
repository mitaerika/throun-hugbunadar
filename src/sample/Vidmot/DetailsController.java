package sample.Vidmot;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Stage;
import sample.Vinnsla.DatabaseManager;
import sample.Vinnsla.Daytrip;
import sample.Vinnsla.DaytripListCell;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class DetailsController implements Initializable{
    @FXML
    private Label locationText;
    @FXML
    private Label activityText;
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
    private String selectedHotel;
    private double width;
    private boolean hotelIsSelected;
    private boolean seatIsSelected;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tripPhoto.setPreserveRatio(true);
        tripPhoto.setFitHeight(500);
        tripDesc.setWrapText(true);
        bookSeatsButton.setDisable(true);
        reviewText.setExpanded(false);
        width = reviewText.getWidth();
    }

    public void setDaytrip(Daytrip selectedItem) {
        daytrip = selectedItem;
        tripTitle.setText(daytrip.getTitle());
        tripDesc.setText(daytrip.getDescription());
        tripPhoto.setImage(new Image(daytrip.getPhoto()));
        dateText.setText("Ferðadagsetning: "+daytrip.getDate());
        timeText.setText("Ferðatími: "+daytrip.getStartTime()+" ~ "+daytrip.getEnd_time());
        locationText.setText("Landshluta: "+daytrip.getLocation());
        priceText.setText("Verð: "+daytrip.getPrice()+" per mann");
        String activity = "";
        for(String act: daytrip.getActivities()) activity = activity+act+", ";
        activityText.setText("Afþreyingar: "+activity);
        int max = daytrip.getAvailableSeats();
        seatsText.setText("Velja lausa sæti");
        ObservableList<Integer> seats = FXCollections.observableArrayList();
        for(int i = 1; i <= max; i++){
            seats.add(i);
        }
        seatPicker.setItems(seats);
        ObservableList<String> hotels = daytrip.getHotels();
        hotelPicker.setItems(hotels);
        ObservableList<String> reviewComments = daytrip.getReviews();
        ObservableList<String> ratings = daytrip.getRatings();
        double avgRating = daytrip.getAvgRating();
        int n = reviewComments.size();
        String formattedRating = String.format("%.1f", avgRating);
        if(n>1) reviewText.setText("Einkunn: "+formattedRating+"/10 "+" - "+ n+ " athugasemdir");
        else reviewText.setText("Einkunn: "+formattedRating+"/10 "+" - "+ n+ " athugasemd");
        ObservableList<String> reviewList = FXCollections.observableArrayList();
        ListView<String> ls = new ListView<>();
        for(int i = 0; i<n; i++){
            reviewList.add(ratings.get(i)+"/10 \n"+reviewComments.get(i));
        }
        ls.setItems(reviewList);
        ls.setCellFactory(param -> new ListCell<String>(){
            @Override
            protected void updateItem(String s, boolean empty) {
                super.updateItem(s, empty);
                if (empty || s == null) {
                    setText(null);
                }
                else {
                    setMaxWidth(width);
                    setPrefWidth(width);
                    setMinWidth(width);
                    setWrapText(true);
                    setText(s);
                }
            }
        });
        reviewText.setContent(ls);
    }

    /**
     * Handler fyrir ComboBox sem sér um hótel þar sem notandinn vill vera sóttur frá
     * @param actionEvent sér um val hótel
     */
    public void selectHotel(ActionEvent actionEvent) {
        selectedHotel = hotelPicker.getSelectionModel().getSelectedItem();
        daytrip.setPickupLocation(selectedHotel);
        hotelIsSelected = true;
        if(seatIsSelected) bookSeatsButton.setDisable(false);
    }

    /**
     * Handler fyrir ComboBox sem sér um fjölda sæti sem notandinn vill bóka
     * @param actionEvent sér um val fjölda sæti
     */
    public void selectSeats(ActionEvent actionEvent) {
        if(hotelIsSelected) bookSeatsButton.setDisable(false);
        seats = seatPicker.getSelectionModel().getSelectedItem();
        seatIsSelected = true;
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

    //!! Does not work yet
    public void openReviews(ContextMenuEvent contextMenuEvent) {
        //adjust size of window according to TitledPane
        Stage stage = (Stage) reviewText.getScene().getWindow();
        reviewText.expandedProperty().addListener((obs, oldHeight, newHeight) -> stage.sizeToScene());
    }
}
