package sample.Vinnsla;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatabaseManager implements IDatabaseManager{
    private static final String JDBCdriver = "org.sqlite.JDBC";
    private static Connection conn = null;
    private static final String url = "jdbc:sqlite:daytripDB.db";

    public static void connectToDatabase() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(JDBCdriver);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found");
            e.printStackTrace();
            throw e;
        }

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void disconnectFromDatabase() throws SQLException{
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e){
            throw e;
        }
    }

    public static ResultSet executeQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        //Declare statement, resultSet as null
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //Connect to DB, create statement, and execute statement
            connectToDatabase();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            //Close connection
            disconnectFromDatabase();
        }
        return rs;
    }

    public static void fetchAvailableDaytrips() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM Daytrip WHERE available_seats>0";
        ResultSet rs = executeQuery(query);
        createDaytripObservableList(rs); //aðferð þar sem database managerinn fær reslutset og býr itl daytrip hlut.
    }

    public static String[] fetchReviewsForDaytrip(String title) throws SQLException, ClassNotFoundException {
        String query = "SELECT comment_text FROM Review, Daytrip WHERE Daytrip.title ="+title+" AND Daytrip.title = Review.daytrip_title";
        ResultSet rs = executeQuery(query);
        int n = 0;
        while (rs.next()) {
            n++;
        }
        String[] reviews = new String[n];
        rs.beforeFirst();
        n = 0;
        while (rs.next()) {
            reviews[n++] = rs.getString(1);
        }
        return reviews;
    }

    public static double fetchRatingForDaytrip(String title) throws SQLException, ClassNotFoundException {
        String query = "SELECT rating FROM Review, Daytrip WHERE Daytrip.title ="+title+" AND Daytrip.title = Review.daytrip_title";
        ResultSet rs = executeQuery(query);
        int n = 0;
        while (rs.next()) {
            n++;
        }
        int rating = 0;
        rs.beforeFirst();
        int i = 0;
        while (rs.next()) {
            rating = rating+rs.getInt(1);
        }
        return rating/n;
    }


    public static ObservableList<Daytrip> createDaytripObservableList(ResultSet rs) throws SQLException, ClassNotFoundException {  //resultsettið sem var í main.
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
            String location = rs.getString(10);
            double rating = fetchRatingForDaytrip(title);
            String[] reviews = fetchReviewsForDaytrip(title);
            // ! need to fix activity
            String activity = "";
            // ! need to fix hotel
            String hotel = "";
            // ! need to convert String to Calendar/Time for startdate
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

            Daytrip temp = new Daytrip(title, date, starttime, endtime, desc, price, filename, available_seats, activity, location, reviews, rating);   //búum til daytrip hlut og setjum allar uppllýsingrnarí svigann.
            dtList.add(temp);        //setjum daytrip inn í fylki dt
        }
        return dtList;               //skilum fylkinu.
    }
}
