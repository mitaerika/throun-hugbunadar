package sample.Vinnsla;

import sample.Vidmot.BookingController;

import java.time.LocalDate;

public class Booking extends BookingController {
    int id = 0;
    int bookedSeats;
    int totalCost;
    Daytrip daytrip;
    Customer customer;
    public Booking(int bookedSeats, int totalCost, Daytrip daytrip){
        this.id++;
        this.bookedSeats = bookedSeats;
        this.totalCost = totalCost;
        this.daytrip = daytrip;
    }
    public String getID(){
        return String.format("%03d",id);
    }
    public int getBookedSeats(){
        return this.bookedSeats;
    }
    public String getTitle(){
        return this.daytrip.getTitle();
    }
    public String getLocalDate(){
        return this.daytrip.getLocalDate();
    }
    public String getStartTime(){
        return this.daytrip.getStartTime();
    }
    public String getEndTime(){
        return this.daytrip.getEndTime();
    }
    public int getPrice(){
        return this.daytrip.getPrice();
    }
    public String getHotel(){
        return this.daytrip.getPickupLocation();
    }
    public int getTotalCost(){
        return getPrice()*getBookedSeats();
    }
    public String getCustomerId(){
        return this.customer.getID();
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
}
