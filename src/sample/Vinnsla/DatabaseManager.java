package sample.Vinnsla;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
            int seats = rs.getInt(8);
            // ! need to fix activity
            String activity = "";
            String location = rs.getString(10);
            // ! need to fix reviews
            String review = "";
            // ! need to get rating
            int rating = 10;
            // ! need to convert String to Calendar/Time for startdate
            DateTimeFormatter fdate = DateTimeFormatter.ofPattern( "YYYY-MM-DD" );
            DateTimeFormatter ftime = DateTimeFormatter.ofPattern( "hh:mm:ss" );
            LocalDate ld = LocalDate.parse(date, fdate);
            LocalTime startT = LocalTime.parse(starttime, ftime);
            LocalTime endT = LocalTime.parse(endtime, ftime);
            // ! need to create Daytrip instance consisting of info above
            Daytrip temp = new Daytrip(title, ld, startT, endT, desc, price, filename, seats, location, review, rating);
            dt[n] = temp;
        }
        return dt;
    }
}
