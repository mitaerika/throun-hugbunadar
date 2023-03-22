package sample.Vinnsla;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Calendar;

public class DatabaseManager {
    public static void main(String[] args)
            throws Exception
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet r = null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:daytripDB.db");
            stmt = conn.createStatement();
            r = stmt.executeQuery("SELECT title FROM Daytrip;");
            if( r.next() ) System.out.println(r.getDouble(1));
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
        finally
        {
            if( r!=null ) r.close();
            if( stmt!=null ) stmt.close();
            if( conn!=null ) conn.close();
        }
    }
// db.sql fyrir create table etc

}
