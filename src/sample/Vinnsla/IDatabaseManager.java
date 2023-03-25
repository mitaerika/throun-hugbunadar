package sample.Vinnsla;

import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDatabaseManager {
    ObservableList<Daytrip> createDaytripObjects(ResultSet rs) throws SQLException;

}
