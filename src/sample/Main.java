/******************************************************************************
 *  Nafn    : Ásdís Valtýsdóttir
 *  T-póstur: asv29@hi.is
 *
 *  Lýsing  : Aðalglugginn fyrir snákaleikinn.
 *
 *
 *****************************************************************************/

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Day Trips");
        stage.setScene(new Scene(root, 800, 650));
        stage.show();
    } catch(Exception e){
        e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
