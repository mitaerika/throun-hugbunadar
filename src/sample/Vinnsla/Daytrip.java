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
    Review[] reviews;
    //Vantar ennþá activity, location, review og hotel.
    public Daytrip(String dTitle1, Date date1, Date start_time1, Date end_time1, String description1, int price1, String photo1, int available_seats1, String location1, Review[] reviews) {
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
    public Review[] getReviews() {
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

}


