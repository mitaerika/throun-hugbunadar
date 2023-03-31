package sample.Vidmot;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.Vinnsla.DatabaseManager;
import sample.Vinnsla.Daytrip;

import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    private RadioButton morning;
    @FXML
    private RadioButton afternoon;
    @FXML
    private RadioButton night;

    @FXML
    private DatePicker datePicker;
    @FXML
    private ComboBox<String> locationPicker;

    @FXML
    private Button filterButton;

    @FXML
    private RadioButton priceDescending;
    @FXML
    private RadioButton priceAscending;
    @FXML
    private RadioButton ratingDescending;
    @FXML
    private RadioButton ratingAscending;

    @FXML
    private Button finalizeBooking;

    @FXML
    private ListView<String> myListView;

        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            DatabaseManager dbm = new DatabaseManager();
            ObservableList<String> list = FXCollections.observableArrayList();
            ;//hér tengjum við gagnagrunninn við okkar forrit og náum í allar upplýsingar um daytrip. Við fáum til baka result set í main og færum það yfir í database managerinn.
            try {
                ObservableList<Daytrip> trips = dbm.fetchAvailableDaytrips();
                for (Daytrip trip : trips) {
                   // System.err.println(trip.getLocation());
                    list.add(trip.getTitle());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            myListView.setItems(list);
        System.out.println("list populated");
    }
}
