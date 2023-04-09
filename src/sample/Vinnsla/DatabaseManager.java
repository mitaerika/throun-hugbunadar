package sample.Vinnsla;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.MediaException;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseManager implements IDatabaseManager{
    private static final String JDBCdriver = "org.sqlite.JDBC";
    private static Connection conn = null;
    private static final String url = "jdbc:sqlite:daytrip.db";

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

    public ObservableList<String> dbToObservableList(String queryStmt) throws SQLException, ClassNotFoundException {
        //Declare statement, resultSet as null
        Statement stmt = null;
        ResultSet rs = null;
        ObservableList<String> temp = FXCollections.observableArrayList();
        try {
            //Connect to DB, create statement, and execute statement
            connectToDatabase();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryStmt);
            while(rs.next()){
                temp.add(rs.getString(1));
            }
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
        return temp;
    }

    public ArrayList<String> dbToArrayList(String queryStmt) throws SQLException, ClassNotFoundException {
        //Declare statement, resultSet as null
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> temp = new ArrayList<>();
        try {
            //Connect to DB, create statement, and execute statement
            connectToDatabase();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryStmt);
            while(rs.next()){
                temp.add(rs.getString(1));
            }
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
        return temp;
    }

    public ObservableList<String> fetchAvailableLocations() throws SQLException, ClassNotFoundException {
        String query = "SELECT location_name FROM Daytrip GROUP BY location_name";
        return  dbToObservableList(query);
    }

    public ObservableList<String> fetchAvailableActivities() throws SQLException, ClassNotFoundException {
        String query = "SELECT name FROM Activity GROUP BY name";
        return dbToObservableList(query);
    }

    public ObservableList<Daytrip> fetchAvailableDaytrips() throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT title,date_trip,start_time,end_time,description,price,photo,available_seats,location_name,avg(rating) FROM Daytrip, Review WHERE available_seats>0 AND title = daytrip_title GROUP BY title";
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


    /**
     * !! Need to make this work for activities and if not all filters are being used
     * @param day
     * @param location
     * @param departure
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ObservableList<Daytrip> fetchFilteredDaytrips(LocalDate day, String location, String departure) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet rs = null;
        String time = "";
        switch(departure){
            case "evening":
                time = "> '16:01:00'";
                break;
            case "afternoon":
                time = "> '12:01:00'";
                break;
            case "morning":
                time = "< '12:00:00'";
                break;
        }
        String query = "SELECT title,date_trip,start_time,end_time,description,price,photo,available_seats,location_name,avg(rating) FROM Daytrip, Review WHERE available_seats>0 AND title = daytrip_title AND date_trip = '"+day+"' AND location_name = '"+location+"' AND start_time "+time+" GROUP BY title";
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

    public void populateRatingAndReviewForDaytrip(Daytrip d) throws SQLException, ClassNotFoundException {
        String query = "SELECT rating,comment_text FROM Review WHERE daytrip_title ='"+d.getTitle()+"'";
        int n = fetchNumberOfEntries(query);
        String[] reviews = new String[n];
        int[] ratings = new int[n];
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //Connect to DB, create statement, and execute statement
            connectToDatabase();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            n = 0;
            while (rs.next()) {
                ratings[n] = rs.getInt(1);
                reviews[n] = rs.getString(2);
                n++;
            }
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
        d.setRatings(ratings);
        d.setReviews(reviews);
    }

    public void populateHotelsForDaytrip(Daytrip d) throws SQLException, ClassNotFoundException {
        String query = "SELECT name FROM Hotel, Daytrip WHERE Daytrip.title ='"+d.getTitle()+"' AND Daytrip.title = Hotel.daytrip_title GROUP BY name";
        d.setHotels(dbToObservableList(query));
    }

    public int fetchNumberOfEntries(String query) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet rs = null;
        int n = 0;
        try {
            //Connect to DB, create statement, and execute statement
            connectToDatabase();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                n++;
            }
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
        return n;
    }

    public ObservableList<String> fetchActivitiesForDaytrip(String title) throws SQLException, ClassNotFoundException {
        String query = "SELECT name FROM Activity, Daytrip WHERE Daytrip.title ='"+title+"' AND Daytrip.title = Activity.daytrip_title GROUP BY name";
        return dbToObservableList(query);
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
            String location = rs.getString(9);
            double rating = rs.getDouble(10);
            String[] temp = new String[3];
            //String[] reviews = fetchReviewsForDaytrip(title);
            String[] reviews = temp;
            String[] activity = temp;

            Daytrip tempD = new Daytrip(title, date, starttime, endtime, desc, price, filename, available_seats, location, reviews, rating, activity);   //búum til daytrip hlut og setjum allar uppllýsingrnarí svigann.
            dtList.add(tempD);        //setjum daytrip inn í lista dtList
        }
        return dtList;               //skilum fylkinu.
    }
}
