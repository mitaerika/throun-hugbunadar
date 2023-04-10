package sample.Vidmot;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Vinnsla.DatabaseManager;
import sample.Vinnsla.Daytrip;
import sample.Vinnsla.DaytripListCell;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class Controller extends DaytripController implements Initializable {
    @FXML
    private DatePicker datePicker;
    @FXML
    private ComboBox<String> locationPicker;
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
    private ListView<Daytrip> myListView;
    @FXML
    private ListView<Daytrip> cartListView;
    @FXML
    private VBox activityBox;

    private final Label EMPTY = new Label("Engar niðurstöður fundust fyrir gefnar kröfur");
    private final Label EMPTYCART = new Label("Engar ferðir í körfu, veldu ferð til að bóka");
    private ObservableList<Daytrip> daytripList = FXCollections.observableArrayList();
    private ObservableList<Daytrip> cartList = FXCollections.observableArrayList();
    private ObservableList<CheckBox> cbList;
    private DatabaseManager dbm;
    private final ObservableList<String> selectedActivity = FXCollections.observableArrayList();
    private String selectedLocation;
    private LocalDate selectedDate;
    private String selectedTime;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            dbm = new DatabaseManager();
            populateListView();
            populateComboBox();
            populateCheckBox();
    }

    /**
     * Tengja ListView við ObservableList
     */
    private void populateListView(){
        cartListView.setPlaceholder(EMPTYCART);
        cartListView.setCellFactory(param -> new DaytripListCell(){
            @Override
            protected void updateItem(Daytrip d, boolean empty) {
                super.updateItem(d, empty);
                if (!empty || d!=null) {
                    int pax = d.getBookedSeats();
                    int p = d.getPrice();
                    title.setText(d.getTitle() + " x "+ pax +" sæti");
                    date.setText(d.getDate());
                    price.setText("Verð: "+ p +" x "+ pax + " = " + pax*p);
                    time.setText(" kl. "+d.getStartTime());
                    extra.setText("Sótt frá: "+d.getPickupLocation());
                    setGraphic(layout);
                }
        }});
        myListView.setCellFactory(param -> new DaytripListCell());
        try {
            daytripList.clear();
            daytripList = dbm.fetchAvailableDaytrips();
            myListView.setItems(daytripList);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Uppfæra leitarniðurstöður eftir að notandinn valdi dagsetningu, landshluta, tegund afþreyingar og/eða tímasetningu
     * 1. Tengja við gagnagrunn og fá niðurstöðu úr sql skipuninni
     * 2. Setja ferðir sem passar við tegund afþreyingar
     * 3. Ef ekkert fannst fyrir leitarkröfur, setja skilaboð sem segir svo
     * Annars, sýna leitar niðurstöðurnar
     */
    private void updateListView(){
        try {
            myListView.setPlaceholder(null);
            ObservableList<Daytrip> filteredResult = dbm.fetchFilteredDaytrips(selectedDate,selectedLocation,selectedTime);
            daytripList.clear();
            if(!selectedActivity.isEmpty()) {
                for(int i = 0; i < filteredResult.size(); i++){
                    Daytrip dt = filteredResult.get(i);
                    if(dt.getActivities().containsAll(selectedActivity)) daytripList.add(dt);
                }
            } else daytripList = filteredResult;
            if(daytripList.isEmpty()) myListView.setPlaceholder(EMPTY);
            else myListView.setItems(daytripList);
            myListView.setCellFactory(param -> new DaytripListCell());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tengja við gagnagrunn, finna allar staðsetningar sem eru í boði, setja það í ComboBox
     */
    private void populateComboBox() {
        ObservableList<String> locationList = FXCollections.observableArrayList();
        try {
            locationList = dbm.fetchAvailableLocations();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        locationPicker.getItems().removeAll(locationPicker.getItems());
        locationPicker.getItems().addAll(locationList);
    }

    /**
     * Tengja við gagnagrunn, finna allar afþreyingar sem eru í boði, setja það í CheckBox og lista af CheckBox
     */
    private void populateCheckBox() {
        ObservableList<String> activityList;
        try {
            activityList = dbm.fetchAvailableActivities();
            cbList = FXCollections.observableArrayList();
            for(String activity : activityList){
                CheckBox cb = new CheckBox();
                cb.setText(activity);
                cbList.add(cb);
                VBox.setMargin(cb, new Insets(3,3,3,3));
                activityBox.getChildren().add(cb);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Þetta er handler fyrir að raða dagsferðum frá hæsta verði í það lægsta.
     * @param priceEventA sér um að breyta dagsferðunum.
     */
    public void verdAscend(ActionEvent priceEventA) {
        if(priceAscending.isSelected()){
            ObservableList<Daytrip> sortedByPriceAscending = sortByPrice(daytripList, false);
            myListView.setItems(sortedByPriceAscending);
        }
    }

    /**
     * Þetta er handler fyrir að raða dagsferðum frá lægsta verði í það hæsta.
     * @param verdEventD sér um að breyta dagsferðunum.
     */
    public void verdDescend(ActionEvent verdEventD) {
        if(priceDescending.isSelected()){
            ObservableList<Daytrip> sortedByPriceDescending = sortByPrice(daytripList, true);
            myListView.setItems(sortedByPriceDescending);
        }
    }

    /**
     * Þetta er handler fyrir að raða dagsferðum frá hæstu einkunn í þá lægstu.
     * @param einkunnEventD sér um að breyta dagsferðunum.
     */
    public void einkunnDescend(ActionEvent einkunnEventD) {
        if(ratingDescending.isSelected()){
            ObservableList<Daytrip> sortedByRatingDescending = sortByRating(daytripList, true);
            myListView.setItems(sortedByRatingDescending);
        }
    }

    /**
     * Þetta er handler fyrir að raða dagsferðum frá lægstu einkunn í þá hæstu.
     * @param einkunnEventA sér um að breyta dagsferðunum.
     */
    public void einkunnAscend(ActionEvent einkunnEventA) {
        if(ratingAscending.isSelected()){
            ObservableList<Daytrip> sortedByRatingAscending = sortByRating(daytripList, false);
            myListView.setItems(sortedByRatingAscending);
        }
    }

    /**
     * Þetta er handler fyrir að velja dagsferðir útfrá staðsetningu sinni.
     * @param filterEvent sér um að breyta dagsferðunum.
     */
    public void filterLocation(ActionEvent filterEvent){
        selectedLocation = locationPicker.getValue();
    }

    /**
     * Þetta er handler fyrir að velja dagsferðir útfrá dagsetningu sem notandinn valdi.
     * @param actionEvent sér um breytingar sem var gerðar á datePicker.
     */
    public void filterDate(ActionEvent actionEvent) {
        selectedDate = datePicker.getValue();
    }

    /**
     * Handler fyrir RadioButton sem sér um tímasetningu
     * @param actionEvent sér um að setja tímasetningu sem notandinn valdi
     */
    public void morningSelected(ActionEvent actionEvent) {
        selectedTime = "morning";
    }
    public void afternoonSelected(ActionEvent actionEvent) {
        selectedTime = "afternoon";
    }
    public void eveningSelected(ActionEvent actionEvent) {
        selectedTime = "evening";
    }


    /**
     * Þetta er handler sem að mun sjá um allt sem hinir handlerarnir eru að gera, nema að
     * núna munu hlutir í rauninnni breytast í listView.
     * @param threngjaEvent sér um að sía út og raða dagsferðunum.
     */
    public void threngjaLeit(ActionEvent threngjaEvent){
        getSelectedActivities();
        updateListView();
        selectedActivity.clear();
    }

    /**
     * Skoða lista af CheckBox til að athuga hverja eru valdir
     */
    public void getSelectedActivities(){
        int m = cbList.size();
        for(int i = 0; i<m ; i++){
            CheckBox c = cbList.get(i);
            if(c.isSelected()) selectedActivity.add(c.getText());
        }
    }

    /**
     * Aðferð til að setja ferð sem notandinn er að skoða í nýja glugganum í körfu
     * @param d Daytrip hlut
     * @param num fjölda sæti
     */
    public void setToCart(Daytrip d, int num){
        d.setBookedSeats(num);
        cartList.add(d);
        cartListView.setItems(cartList);
    }

    /**
     * Handler sem að mun opna nýjan glugga til að skoða frekari upplýsingar um valin ferð
     * @param mouseEvent sér um að opna glugga þegar notandinn valdi ferðina úr ListView
     */
    public void daytripSelected(MouseEvent mouseEvent) {
        try {
            Daytrip selected = myListView.getSelectionModel().getSelectedItem();
            dbm.populateReviewForDaytrip(selected);
            dbm.populateHotelsForDaytrip(selected);
            URL url = new File("src/sample/details.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();
            DetailsController detailsController = loader.getController();
            detailsController.setDaytrip(selected);
            detailsController.setController(this);
            Stage stage = new Stage();
            stage.setTitle(selected.getTitle());
            stage.setScene(new Scene(root, 650, 500));
            stage.show();
        }
        catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void finalizeBooking(ActionEvent actionEvent) {

    }
}
