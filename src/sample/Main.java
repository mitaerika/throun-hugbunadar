package sample;

//packages for javafx
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//packages for database connection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Vidmot/sample.fxml"));
        primaryStage.setTitle("Day Trips");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        int variableName = 4;
    }


    public static void main(String[] args) throws Exception {
        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:sqlite:daytripDB.db");
            Statement stmt = conn.createStatement();
            //stmt.executeUpdate("DROP TABLE IF EXISTS booking");
            //stmt.executeUpdate("CREATE TABLE booking(key integer primary key,value double)");
            //PreparedStatement pstmt = conn.prepareStatement("INSERT INTO booking VALUES(?,?)");
            ResultSet rs = stmt.executeQuery(
                    "SELECT title,date,price FROM Daytrip WHERE price<10000"
            );
            while (rs.next()) {
                System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getInt(3));
                System.out.println("");
            }
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
