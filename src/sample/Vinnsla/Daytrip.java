package sample.Vinnsla;

import java.util.Date;

public class Daytrip {
    String dTitle;
    Date date;
    Date start_time;
    Date end_time;
    String description;
    int price;
    String photo;
    int available_seats;
    //Vantar ennþá activity, location, review og hotel.
    public void Datrip(String dTitle1, Date date1, Date start_time1, Date end_time1, String description1, int price1, String photo1, int available_seats1) {
        dTitle = dTitle1;
        date = date1;
        start_time = start_time1;
        end_time = end_time1;
        description = description1;
        price = price1;
        photo = photo1;
        available_seats = available_seats1;
    }
}


