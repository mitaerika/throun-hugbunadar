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

    public void runQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        //Declare statement, resultSet as null
        Statement stmt = null;
        try {
            //Connect to DB, create statement, and execute statement
            connectToDatabase();
            stmt = conn.createStatement();
            stmt.executeUpdate(queryStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            //Close connection
            disconnectFromDatabase();
        }
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
        String query = "SELECT * FROM Daytrip WHERE available_seats>0";
        ObservableList<Daytrip> daytripList;
        try {
            //Connect to DB, create statement, and execute statement
            connectToDatabase();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            daytripList = createDaytripObservableList(rs);
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
        populateRatingsForDaytrip(daytripList);
        populateActivitiesForDaytrip(daytripList);
        return  daytripList;//aðferð þar sem database managerinn fær reslutset og býr itl daytrip hlut.
    }


    /**
     * Sía niður ferðir skv. leitarkröfur sem notandinn valdi
     * @param day Dagsetning úr Datepicker
     * @param location Staðsetning úr ComboBox
     * @param departure Tímasetning úr CheckBox
     * @return listi af ferðum sem passar við leitarkröfur
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ObservableList<Daytrip> fetchFilteredDaytrips(LocalDate day, String location, String departure) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet rs = null;
        String time = "";
        if(departure != null)  {
            switch (departure) {
                case "evening":
                    time = "> '16:01:00'";
                    break;
                case "afternoon":
                    time = "> '12:01:00'";
                    break;
                case "morning":
                    time = "< '12:00:00'";
                    break;
                default:
                    time = "";
                    break;
            }
        }
        String dateQuery = "";
        if(day != null) dateQuery = " AND date_trip = '"+day+"'";
        String locationQuery = "";
        if(location != null && !location.equals("Allir landshlutar")) locationQuery = " AND location_name = '"+location+"'";
        String timeQuery = "";
        if (departure != null && !departure.equals("whenever")) timeQuery = " AND start_time "+time;
        String query = "SELECT * FROM Daytrip, Review WHERE available_seats>0 AND title = daytrip_title"+dateQuery+locationQuery+timeQuery;
        ObservableList<Daytrip> daytripList;
        try {
            //Connect to DB, create statement, and execute statement
            connectToDatabase();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            daytripList = createDaytripObservableList(rs);
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
        populateRatingsForDaytrip(daytripList);
        populateActivitiesForDaytrip(daytripList);
        return  daytripList;//aðferð þar sem database managerinn fær reslutset og býr itl daytrip hlut.
    }

    public void populateReviewForDaytrip(Daytrip d) throws SQLException, ClassNotFoundException {
        String queryReview = "SELECT comment_text FROM Review WHERE daytrip_title ='"+d.getTitle()+"'";
        ObservableList<String> reviews = dbToObservableList(queryReview);
        d.setReviews(reviews);
    }

    public void populateHotelsForDaytrip(Daytrip d) throws SQLException, ClassNotFoundException {
        String query = "SELECT name FROM Hotel, Daytrip WHERE Daytrip.title ='"+d.getTitle()+"' AND Daytrip.title = Hotel.daytrip_title GROUP BY name";
        d.setHotels(dbToObservableList(query));
    }

    public void populateActivitiesForDaytrip(ObservableList<Daytrip> dl) throws SQLException, ClassNotFoundException {
        for(Daytrip d : dl) {
            String title = d.getTitle();
            String query = "SELECT name FROM Activity WHERE daytrip_title ='" + title + "'";
            ObservableList<String> activities = dbToObservableList(query);
            d.setActivities(activities);
        }
    }

    public void populateRatingsForDaytrip(ObservableList<Daytrip> dl) throws SQLException, ClassNotFoundException {
        for(Daytrip d : dl) {
            String title = d.getTitle();
            String query = "SELECT rating FROM Review WHERE daytrip_title ='" + title + "'";
            ObservableList<String> ratings = dbToObservableList(query);
            d.setRatings(ratings);
        }
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
            int availableSeats = rs.getInt(7);
            String location = rs.getString(8);
            Daytrip tempD = new Daytrip(title, date, starttime, endtime, desc, price, filename, availableSeats, location);   //búum til daytrip hlut og setjum allar uppllýsingrnarí svigann.
            dtList.add(tempD);        //setjum daytrip inn í lista dtList
        }
        return dtList;               //skilum fylkinu.
    }

    public void updateDaytripAvailability(Daytrip d) throws SQLException, ClassNotFoundException {
        String update = "UPDATE Daytrip SET available_seats = "+d.getAvailableSeats();
        String where = " WHERE title = '"+d.getTitle()+"' AND date_trip = '"+d.getLocalDate()+"' AND start_time = '"+d.getStartTime()+":00'";
        String query = update+where;
        runQuery(query);
    }

    private ObservableList<String> getNextNumber(String x) throws SQLException, ClassNotFoundException {
        String query = "SELECT COUNT(*) FROM "+x;
        return dbToObservableList(query);
    }

    public void registerCustomer(Customer c) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(getNextNumber("Customer").get(0))+1 ;
        String cID = String.format("%04d", id);
        String query = "INSERT INTO Customer VALUES ('"+cID+"','"+c.getName()+"','"+c.getEmail()+"','"+c.getPhone()+"',null)";
        runQuery(query);
    }

    public void registerBookingInCustomer(int bookingID, Customer c) throws SQLException, ClassNotFoundException {
        String query = "UPDATE Customer SET booking_number = '"+bookingID+"' WHERE name = '"+c.getName()+"' AND email = '"+c.getEmail()+"'";
        runQuery(query);
    }

    public void registerCustomerInBooking(String bookingNum, Customer c) throws SQLException, ClassNotFoundException {
        String query = "SELECT id FROM Customer WHERE name ='"+c.getName()+"' AND email = '"+c.getEmail()+"'";
        String id = dbToObservableList(query).get(0);
        String update = "UPDATE Booking SET cust_id = '"+id+"' WHERE num = "+bookingNum;
        runQuery(update);
    }

    public String registerBooking(Daytrip d, Customer c) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(getNextNumber("Booking").get(0))+1;
        String bID = String.format("%03d",id);
        String start = "INSERT INTO Booking VALUES ('"+bID+"',"+d.getBookedSeats()+",'";
        int totalCost = d.getBookedSeats()*d.getPrice();
        String where = d.getTitle()+"','"+d.getLocalDate()+"','"+d.getStartTime()+":00','"+d.getEndTime()+":00',"+d.getPrice()+",'"+d.getPickupLocation()+"',"+totalCost+",null)";
        String query = start+where;
        runQuery(query);
        registerBookingInCustomer(id,c);
        return bID;
    }

    public ObservableList<Booking> fetchBookingsForCustomer(Customer c) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM Booking, Customer WHERE cust_id = id AND ";
        String add = "Customer.name = '"+c.getName()+"' AND Customer.email = '"+c.getEmail()+"' AND Customer.phone = "+c.getPhone();
        Statement stmt = null;
        ResultSet rs = null;
        ObservableList<Booking> bookingList;
        try {
            //Connect to DB, create statement, and execute statement
            connectToDatabase();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query+add);
            bookingList = createBookingObservableList(rs);
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
        return bookingList;
    }

    public ObservableList<Booking> createBookingObservableList(ResultSet rs) throws SQLException {
        //finnum út hve mörg daytrip fyrlki við þurfum að búa til.
        ObservableList<Booking> bList = FXCollections.observableArrayList();
        while (rs.next()) {
            int bookedSeats = rs.getInt(2);
            String title = rs.getString(3);
            //náum í upplýsingar úr resultset línu.
            String tempDate = rs.getString(4);
            String tempStartTime = rs.getString(5);
            String tempEndtime = rs.getString(6);

            // convert String to LocalDate and LocalTime
            LocalDate date = toLocalDate(tempDate);
            LocalTime starttime = toLocalTime(tempStartTime);
            LocalTime endtime = toLocalTime(tempEndtime);

            int price = rs.getInt(7);
            String hotel = rs.getString(8);
            int totalCost = rs.getInt(9);

            Booking tempB = new Booking(bookedSeats, title, date, starttime, endtime, price, hotel, totalCost);
            bList.add(tempB);        //setjum daytrip inn í lista dtList
        }
        return bList;               //skilum fylkinu.
    }
}
