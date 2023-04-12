package sample.Vinnsla;

import com.sun.javafx.binding.StringFormatter;

public class Customer {
    int id = 0;
    String name;
    String email;
    String phone;
    Booking[] bookings;

    public Customer(String name, String email, String phone) {
    this.id = this.id+1;
    this.name = name;
    this.email = email;
    this.phone = phone;
    }

    public void setBookings(Booking[] bookings) {
        this.bookings = bookings;
    }

    public String getID(){
        return String.format("%04d",id);
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
}
