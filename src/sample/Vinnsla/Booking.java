package sample.Vinnsla;

import sample.Vidmot.BookingController;

public class Booking extends BookingController {
    int booked_seats;
    int total_cost;
    Daytrip[] daytrip;
    Customer customer;
    public Booking(int booked_seats, int total_cost, Daytrip[] daytrip, Customer customer){
        this.booked_seats = booked_seats;
        this.total_cost = total_cost;
        this.daytrip = daytrip;
        this.customer = customer;
    }
}
