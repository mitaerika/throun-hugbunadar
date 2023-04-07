package sample.Vidmot;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Vinnsla.DatabaseManager;
import sample.Vinnsla.Daytrip;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailsController{
    @FXML
    private ImageView tripPhoto;
    @FXML
    private Label tripDesc;
    @FXML
    private Label tripTitle;


    public void setDaytrip(Daytrip selectedItem) {
        tripTitle.setText(selectedItem.getTitle());
        tripDesc.setWrapText(true);
        tripDesc.setText(selectedItem.getDescription());
        tripPhoto.setImage(new Image(selectedItem.getPhoto()));
    }


}
