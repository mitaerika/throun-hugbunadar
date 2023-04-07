package sample.Vinnsla;


import sample.Vidmot.DaytripController;
import java.time.LocalDate;
import java.time.LocalTime;

public class Daytrip extends DaytripController {
    String dTitle;
    LocalDate date;
    LocalTime start_time;
    LocalTime end_time;
    String description;
    int price;
    String photo;
    int available_seats;
    int booked_seats = 0;
    String location;
    String[] reviews;
    double rating;
    String[] hotels;
    String[] activity;
    public Daytrip(String dTitle1, LocalDate date1, LocalTime start_time1, LocalTime end_time1, String description1, int price1, String photo1, int available_seats1, String location1, String[] reviews, double rating, String[] hotels, String[] activity) {
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
        this.hotels = hotels;
        this.activity = new String[activity.length];
        this.activity = activity;
    }

    public String getTitle() {
        return this.dTitle;
    }
    public String[] getReviews() {
        return this.reviews;
    }
    public void setReviews(String[] r) {
        this.reviews = r;
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
    public String[] getHotels() {
        return hotels;
    }
    public String getLocation() {
        return location;
    }
    public void setPrice(int newPrice) {
        this.price = newPrice;
    }

    public String getDate() {
        int m = this.date.getMonthValue();
        String mon = "";
        switch (m) {
            case 1:
                mon = "janúar";
                break;
            case 2:
                mon = "febrúar";
                break;
            case 3:
                mon = "mars";
                break;
            case 4:
                mon = "apríl";
                break;
            case 5:
                mon = "maí";
                break;
            case 6:
                mon = "júní";
                break;
            case 7:
                mon = "júlí";
                break;
            case 8:
                mon = "ágúst";
                break;
            case 9:
                mon = "september";
                break;
            case 10:
                mon = "október";
                break;
            case 11:
                mon = "nóvember";
                break;
            case 12:
                mon = "desember";
                break;
        }
        String ret = this.date.getDayOfMonth()+". "+mon+" "+this.date.getYear();
        return ret;
    }

    public String getPhoto(){
        return this.photo;
    }

    //only register booked_seats, not taking away the seats from available_seats
    public void setBooked_seats(int n){
        booked_seats = n;
    }

    public int getBooked_seats(){
        return booked_seats;
    }
}


