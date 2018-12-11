import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class musicN extends Application{
    String [] listofM ={"a","b","c"};
    @Override
    public void start(Stage primaryStage) {
        ComboBox<String> musics = new ComboBox<>(  );
        musics.setPrefWidth( 100 );
        ObservableList<String> items =
                FXCollections.observableArrayList(listofM);
        musics.getItems().addAll(items);
        VBox musicpane = new VBox(  );
        musicpane.getChildren().add(musics);
        Scene scene = new Scene( musicpane );
        primaryStage.setScene( scene );
        primaryStage.show();
    }
}
