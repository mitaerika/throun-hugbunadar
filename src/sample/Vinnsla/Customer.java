/******************************************************************************
 *  Nafn    : Ásdís, Mita, Sigga og Jökull
 *  T-póstur: asv29@hi.is
 *
 *  Lýsing  : Notandinn mun veita upplýsingar um sjálfan sig þegar hann bókar
 *  dagsferðir sínar. Þetta gerist í lokinn.
 *
 *
 *****************************************************************************/

package sample.Vinnsla;

import java.util.ArrayList;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;
    private Booking bookings;

    public Customer(int id, String name, String email, String phone, Booking bookings) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.bookings = bookings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Booking getBookings() {
        return bookings;
    }

    public void setBookings(Booking bookings) {
        this.bookings = bookings;
    }
}
