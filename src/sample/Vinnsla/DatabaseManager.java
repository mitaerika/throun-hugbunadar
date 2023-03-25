package sample.Vinnsla;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatabaseManager implements IDatabaseManager{

    public static void connectToDatabase() throws Exception{
        Class.forName("org.sqlite.JDBC");
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:sqlite:daytripDB.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM Daytrip WHERE available_seats>0"
            );
            createDaytripObservableList(rs); //aðferð þar sem database managerinn fær reslutset og býr itl daytrip hlut.
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


    public static ObservableList<Daytrip> createDaytripObservableList(ResultSet rs) throws SQLException {  //resultsettið sem var í main.
                                                                               //finnum út hve mörg daytrip fyrlki við þurfum að búa til.
        ObservableList<Daytrip> dtList = FXCollections.observableArrayList();

        while (rs.next()) {                               // hér búum við til daytrip hlutinn
            String title = rs.getString(1);    //náum í upplýsingar úr resultset línu.
            String date = rs.getString(2);
            String starttime = rs.getString(3);
            String endtime = rs.getString(4);
            String desc = rs.getString(5);
            int price = rs.getInt(6);
            String filename = title+".png";
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
            Daytrip temp = new Daytrip(title, date, starttime, endtime, desc, price, filename, available_seats, activity, location, hotel, cal, sdf);   //búum til daytrip hlut og setjum allar uppllýsingrnarí svigann.
            dtList.add(temp);        //setjum daytrip inn í fylki dt
        }
        return dtList;               //skilum fylkinu.
    }
}
