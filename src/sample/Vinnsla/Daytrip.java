package sample.Vinnsla;


import javafx.collections.ObservableList;
import sample.Vidmot.DaytripController;
import java.time.LocalDate;
import java.time.LocalTime;

public class Daytrip extends DaytripController {
    private String title;
    private LocalDate date;
    private LocalTime start_time;
    private LocalTime end_time;
    private String description;
    private int price;
    private String photo;
    private int available_seats;
    private int booked_seats = 0;
    private String location;
    private String[] reviews;
    private double avgRating;
    private String pickupLocation;
    private ObservableList<String> hotels;
    private String[] activity;
    private int[] ratings;

    public Daytrip(String title, LocalDate date, LocalTime start_time1, LocalTime end_time1, String description1, int price1, String photo1, int available_seats1, String location1, String[] reviews, double avgRating, String[] activity) {
        this.title = title;
        this.date = date;
        this.start_time = start_time1;
        this.end_time = end_time1;
        this.description = description1;
        this.price = price1;
        this.photo = photo1;
        this.available_seats = available_seats1;
        this.location = location1;
        this.reviews = reviews;
        this.avgRating = avgRating;
        this.activity = new String[activity.length];
        this.activity = activity;
    }

    public String getTitle() {
        return this.title;
    }
    public String[] getReviews() {
        return this.reviews;
    }
    public void setReviews(String[] r) {
        this.reviews = r;
    }
    public double getAvgRating() { return this.avgRating; }

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
    public void setHotels(ObservableList<String> hotels) {
        this.hotels = hotels;
    }
    public ObservableList<String> getHotels() {
        return this.hotels;
    }
    public String getLocation() {
        return location;
    }
    public String getDate() {
        int m = this.date.getMonthValue();
        String mon = switch (m) {
            case 1 -> "janúar";
            case 2 -> "febrúar";
            case 3 -> "mars";
            case 4 -> "apríl";
            case 5 -> "maí";
            case 6 -> "júní";
            case 7 -> "júlí";
            case 8 -> "ágúst";
            case 9 -> "september";
            case 10 -> "október";
            case 11 -> "nóvember";
            case 12 -> "desember";
            default -> "";
        };
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

    public void setPickupLocation(String pickupLocation){
        this.pickupLocation = pickupLocation;
    }

    public String getPickupLocation(){
        return pickupLocation;
    }

    public void setRatings(int[] ratings) {
        this.ratings = ratings;
    }

    public int[] getRatings() {
        return this.ratings;
    }

}


