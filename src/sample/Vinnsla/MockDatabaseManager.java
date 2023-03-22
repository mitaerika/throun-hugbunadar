package sample.Vinnsla;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MockDatabaseManager implements IDatabaseManager{
    @Override
    public Daytrip[] createDaytripObjects(ResultSet rs) throws SQLException {
        return new Daytrip[0];
    }
}
