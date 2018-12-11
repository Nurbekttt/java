import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.net.MalformedURLException;

public class Music extends Application {
    int sz1 = 0;
    Media media;
    MediaPlayer mediaPlayer;
    public void start(Stage primaryStage) throws MalformedURLException {
        String[] muz = new String[3];

        muz[0] = "Imagine Dragon – Demons.mp3";
        muz[1] = "Imagine Dragons – RADIO-ACTIVE.mp3";
        muz[2] = "Imagine Dragons – Thunder.mp3";
        media = new Media(getClass().getClassLoader().getResource(muz[sz1]).toString());
         mediaPlayer = new MediaPlayer(media);

        Button playButton = new Button(">");
        playButton.getStyleClass().add("but-style");
        playButton.setOnAction(e -> {
            if (playButton.getText().equals(">")) {
                mediaPlayer.play();
                playButton.setText("||");
            } else {
                mediaPlayer.pause();
                playButton.setText(">");
            }
        });
        Button rewindButton = new Button("<<");
        rewindButton.getStyleClass().add("but-style");
        rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));
        Slider slVolume = new Slider();
        slVolume.getStyleClass().add("vol");
        slVolume.setPrefWidth(150);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(
                slVolume.valueProperty().divide(100));
        Button next = new Button(">>");
        next.getStyleClass().add("but-style");
        next.setOnAction(e->{
                sz1++;
                mediaPlayer.pause();
                media = new Media(getClass().getClassLoader().getResource(muz[sz1]).toString());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
                playButton.setText("||");
                 mediaPlayer.volumeProperty().bind(
                    slVolume.valueProperty().divide(100));

                if(sz1 == 2)
                    sz1 = -1;
        });

        Slider smuz = new Slider();
        smuz.getStyleClass().add("vol");
        smuz.getStyleClass().add("vol");
        smuz.setPrefWidth(100);
        smuz.setMaxWidth(Region.USE_PREF_SIZE);
        smuz.setMinWidth(30);
        smuz.setValue(50);
        System.out.println(mediaPlayer.getCurrentTime());
        System.out.println(mediaPlayer.getOnPlaying());
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(playButton, rewindButton, slVolume,next,smuz);

        BorderPane pane = new BorderPane();
        pane.setBottom(hBox);
        Scene scene = new Scene(pane, 650, 75);
        scene.getStylesheets().add("style.css");
        primaryStage.setTitle("MediaDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}