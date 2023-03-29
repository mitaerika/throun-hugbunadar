package sample.Vinnsla;


import java.text.ParseException;

public class SimulDaytripMock{
    static MockDatabaseManager s = new MockDatabaseManager();

    public static void runTests() throws ParseException {
        s.setUp();
        s.testSortingByRatingDescending();
        s.testSortingByPriceAscending();
        s.testFilterByLocation();
        s.testFilterByLocation2();
        s.tearDown();

    }
}