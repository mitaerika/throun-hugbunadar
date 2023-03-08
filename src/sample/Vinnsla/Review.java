package sample.Vinnsla;

public class Review {
    int number;
    String desc;
    String einkunn;
    Daytrip daytrip;
    Customer customer;
    public Review(String desc, String einkunn, int number, Daytrip daytrip, Customer customer) {
        this.number = number;
        this.desc = desc;
        this.einkunn = einkunn + "/10";
        this.daytrip = daytrip;
        this.customer = customer;
    }
}
