package sample.Vinnsla;

import javafx.collections.ObservableList;

public class Customer {
    int id;
    String name;
    String email;
    String phone;
    ObservableList<Booking> bookings;

    public Customer(int id, String name, String email, String phone, ObservableList<Booking> bookings) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.bookings = bookings;
    }
    public ObservableList<Booking> getBookings (Customer customer) {
        return this.bookings;
    }

}
