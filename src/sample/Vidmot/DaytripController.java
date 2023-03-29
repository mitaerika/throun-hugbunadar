package sample.Vidmot;

import javafx.collections.transformation.FilteredList;
import sample.Vinnsla.Daytrip;
import javafx.collections.ObservableList;
import java.util.Comparator;
import java.util.Iterator;

public class DaytripController {
    Comparator<Daytrip> comparatorPrice = Comparator.comparingInt(Daytrip::getPrice);
    Comparator<Daytrip> comparatorRating = Comparator.comparingDouble(Daytrip::getRating);

    public ObservableList<Daytrip> sortByPrice(ObservableList<Daytrip> daytrips, Boolean descending) {
        if (descending) {
            daytrips.sort(comparatorPrice.reversed());
            return daytrips;
        }
        daytrips.sort(comparatorPrice);
        return daytrips;
    }

    public ObservableList<Daytrip> sortByRating(ObservableList<Daytrip> daytrips, Boolean descending) {
        if(descending){
            daytrips.sort(comparatorRating.reversed());
            return daytrips;
        }
        daytrips.sort(comparatorRating);
        return daytrips;
    }

    public ObservableList<Daytrip> filterByLocation(ObservableList<Daytrip> daytrips, String location){
        // Filter ObservableList by the search query
        FilteredList<Daytrip> filteredList = daytrips.filtered((daytrip) -> daytrip.getLocation().toLowerCase().equals(location.toLowerCase()));
        return filteredList;
    }
    public ObservableList<Daytrip> filterByActivity(String activity, ObservableList<Daytrip> daytrips) {

        //FilteredList<Daytrip> filteredList = daytrips.filtered((daytrip) -> daytrips.forEach(daytrip.getActivity());
        return daytrips;
    }
    public void addToCart(Daytrip daytrip, int Seats) {
        //Eftir að koma kóði
    }


}
