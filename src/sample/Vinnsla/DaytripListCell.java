package sample.Vinnsla;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DaytripListCell extends ListCell<Daytrip> {
    public final Label title = new Label();
    public final Label date = new Label();
    public final Label time = new Label();
    public final Label price = new Label();
    public final HBox extra = new HBox(date,time);
    public final HBox core = new HBox(title);
    public final VBox layout = new VBox(core, extra, price);

    public DaytripListCell() {
        super();
    }

    @Override
    protected void updateItem(Daytrip trip, boolean empty) {
        super.updateItem(trip, empty);

        setText(null);

        if (empty || trip == null) {
            title.setText(null);
            date.setText(null);
            price.setText(null);
            time.setText(null);
            setGraphic(null);
        } else {
            String rating = String.format("%.1f",trip.getRating());
            title.setText(trip.getTitle() + " - Einkunn: "+ rating +"/10");
            date.setText(trip.getDate());
            price.setText("Verð: "+trip.getPrice());
            time.setText(" kl. "+trip.getStartTime());
            setGraphic(layout);
        }
    }
}
