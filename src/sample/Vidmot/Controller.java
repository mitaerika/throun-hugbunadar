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
    private VBox activityBox;

    private ObservableList<Daytrip> daytripList;
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

    private void populateListView(){
        //hér tengjum við gagnagrunninn við okkar forrit og náum í allar upplýsingar um daytrip. Við fáum til baka result set í main og færum það yfir í database managerinn.
        try {
            daytripList = dbm.fetchAvailableDaytrips();
            myListView.setItems(daytripList);
            myListView.setCellFactory(param -> new DaytripListCell());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void updateListView(){
        try {
            daytripList = dbm.fetchFilteredDaytrips(selectedDate,selectedLocation,selectedTime);
            myListView.setItems(daytripList);
            myListView.setCellFactory(param -> new DaytripListCell());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        updateListView();
    }

    /**
     * Handler sem að mun opna nýjan glugga til að skoða frekari upplýsingar um valin ferð
     * @param mouseEvent sér um að opna glugga þegar notandinn valdi ferðina úr ListView
     */
    public void daytripSelected(MouseEvent mouseEvent) {
        try {
            URL url = new File("src/sample/details.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();
            DetailsController detailsController = loader.getController();
            Daytrip selected = myListView.getSelectionModel().getSelectedItem();
            detailsController.setDaytrip(selected);
            Stage stage = new Stage();
            stage.setTitle(selected.getTitle());
            stage.setScene(new Scene(root, 650, 450));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
