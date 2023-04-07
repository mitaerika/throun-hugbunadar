package sample.Vinnsla;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DaytripListCell extends ListCell<Daytrip> {
    private final Label title = new Label();
    private final Label date = new Label();
    private final Label time = new Label();
    private final Label price = new Label();
    private final HBox extra = new HBox(date,time);
    private final HBox core = new HBox(title);
    private final VBox layout = new VBox(core, extra, price);

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
            title.setText(trip.getTitle());
            date.setText(trip.getDate());
            price.setText("Verð: "+trip.getPrice());
            time.setText(" kl. "+trip.getStartTime());
            setGraphic(layout);
        }
    }
}
