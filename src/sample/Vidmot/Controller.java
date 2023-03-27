package sample.Vidmot;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Vinnsla.DatabaseManager;
import sample.Vinnsla.Daytrip;

import java.sql.SQLException;

public class Controller {
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
    private ListView<String> searchResult;

    public void initialize() throws SQLException, ClassNotFoundException {
        //ObservableList<Daytrip> list = DatabaseManager.fetchAvailableDaytrips();//hér tengjum við gagnagrunninn við okkar forrit og náum í allar upplýsingar um daytrip. Við fáum til baka result set í main og færum það yfir í database managerinn.
        //searchResult.setItems(list);
        //System.out.println("list populated");
        ObservableList<String> names = FXCollections.observableArrayList(
                "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
        searchResult.setItems(names);
    }
}
