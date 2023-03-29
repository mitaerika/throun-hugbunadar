package sample;

//packages for javafx
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Vidmot.Controller;
import sample.Vinnsla.DatabaseManager;
import sample.Vinnsla.Daytrip;
import sample.Vinnsla.SimulDaytripMock;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        SimulDaytripMock x = new SimulDaytripMock();
        x.runTests();
        Parent root = FXMLLoader.load(getClass().getResource("Vidmot/sample.fxml"));
        primaryStage.setTitle("Day Trips");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
