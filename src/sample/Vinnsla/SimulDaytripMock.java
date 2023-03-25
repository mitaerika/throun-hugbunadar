package sample.Vinnsla;


public class SimulDaytripMock{
    private Daytrip daytrip1, daytrip2;




    public void tearDown(){
        daytrip1 = null;
        daytrip2 = null;
    }

    public void testPrice() {
        daytrip1.getPrice();
        daytrip2.getPrice();
    }
}
