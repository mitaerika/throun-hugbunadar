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
