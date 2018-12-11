import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise_06 extends Application {

    StopWatch stopWatch = new StopWatch();
    Label mLabel = new Label("00:00:00");

    @Override
    public void start(Stage primaryStage) {


        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            mLabel.setText(stopWatch.toString());
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        stopWatch.start();
        timeline.play();
        HBox bottomPane = new HBox();
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setSpacing(10);
        bottomPane.setPadding(new Insets(10));
        mLabel.setFont(Font.font(50));

        StackPane centerPane = new StackPane(mLabel);
        centerPane.setPadding(new Insets(10));

        BorderPane borderPane = new BorderPane(centerPane);
        borderPane.setBottom(bottomPane);
        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Stopwatch");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}