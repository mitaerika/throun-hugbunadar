package sample.Vinnsla;

import sample.Vidmot.DaytripController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

public class Daytrip extends DaytripController {
    String dTitle;
    String date;
    String start_time;
    String end_time;
    String description;
    int price;
    String photo;
    int available_seats;
    String location;
    String reviews;
    int rating;
    final String[] activity = new String[]{"Activity1", "Activity2", "Activity3"};
    final String[] hotel = new String[]{"Hotel1", "Hotel2", "Hotel3"};
    public Daytrip(String dTitle1, String date1, String start_time1, String end_time1, String description1, int price1, String photo1, int available_seats1, String location1, String reviews, int rating) {
        this.dTitle = dTitle1;
        this.date = date1;
        this.start_time = start_time1;
        this.end_time = end_time1;
        this.description = description1;
        this.price = price1;
        this.photo = photo1;
        this.available_seats = available_seats1;
        this.location = location1;
        this.reviews = reviews;
        this.rating = rating;
    }

    public Daytrip(String title, String date, String starttime, String endtime, String desc, int price, String filename, int available_seats, String activity, String location, String hotel, Calendar cal, SimpleDateFormat sdf) {
        super();
    }

    public String getTitle() {
        return this.dTitle;
    }
    public String getReviews() {
        return this.reviews;
    }
    public int getRating() {
        //Meðal einkunn
        //köllum á einhverja aðferð úr database manager
        return this.rating;
    }
    public int getPrice() {
        return this.price;
    }
    public String getStartTime() {
        return this.start_time;
    }
    public String getEnd_time() {
        return this.end_time;
    }
    public String getDescription() {
        return this.description;
    }
    public int getAvailable_seats() {
        return this.available_seats;
    }
    public String[] getActivity() {
        return activity;
    }
    public String[] getHotel() {
        return hotel;
    }
    public String getLocation() {
        return location;
    }
    public void setPrice(int newPrice) {
        this.price = newPrice;
    }
}


