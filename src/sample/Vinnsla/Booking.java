/******************************************************************************
 *  Nafn    : Ásdís, Mita, Sigga og Jökull
 *  T-póstur: asv29@hi.is
 *
 *  Lýsing  : Bókunin gerist hér.
 *
 *
 *****************************************************************************/

package sample.Vinnsla;

import sample.Vidmot.BookingController;

public class Booking extends BookingController {
    private Daytrip daytrip;
    private Customer customer;

    public Daytrip getDaytrip() {
        return daytrip;
    }

    public void setDaytrip(Daytrip daytrip) {
        this.daytrip = daytrip;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    int number;
    int booked_seats;
    int total_cost;
    public Booking(int number, int booked_seats, int total_cost, Daytrip daytrip, Customer customer){
        this.number = number;
        this.booked_seats = booked_seats;
        this.total_cost = total_cost;
        this.daytrip = daytrip;
        this.customer = customer;
    }
}
