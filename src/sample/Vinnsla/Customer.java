package sample.Vinnsla;

import javafx.collections.ObservableList;

public class Customer {
    String name;
    String email;
    String phone;
    ObservableList<Booking> bookings;

    public Customer(String name, String email, String phone) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    }

    public void setBookings(ObservableList<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

    public ObservableList<Booking> getBookings() {
        return this.bookings;
    }
}
