package sample.Vidmot;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import sample.Vinnsla.DatabaseManager;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailsController implements Initializable {
    @FXML
    private ImageView tripPhoto;
    @FXML
    private Label tripDesc;
    @FXML
    private Label tripTitle;


    public void setDaytrip(String selectedItem) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
