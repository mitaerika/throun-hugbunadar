package sample;

//packages for javafx
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Day Trips");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {
        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:sqlite:daytrip.db");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS booking");
            stmt.executeUpdate("CREATE TABLE booking(key integer primary key,value double)");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO booking VALUES(?,?)");
            ResultSet r = stmt.executeQuery(
                    "SELECT * FROM booking"
            );
            r.next();
            System.out.println("Niðurstaða leitar: "+r.getInt(1));
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
        launch(args);
    }
}
