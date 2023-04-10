package sample.Vinnsla;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DaytripListCell extends ListCell<Daytrip> {
    public final Label title = new Label();
    public final Label date = new Label();
    public final Label time = new Label();
    public final Label price = new Label();
    public final HBox dateTime = new HBox(date,time);
    public final HBox main = new HBox(title);
    public final Label extra = new Label();
    public final VBox left = new VBox(main, dateTime, price, extra);
    public final HBox layout = new HBox(left);

    public DaytripListCell() {
        super();
    }

    @Override
    protected void updateItem(Daytrip trip, boolean empty) {
        super.updateItem(trip, empty);
        //setText(null);
        if (empty || trip == null) {
            title.setText(null);
            date.setText(null);
            price.setText(null);
            time.setText(null);
            setGraphic(null);
        } else {
            String avgRating = String.format("%.1f",trip.getAvgRating());
            title.setText(trip.getTitle());
            date.setText(trip.getDate());
            price.setText("Verð: "+trip.getPrice());
            time.setText(" kl. "+trip.getStartTime());
            extra.setText("Einkunn: "+ avgRating +"/10");
            setGraphic(layout);
        }
    }
}
