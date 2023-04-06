/******************************************************************************
 *  Nafn    : Ásdís, Mita, Sigga og Jökull
 *  T-póstur: asv29@hi.is
 *
 *  Lýsing  :
 *
 *
 *****************************************************************************/

package sample.Vinnsla;

import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDatabaseManager {
    static ObservableList<Daytrip> createDaytripObjects(ResultSet rs) throws SQLException {
        return null;
    }



}
