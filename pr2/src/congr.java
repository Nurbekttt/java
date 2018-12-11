import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.*;


public class congr extends Application {
    String e_t;

    public static void main(String[] args) {
        launch(args);
    }
    congr(String s)
    {
        this.e_t = s;
    }

    public String getE_t() {
        return e_t;
    }

    @Override
    public void start(Stage primaryStage) {
        ImageView imageView = new ImageView(new Image("congratulazioni-gif-congratulations-glitter-611.gif"));
        VBox pane = new VBox();
        pane.getChildren().add(imageView);
        e_t = getE_t();
        Label end_time = new Label(e_t);
        end_time.getStyleClass().add( "vol1" );
        pane.getChildren().add(end_time);
        pane.setAlignment(Pos.CENTER);
        Scene finishGameeCh3 = new Scene(pane, 400, 240);
        finishGameeCh3.getStylesheets().add( "style.css" );
        primaryStage.setScene(finishGameeCh3);
        primaryStage.show();
    }
}
