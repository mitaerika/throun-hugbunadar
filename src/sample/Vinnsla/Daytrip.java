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
    private int availableSeats;
    private int bookedSeats = 0;
    private String location;
    private double avgRating;
    private String pickupLocation;
    private ObservableList<String> hotels;
    private ObservableList<String> activities;
    private ObservableList<String> ratings;
    private ObservableList<String> reviews;

    public Daytrip(String title, LocalDate date, LocalTime start_time, LocalTime end_time, String description, int price, String photo, int availableSeats, String location) {
        this.title = title;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.description = description;
        this.price = price;
        this.photo = photo;
        this.availableSeats = availableSeats;
        this.location = location;
    }

    public String getTitle() {
        return this.title;
    }
    public ObservableList<String> getReviews() {
        return this.reviews;
    }
    public void setReviews(ObservableList<String> reviews) {
        this.reviews = reviews;
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
    public int getAvailableSeats() {
        return this.availableSeats;
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
    public void setBookedSeats(int n){
        bookedSeats = n;
    }

    public int getBookedSeats(){
        return bookedSeats;
    }

    public void setPickupLocation(String pickupLocation){
        this.pickupLocation = pickupLocation;
    }

    public String getPickupLocation(){
        return pickupLocation;
    }
    public void setRatings(ObservableList<String> ratings) {
        this.ratings = ratings;
        calculateAverageRating();
    }

    private void calculateAverageRating(){
        double rating = 0.0;
        int n = 0;
        for(String r: ratings){
            rating += Double.parseDouble(r);
            n++;
        }
        this.avgRating = rating/n;
    }

    public ObservableList<String> getRatings() {
        return this.ratings;
    }
    public void setActivities(ObservableList<String> activities){
        this.activities = activities;
    }
    public ObservableList<String> getActivities(){
        return this.activities;
    }
    public void reduceAvailableSeats(){
        availableSeats -= bookedSeats;
    }
}


