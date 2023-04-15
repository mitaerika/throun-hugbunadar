package sample;

//packages for javafx
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import sample.Vinnsla.SimulDaytripMock;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //SimulDaytripMock x = new SimulDaytripMock();
        //x.runTests();
        //System.err.println(FXMLLoader.load(getClass().getResource("/Vidmot/Main.fxml")).toString());
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        //Group root = new Group();
        //Scene scene = new Scene(root, Color.BLACK);
        stage.setTitle("Day Trips");
        //stage.setScene(scene);
        stage.setScene(new Scene(root, 700, 540));
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
