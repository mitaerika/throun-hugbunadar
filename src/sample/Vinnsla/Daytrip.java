package sample.Vinnsla;

import java.util.Date;

public class Daytrip extends DaytripController{
    String dTitle;
    Date date;
    Date start_time;
    Date end_time;
    String description;
    int price;
    String photo;
    int available_seats;
    String location;
    String reviews;
    final String[] activity = new String[]{"Activity1", "Activity2", "Activity3"};
    final String[] hotel = new String[]{"Hotel1", "Hotel2", "Hotel3"};
    public Daytrip(String dTitle1, Date date1, Date start_time1, Date end_time1, String description1, int price1, String photo1, int available_seats1, String location1, String reviews) {
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
    }
    public String getdTitle() {
        return this.dTitle;
    }
    public String getReviews() {
        return this.reviews;
    }
    public int getPrice() {
        return this.price;
    }
    public Date getStartTime() {
        return this.start_time;
    }
    public Date getEnd_time() {
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

}


