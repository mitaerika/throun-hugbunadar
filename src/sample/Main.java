package sample;

//packages for javafx
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Vinnsla.DatabaseManager;
import sample.Vinnsla.Daytrip;

//packages for database connection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Main extends Application {
    static String url = "jdbc:sqlite:daytripDB.db";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Vidmot/sample.fxml"));
        primaryStage.setTitle("Day Trips");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        int variableName = 4;
    }

    public static void connectToDatabase() throws Exception{
        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM Daytrip WHERE available_seats>0"
            );
            DatabaseManager dbManager = new DatabaseManager();
            dbManager.createDaytripObjects(rs);
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(conn != null)
                    conn.close();
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        connectToDatabase();
        launch(args);
    }
}
