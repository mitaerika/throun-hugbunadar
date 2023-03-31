package sample.Vinnsla;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DatabaseManager implements IDatabaseManager{
    private static final String JDBCdriver = "org.sqlite.JDBC";
    private static Connection conn = null;
    private static final String url = "jdbc:sqlite:daytripDB.db";

    public void connectToDatabase() throws SQLException, ClassNotFoundException {
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

    public void disconnectFromDatabase() throws SQLException{
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e){
            throw e;
        }
    }

    public ResultSet executeQuery(String queryStmt) throws SQLException, ClassNotFoundException {
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

    public ObservableList<Daytrip> fetchAvailableDaytrips() throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Daytrip WHERE available_seats>0";
        ObservableList<Daytrip> res;

        try {
            //Connect to DB, create statement, and execute statement
            connectToDatabase();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            res = createDaytripObservableList(rs);

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
        return  res;//aðferð þar sem database managerinn fær reslutset og býr itl daytrip hlut.
    }

    public String[] fetchReviewsForDaytrip(String title) throws SQLException, ClassNotFoundException {
        String query = "SELECT comment_text FROM Review, Daytrip WHERE Daytrip.title ='"+title+"' AND Daytrip.title = Review.daytrip_title";
        ResultSet rs = executeQuery(query);
        int n = 0;
        String[] reviews = new String[n];
       // rs.beforeFirst();
        n = 0;
        while (rs.next()) {
            reviews[n++] = rs.getString(1);

        }
        return reviews;
    }

    public double fetchRatingForDaytrip(String title) throws SQLException, ClassNotFoundException {
        String query = "SELECT rating FROM Review, Daytrip WHERE Daytrip.title ='"+title+"' AND Daytrip.title = Review.daytrip_title";
        ResultSet rs = executeQuery(query);
        int n = 0;
        int rating = 0;
        //rs.beforeFirst();
        int i = 0;
        while (rs.next()) {
            rating = rating+rs.getInt(1);
            n++;
        }
        return n > 0 ? rating/n : 0;
    }

    public String[] fetchHotelsForDaytrip(String title) throws SQLException, ClassNotFoundException {
        String query = "SELECT name FROM Hotel, Daytrip WHERE Daytrip.title ='"+title+"' AND Daytrip.title = Hotel.daytrip_title";
        ResultSet rs = executeQuery(query);
        String[] hotels = new String[3];
        int n = 0;
        while (rs.next()) {
            hotels[n++] = rs.getString(1);
        }
        return hotels;
    }

    public LocalTime toLocalTime(String temp){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.parse(temp, timeFormatter);
    }

    public LocalDate toLocalDate(String temp){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(temp, dateFormatter);
    }

    public ObservableList<Daytrip> createDaytripObservableList(ResultSet rs) throws SQLException, ClassNotFoundException {  //resultsettið sem var í main.
                                                                               //finnum út hve mörg daytrip fyrlki við þurfum að búa til.
        ObservableList<Daytrip> dtList = FXCollections.observableArrayList();
        while (rs.next()) {                               // hér búum við til daytrip hlutinn
            String title = rs.getString(1);
            //náum í upplýsingar úr resultset línu.
            String tempDate = rs.getString(2);
            String tempStartTime = rs.getString(3);
            String tempEndtime = rs.getString(4);
            // convert String to LocalDate and LocalTime
            LocalDate date = toLocalDate(tempDate);
            LocalTime starttime = toLocalTime(tempStartTime);
            LocalTime endtime = toLocalTime(tempEndtime);

            String desc = rs.getString(5);
            int price = rs.getInt(6);
            String filename = "file:src/image/"+title+".png";
            int available_seats = rs.getInt(8);
            String location = rs.getString(10);
            double rating = fetchRatingForDaytrip(title);
            String[] reviews = fetchReviewsForDaytrip(title);
            String[] hotels = fetchHotelsForDaytrip(title);
            // ! need to fix activity
            String activity = "";
            Daytrip temp = new Daytrip(title, date, starttime, endtime, desc, price, filename, available_seats, location, reviews, rating, hotels);   //búum til daytrip hlut og setjum allar uppllýsingrnarí svigann.
            System.err.println(temp.getTitle());
            dtList.add(temp);        //setjum daytrip inn í lista dtList
        }
        return dtList;               //skilum fylkinu.
    }
}
