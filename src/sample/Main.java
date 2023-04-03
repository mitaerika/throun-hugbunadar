package sample;

//packages for javafx
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.Vidmot.Controller;
import sample.Vinnsla.DatabaseManager;
import sample.Vinnsla.Daytrip;
//import sample.Vinnsla.SimulDaytripMock;

import javax.swing.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //SimulDaytripMock x = new SimulDaytripMock();
        //x.runTests();
        //System.err.println(FXMLLoader.load(getClass().getResource("/Vidmot/sample.fxml")).toString());
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //Group root = new Group();
        //Scene scene = new Scene(root, Color.BLACK);
        stage.setTitle("Day Trips");
        //stage.setScene(scene);
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
