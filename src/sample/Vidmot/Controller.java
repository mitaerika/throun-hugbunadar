package sample.Vidmot;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import sample.Vinnsla.DatabaseManager;
import sample.Vinnsla.Daytrip;

import javax.swing.event.ChangeEvent;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    @FXML
    private VBox activityBox;

    private Daytrip dagsferd;
    private DatabaseManager dbm;
    private ObservableList<String> selectedActivity;
    private String selectedLocation;
    private LocalDate selectedDate;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            dbm = new DatabaseManager();
            populateListView();
            populateComboBox();
            populateCheckBox();
    }

    private void populateListView(){
        ObservableList<String> list = FXCollections.observableArrayList();
        //hér tengjum við gagnagrunninn við okkar forrit og náum í allar upplýsingar um daytrip. Við fáum til baka result set í main og færum það yfir í database managerinn.
        try {
            ObservableList<Daytrip> trips = dbm.fetchAvailableDaytrips();
            for (Daytrip trip : trips) {
                list.add(trip.getTitle() + " " + trip.getStartTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        myListView.setItems(list);
    }

    private void populateComboBox() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            list = dbm.fetchAvailableLocations();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        locationPicker.getItems().removeAll(locationPicker.getItems());
        locationPicker.getItems().addAll(list);
    }

    private void populateCheckBox() {
        ObservableList<String> list;
        try {
            list = dbm.fetchAvailableActivities();
            int i = 0;
            for(String act : list){
                CheckBox cb = new CheckBox();
                cb.setText(act);
                cb.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                        selectedActivity.add(cb.getText());
                    }
                });
                activityBox.getChildren().add(cb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Þetta er handler fyrir að raða dagsferðum frá hæsta verði í það lægsta.
     * @param priceEventA sér um að breyta dagsferðunum.
     */
    public void verdAscend(ActionEvent priceEventA) {
        if(priceAscending.isSelected()){
            System.err.println("ascend verd alert");
        }
    }

    /**
     * Þetta er handler fyrir að raða dagsferðum frá lægsta verði í það hæsta.
     * @param verdEventD sér um að breyta dagsferðunum.
     */
    public void verdDescend(ActionEvent verdEventD) {
        if(priceDescending.isSelected()){
            System.err.println("descend verd alert");
        }
    }

    /**
     * Þetta er handler fyrir að raða dagsferðum frá hæstu einkunn í þá lægstu.
     * @param einkunnEventD sér um að breyta dagsferðunum.
     */
    public void einkunnDescend(ActionEvent einkunnEventD) {
        if(ratingDescending.isSelected()){
            System.err.println("descend einkunn alert");
        }
    }

    /**
     * Þetta er handler fyrir að raða dagsferðum frá lægstu einkunn í þá hæstu.
     * @param einkunnEventA sér um að breyta dagsferðunum.
     */
    public void einkunnAscend(ActionEvent einkunnEventA) {
        if(ratingAscending.isSelected()){
            System.err.println("rating ascend alert");
        }

    }

    /**
     * Þetta er handler fyrir að velja dagsferðir útfrá staðsetningu sinni.
     * @param filterEvent sér um að breyta dagsferðunum.
     */
    public void filterLocation(ActionEvent filterEvent){
        selectedLocation = locationPicker.getValue();
        System.out.println(selectedLocation+" was selected as preferred location");
    }

    /**
     * Þetta er handler fyrir að velja dagsferðir útfrá dagsetningu sem notandinn valdi.
     * @param actionEvent sér um breytingar sem var gerðar á datePicker.
     */
    public void filterDate(ActionEvent actionEvent) {
        selectedDate = datePicker.getValue();
        System.out.println("Selected date is: "+selectedDate);
    }

    /**
     * Þetta er handler sem að mun sjá um allt sem hinir handlerarnir eru að gera, nema að
     * núna munu hlutir í rauninnni breytast í listView.
     * @param threngjaEvent sér um að sía út og raða dagsferðunum.
     */
    public void threngjaLeit(ActionEvent threngjaEvent){
        if(filterButton.isPressed()){
            System.err.println("Allir handlerar sameinast hér. ");
        }
    }

}
