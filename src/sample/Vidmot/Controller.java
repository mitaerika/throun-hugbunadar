package sample.Vidmot;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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


    private Daytrip dagsferd;

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
            locationPicker.getItems().removeAll(locationPicker.getItems());
            locationPicker.getItems().addAll("Norðaustur","Norðvestur", "Suður", "Suðvestur");
    }

    /**
     * Þetta er handler fyrir að raða dagsferðum frá hæsta verði í það lægsta.
     * @param event sér um að breyta dagsferðunum.
     */
    public void verdAscend(ActionEvent event) {
        if(priceAscending.isSelected()){
            System.err.println("ascend verd alert");
        }

    }

    /**
     * Þetta er handler fyrir að raða dagsferðum frá lægsta verði í það hæsta.
     * @param event sér um að breyta dagsferðunum.
     */
    public void verdDescend(ActionEvent event) {
        if(priceDescending.isSelected()){
            System.err.println("descend verd alert");
        }
    }

    /**
     * Þetta er handler fyrir að raða dagsferðum frá hæstu einkunn í þá lægstu.
     * @param event sér um að breyta dagsferðunum.
     */
    public void einkunnDescend(ActionEvent event) {
        if(ratingDescending.isSelected()){
            System.err.println("descend einkunn alert");
        }

    }

    /**
     * Þetta er handler fyrir að raða dagsferðum frá lægstu einkunn í þá hæstu.
     * @param event sér um að breyta dagsferðunum.
     */
    public void einkunnAscend(ActionEvent event) {
        if(ratingAscending.isSelected()){
            System.err.println("rating ascend alert");
        }

    }

    /**
     * Þetta er handler fyrir að velja dagsferðir útfrá staðsetningu sinni.
     * @param event sér um að breyta dagsferðunum.
     */
    public void filterLocation(ActionEvent event){
        if(locationPicker.isPressed()){
            System.err.println("Nú á að fara að velja einhverja staðsetningu");
        }
    }

    /**
     * Þetta er handler sem að mun sjá um allt sem hinir handlerarnir eru að gera, nema að
     * núna munu hlutir í rauninnni breytast í listView.
     * @param event sér um að sía út og raða dagsferðunum.
     */
    public void threngjaLeit(ActionEvent event){
        if(filterButton.isPressed()){
            System.err.println("Allir handlerar sameinast hér. ");
        }
    }
}
