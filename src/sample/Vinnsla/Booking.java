package sample.Vinnsla;

import sample.Vidmot.BookingController;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking extends BookingController {
    private int bookedSeats;
    private int totalCost;
    private String title;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int price;
    private String hotel;
    private Customer customer;

    public Booking(int bookedSeats, String title, LocalDate date, LocalTime startTime, LocalTime endTime, int price, String hotel, int totalCost) {
        this.bookedSeats = bookedSeats;
        this.title = title;
        this.totalCost = totalCost;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.hotel = hotel;
        this.totalCost = totalCost;
    }

    public int getBookedSeats(){
        return this.bookedSeats;
    }
    public String getTitle(){
        return this.title;
    }
    public String getDate(){ return this.date.toString(); }
    public String getStartTime(){
        return this.startTime.toString();
    }
    public String getEndTime(){
        return this.endTime.toString();
    }
    public int getPrice(){
        return this.price;
    }
    public String getHotel(){
        return this.hotel;
    }
    public int getTotalCost(){
        return this.totalCost;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
}
