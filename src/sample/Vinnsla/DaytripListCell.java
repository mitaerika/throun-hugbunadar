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
    public final Label extra = new Label();
    public final Button edit = new Button("Breyta/Eyða");

    public final VBox right = new VBox(edit);
    public VBox left = new VBox();
    public final VBox layoutB = new VBox(title, new HBox(left,right));

    public DaytripListCell() {
        super();
    }

    @Override
    protected void updateItem(Daytrip trip, boolean empty) {
        super.updateItem(trip, empty);
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
            left = new VBox(new HBox(date,time),price, extra);
            setGraphic(new VBox(title, left));
        }
    }
}
