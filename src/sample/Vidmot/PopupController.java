/******************************************************************************
 *  Nafn    : Ásdís, Mita, Sigga og Jökull
 *  T-póstur: asv29@hi.is
 *
 *  Lýsing  :
 *
 *
 *****************************************************************************/

package sample.Vidmot;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PopupController {

private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
       // accessListView();
    }

    public void accessListView() {
        ListView<String> mylistView = controller.getMyListView();
        // perform your desired operation on the listView
        mylistView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Double-click to prevent accidental triggering
                try {
                    createPopupWindow();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void createPopupWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PopupGluggi.fxml"));
        Parent root = loader.load();
        // Create a new stage for the pop-up window
        Stage popupStage = new Stage();
        // Set the scene and show the stage
        popupStage.setScene(new Scene(root));
        popupStage.show();
    }
}
