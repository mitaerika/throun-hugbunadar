package sample.Vinnsla;

import javafx.scene.image.Image;
import sample.Vidmot.DaytripController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

public class Daytrip extends DaytripController {
    String dTitle;
    LocalDate date;
    LocalTime start_time;
    LocalTime end_time;
    String description;
    int price;
    Image photo;
    int available_seats;
    String location;
    String[] reviews;
    double rating;
    String[] hotels = new String[3];
    final String[] activity = new String[]{"Activity1", "Activity2", "Activity3"};
    public Daytrip(String dTitle1, LocalDate date1, LocalTime start_time1, LocalTime end_time1, String description1, int price1, String photo1, int available_seats1, String location1, String[] reviews, double rating, String[] hotels) {
        this.dTitle = dTitle1;
        this.date = date1;
        this.start_time = start_time1;
        this.end_time = end_time1;
        this.description = description1;
        this.price = price1;
        this.photo = new Image(photo1);
        this.available_seats = available_seats1;
        this.location = location1;
        this.reviews = reviews;
        this.rating = rating;
        this.hotels = hotels;
    }

    public Daytrip(String title, LocalDate date, LocalTime starttime, LocalTime endtime, String desc, int price, String filename, int available_seats, String activity, String location, String[] reviews, double rating, String[] hotels) {
        super();
    }

    public String getTitle() {
        return this.dTitle;
    }
    public String[] getReviews() {
        return this.reviews;
    }
    public double getRating() { return this.rating; }
    public int getPrice() {
        return this.price;
    }
    public String getStartTime() {
        return this.start_time.toString();
    }
    public String getEnd_time() {
        return this.end_time.toString();
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
        return hotels;
    }
    public String getLocation() {
        return location;
    }
    public void setPrice(int newPrice) {
        this.price = newPrice;
    }
}


