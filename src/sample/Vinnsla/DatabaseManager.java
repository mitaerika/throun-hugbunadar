package sample.Vinnsla;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatabaseManager {
    public Daytrip[] createDaytripObjects(ResultSet rs) throws SQLException {
        // get n as size of resultSet
        int n = 0;
        while (rs.next()) {
            n++;
        }
        // create array of N daytrips
        Daytrip[] dt = new Daytrip[n];
        // resets pointer to the default position at the start of resultSet
        rs.beforeFirst();
        n = 0;
        while (rs.next()) {
            String title = rs.getString(1);
            String date = rs.getString(2);
            String starttime = rs.getString(3);
            String endtime = rs.getString(4);
            String desc = rs.getString(5);
            int price = rs.getInt(6);
            String filename = rs.getString(7);
            int available_seats = rs.getInt(8);
            // ! need to fix activity
            String activity = "";
            String location = rs.getString(10);
            // ! need to fix hotel
            String hotel = "";
            // ! need to convert String to Calendar/Time for startdate
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
            // ! need to create Daytrip instance consisting of info above
            Daytrip temp = new Daytrip();
            dt[n] = temp;
        }
        return dt;
    }

}
