package sample.Vinnsla;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDatabaseManager {
    Daytrip[] createDaytripObjects(ResultSet rs) throws SQLException;

}
