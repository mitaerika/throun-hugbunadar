package sample.Vinnsla;


import java.text.ParseException;

public class SimulDaytripMock{
    static MockDatabaseManager s = new MockDatabaseManager();
    public static void main(String[] args) throws ParseException {
        s.setUp();
        s.testSortingByRating();
        s.testFilterByLocation();
        s.tearDown();
    }
}