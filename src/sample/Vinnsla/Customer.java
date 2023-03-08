package sample.Vinnsla;

public class Customer {
    int id;
    String name;
    String email;
    String phone;
    Booking[] bookings;
    public Customer(int id, String name, String email, String phone, Booking[] bookings) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.bookings = bookings;
    }


}
