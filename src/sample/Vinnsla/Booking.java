package sample.Vinnsla;

public class Booking {
    int number;
    int booked_seats;
    int total_cost;
    Review review;
    Daytrip daytrip;
    Customer customer;
    public Booking(int number, int booked_seats, int total_cost, Review review, Daytrip daytrip, Customer customer){
        this.number = number;
        this.booked_seats = booked_seats;
        this.total_cost = total_cost;
        this.review = review;
        this.daytrip = daytrip;
        this.customer = customer;
    }
}