package sample.Vinnsla;

public class Booking extends BookingController{
    int number;
    int booked_seats;
    int total_cost;
    Daytrip[] daytrip;
    Customer customer;
    public Booking(int number, int booked_seats, int total_cost, Daytrip[] daytrip, Customer customer){
        this.number = number;
        this.booked_seats = booked_seats;
        this.total_cost = total_cost;
        this.daytrip = daytrip;
        this.customer = customer;
    }
}
