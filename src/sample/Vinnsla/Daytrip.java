/******************************************************************************
 *  Nafn    : Ásdís, Mita, Sigga og Jökull
 *  T-póstur: asv29@hi.is
 *
 *  Lýsing  : KLasinn heldur utan um hvað á að vera í hverri einustu dagsferð.
 *  Í dagsferð er titil, dagsetning, upphafs- og endatími, lýsing, verð,
 *  mynd af staðnum, laus sæti, staðsetning, endurgjöf, einkunn, hótel og
 *  athafnir.
 *
 *
 *****************************************************************************/

package sample.Vinnsla;

import sample.Vidmot.DaytripController;
import java.time.LocalDate;
import java.time.LocalTime;


public class Daytrip extends DaytripController {

    private String dTitle;
    private LocalDate date;
    private LocalTime start_time;
    private LocalTime end_time;
    private String description;
    private int price;
    private String photo;
    private int available_seats;
    private String location;
    private String[] reviews;
    private double rating;
    private  String[] hotels;
    private final String[] activity = new String[]{"Activity1", "Activity2", "Activity3"};


    public Daytrip(String dTitle, LocalDate date, LocalTime start_time, LocalTime end_time, String description, int price, String photo, int available_seats, String location, String[] reviews, double rating, String[] hotels) {
        this.dTitle = dTitle;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.description = description;
        this.price = price;
        this.photo = photo;
        this.available_seats = available_seats;
        this.location = location;
        this.reviews = reviews;
        this.rating = rating;
        this.hotels = hotels;
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
    public String[] getActivity() { return this.activity;}
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


