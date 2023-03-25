package sample;

//packages for javafx
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Vinnsla.DatabaseManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Vidmot/sample.fxml"));
        primaryStage.setTitle("Day Trips");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        DatabaseManager.connectToDatabase();//hér tengjum við gagnagrunninn við okkar forrit og náum í allar upplýsingar um daytrip. Við fáum til baka result set í main og færum það yfir í database managerinn.
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
