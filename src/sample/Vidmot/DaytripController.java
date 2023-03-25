package sample.Vidmot;

import javafx.collections.transformation.FilteredList;
import sample.Vinnsla.Daytrip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Comparator;
import java.util.Locale;

public class DaytripController {
    Comparator<Daytrip> comparatorPrice = Comparator.comparingInt(Daytrip::getPrice);
    Comparator<Daytrip> comparatorRating = Comparator.comparingInt(Daytrip::getRating);

    public ObservableList<Daytrip> sortByPrice(ObservableList<Daytrip> daytrips, Boolean upOrDown) {
        if (upOrDown) {
            daytrips.sort(comparatorPrice.reversed());
            return daytrips;
        }
        daytrips.sort(comparatorPrice);
        return daytrips;
    }

    public ObservableList<Daytrip> sortByRating (ObservableList<Daytrip> daytrips, Boolean upOrDown) {
        if(upOrDown){
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

}
