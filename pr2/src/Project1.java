import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.FontFace;
import javafx.geometry.Insets;
import javafx.scene.shape.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.StrictMath.floor;
import static java.lang.String.format;
import javafx.scene.image.ImageView;
public class Project1 extends Application {
    boolean knopka = false;
    Slider slider;
    Duration duration;
    Label time;
    MediaPlayer mediaPlayer;
    boolean k = false,k1 = true;
    double mx;
    Scene scene;
    String name;
    String level;
    StopWatch stopWatch = new StopWatch();
    Label mLabel = new Label("00:00:00");
    long [] bytime = new long[6];
    String [][] justlist = new String[6][3];
    String [] listofM ={"Imagine Dragon – Demons","Imagine Dragons – RADIO-ACTIVE",
            "Imagine Dragons – Thunder"};
    Media media;
    boolean b;
    String nemu;
    String[][] nlistrec = new String[6][3];
    String[][] listrec = new String[5][3];
    long[] forsc = new long[6];
    long[] sc = new long[5];
    private int count = 0;
    ArrayList<String> arrayList = new ArrayList<>(  );
    public static void main(String[] args) {
        launch(args);
    }


    public Project1(String name,String level){
        this.name=name;

        this.level=level;
    }

    public String getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
        level=getLevel();
        name=getName();
        Button pause = new Button("Pause");
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //MUSIC
        media = new Media(getClass().getClassLoader().getResource(listofM[0]+".mp3").toString());
        mediaPlayer = new MediaPlayer(media);
        ImageView playbutton = new ImageView(new Image("image_icon_play.png"));
        ImageView imageView1 = new ImageView(new Image("image_icon_pause.png"));
        playbutton.setFitWidth(70);
        playbutton.setFitHeight(70);
        imageView1.setFitWidth(70);
        imageView1.setFitHeight(70);

        Button playButton = new Button();
        playButton.setGraphic(playbutton);
        playButton.getStyleClass().add("playbutton");
        playButton.setOnAction(e -> {
            if (!k) {
                mediaPlayer.play();
                playButton.setGraphic(imageView1);
                k = true;
            } else {
                mediaPlayer.pause();
                playButton.setGraphic(playbutton);
                k = false;
            }
        });
        slider = new Slider();
        slider.getStyleClass().add("changemuz");
        HBox.setHgrow(slider, Priority.ALWAYS);
        slider.setMinSize(300, 17);
        time = new Label();
        time.setTextFill(Color.WHITE);
        time.setPrefWidth(80);

        mediaPlayer.currentTimeProperty().addListener((Observable ov) -> {
            updateValues();
        });

        mediaPlayer.setOnReady(() -> {
            duration = mediaPlayer.getMedia().getDuration();
            updateValues();
        });
        duration = mediaPlayer.getMedia().getDuration();
        slider.valueProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                if (slider.isValueChanging()) {
// multiply duration by percentage calculated by slider position
                    if (duration != null) {
                        mediaPlayer.seek(duration.multiply(slider.getValue() / 100.0));
                    }
                    updateValues();

                }
            }
        });
        Slider slVolume = new Slider();
        slVolume.getStyleClass().add("vol");
        slVolume.setPrefWidth(75);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(
                slVolume.valueProperty().divide(100));
        Button sound = new Button();
        ImageView sound1 = new ImageView(new Image("sound.png"));
        sound.getStyleClass().add("playbutton");
        ImageView mute1 = new ImageView(new Image("9cd9fbe4.png"));
        sound1.setFitWidth(35);
        sound1.setFitHeight(35);
        mute1.setFitWidth(35);
        mute1.setFitHeight(35);
        sound.setGraphic(sound1);
        sound.setOnAction(e->{
            if(k1)
            {
                sound.setGraphic(mute1);
                k1 = false;
                mx = slVolume.getValue();
                slVolume.setValue(0);
            }
            else
            {
                sound.setGraphic(sound1);
                k1 = true;
                slVolume.setValue(mx);
            }
        });
        HBox muzon = new HBox(5);
        muzon.setAlignment(Pos.CENTER);
        muzon.getChildren().add(playButton);
        muzon.getChildren().add(slider);
        muzon.getChildren().add(time);
        muzon.getChildren().add(sound);
        muzon.getChildren().add(slVolume);
        muzon.getStyleClass().add("back");
        muzon.setPadding(new Insets(0,10,0,0));
        muzon.getChildren().add(pause);
        //MUSIC
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        TilePane sudoku = new TilePane();
        sudoku.setHgap(4);
        sudoku.setVgap(4);
        sudoku.setPadding(new Insets(5, 10, 5, 10));
        sudoku.setPrefColumns(9);
        sudoku.setPrefRows(9);
        sudoku.setAlignment(Pos.CENTER);
        TextField[] q = new TextField[81];
        String[] s1,s2;
        if(level.equals( "easy" ))
           s1 = app.verySimpleLevel;
        else if(level.equals( "medium" ))
            s1 = app.middleLevel;
        else s1 = app.hardLevel;

        if(level.equals( "easy" ))
            s2 = app.verySimpleLevelAnswer;
        else if(level.equals( "medium" ))
            s2 = app.middleLevelAnswer;
        else s2 = app.hardLevelAnswer;
        int sz = 0;

        for(int i = 0;i<9;i++)
        {
            for (int j = 0;j<9;j++)
            {
                String s = s1[sz];
                q[sz] = createCell(i,j,s);
                sudoku.getChildren().add(q[sz]);
                sz++;
            }
        }
        Button ok = new Button("CHECK");
        ok.getStyleClass().add("but-style");
        HBox vBoxi1 = new HBox(125);
        ////////////
        VBox timepane = new VBox(5);
        ComboBox<String> musics = new ComboBox<>(  );
        musics.setPrefWidth( 100 );
        ObservableList<String> items =
                FXCollections.observableArrayList(listofM);
        musics.getItems().addAll(items);

        musics.setValue( "Imagine Dragon – Demons" );
        musics.setPrefWidth( 300 );

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            mLabel.setText(stopWatch.toString());
            if(mediaPlayer.getStopTime().toSeconds()== mediaPlayer.getCurrentTime().toSeconds())
            {
                nemu = musics.getValue();
                for(int i = 0;i<3;i++)
                {
                    if(listofM[i].equals( nemu ))
                    {
                        mediaPlayer.pause();
                        media = new Media(getClass().getClassLoader().getResource(listofM[(i+1)%3]+".mp3").toString());
                        mediaPlayer = new MediaPlayer(media);
                        musics.setValue( listofM[(i+1)%3] );
                        mediaPlayer.play();
                    }
                }
                int sz2 = 0;
                String s5 = mediaPlayer.getMedia().toString();
                System.out.println(s5);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        stopWatch.start();
        timeline.play();
        mLabel.setFont(Font.font(50));
        Tooltip tooltip = new Tooltip( "You are in the game" );
        mLabel.setTooltip( tooltip );

        tooltip.setFont( Font.font( "Times New Roman" ,FontWeight.BOLD,12 ));
        Tooltip.install( mLabel,tooltip );
        timepane.getChildren().add( mLabel );
        /////////////////////////////
        WritingIO writingIO = new WritingIO( level);
        Label label1 = new Label(  );
        Label label2 = new Label( );
        Label label3 = new Label(  );
        Label label4 = new Label(  );
        Label label5 = new Label(  );
        Label []listlab ={label1,label2,label3,label4,label5};
        label1.setFont(Font.font(25));
        label2.setFont(Font.font(25));
        label3.setFont(Font.font(25));
        label4.setFont(Font.font(25));
        label5.setFont(Font.font(25));
        StackPane vboxx = new StackPane(  );
        VBox vBox = new VBox( 5 );
        vBox.getChildren().addAll( label1,label2,label3,label4,label5 );
        vBox.setAlignment( Pos.CENTER);
        Rectangle rec = new Rectangle( 250,260 );
        rec.setFill( Color.TRANSPARENT );
        rec.getStyleClass().add( "rec" );
        rec.setStroke( Color.RED );
        vboxx.getChildren().addAll(rec,vBox);
        for (int i = 0; i <5 ; i++) {
            listlab[i].setText( writingIO.getList()[i][1] +" "+writingIO.getList()[i][2]);
        }
        for (int i = 0; i <5 ; i++) {
            bytime[i]=writingIO.getSc()[i];
            justlist[i][0]=writingIO.getList()[i][0];
            justlist[i][1]=writingIO.getList()[i][1];
            justlist[i][2]=writingIO.getList()[i][2];

        }



        StopWatch stopWatch = new StopWatch();
        Timeline tm =new Timeline( new KeyFrame(Duration.millis( 1000 ), e->{
            bytime[5]=stopWatch.peek();
            long bytime1[];
            bytime1=bytime.clone();
            justlist[5][0]=bytime1[5]+"";
            justlist[5][1]=name;
            justlist[5][2]=stopWatch.toString();
            Arrays.sort( bytime1 );
            int sz1 =0;
            for (int i = 0; i <5 ; i++) {
                for (int j = 0; j <6 ; j++) {
                    if(bytime1[i]==Long.parseLong( justlist[j][0] )){
                        {listlab[i].setText( justlist[j][1]+" "+justlist[j][2]);

                        if(justlist[j][1].equals( name ))listlab[i].getStyleClass().add( "labelcolor" );
                        else listlab[i].getStyleClass().clear();
                        }

                    }
                }

            }

        } ));
        tm.setCycleCount(Timeline.INDEFINITE);
        stopWatch.start();
        tm.play();

        timepane.getChildren().add( vboxx );
        //////////////////////////////////

        musics.setOnAction( event -> {
            mediaPlayer.pause();
            media = new Media(getClass().getClassLoader().getResource(musics.getValue()+".mp3").toString());
            mediaPlayer = new MediaPlayer(media);
            slider.getStyleClass().add("changemuz");
            HBox.setHgrow(slider, Priority.ALWAYS);
            slider.setMinSize(300, 17);
            mediaPlayer.currentTimeProperty().addListener((Observable ov) -> {
                updateValues();
            });

            mediaPlayer.setOnReady(() -> {
                duration = mediaPlayer.getMedia().getDuration();
                updateValues();
            });
            duration = mediaPlayer.getMedia().getDuration();
            Duration currentTime = mediaPlayer.getCurrentTime();
            time.setText(formatTime(currentTime, duration));
            slider.valueProperty().addListener(new InvalidationListener() {
                public void invalidated(Observable ov) {
                    if (slider.isValueChanging()) {
// multiply duration by percentage calculated by slider position
                        if (duration != null) {
                            mediaPlayer.seek(duration.multiply(slider.getValue() / 100.0));
                        }
                        updateValues();

                    }
                }
            });
            mediaPlayer.play();
            playButton.setGraphic(imageView1);
            k = true;
            mediaPlayer.volumeProperty().bind(
                    slVolume.valueProperty().divide(100));

        } );

        VBox musicpane = new VBox(  );
        musicpane.getChildren().add( musics );
        timepane.getChildren().addAll( musicpane,ok );

        timepane.setAlignment( Pos.CENTER );


        ////////////////////////
        vBoxi1.getChildren().addAll(sudoku,timepane);
        vBoxi1.setAlignment(Pos.CENTER);
        HBox hBoxi1 = new HBox(25);
        hBoxi1.setPadding(new Insets(3,0,10,0));
        pause.getStyleClass().add("pause");
        pause.getStyleClass().add("but-style");
        hBoxi1.getChildren().addAll(vBoxi1);
        hBoxi1.setAlignment(Pos.CENTER);
        StackPane pane = new StackPane();
        Image image = new Image("SDU.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setOpacity(0.5);
        VBox end = new VBox();
        end.setAlignment(Pos.TOP_CENTER);
        end.getChildren().addAll(hBoxi1,muzon);
        pane.getChildren().addAll(imageView,end);
        pane.setPadding(new Insets(10,0,0,0));
        scene = new Scene(pane,1000,550);
        scene.getStylesheets().add("style.css");
        scene.getStylesheets().add( "bbb.css" );
        primaryStage.setScene(scene);
        primaryStage.show();

        ok.setOnAction(e->{
            ///////////////////////////////////////////////////////////////////////////////////////
            int line1,x,y,line2;
            boolean q1 = true,q2 = true;
            boolean[] checks = new boolean[81];
            String box,m="";
            for (int i = 0;i<81;i++)
            {
                q1 = true;
                line1 = i%9;
                box = q[i].getText();
                x = i/9;
                y = i%9;
                line2= i/9;
                line2*=9;
                if(q[i].isEditable())
                {
                    for (int j = line1; j < 81; j+=9)
                    {

                        if (box.equals(q[j].getText()) && i != j) {
                            if (((y < 6 && y > 2) && (x < 6 && x > 2))
                                    || ((y < 3) && (x < 3))
                                    || ((y < 3) && (x > 5))
                                    || ((y > 5) && (x > 5))
                                    || ((y > 5) && (x < 3))) {
                                q[i].setFont(Font.font("Times New Roman", FontPosture.ITALIC, 20));
                                q[i].setStyle("-fx-background-color: rgba(255, 178, 0, 0.9);" + "-fx-font-weight: BOLD;" + "-fx-border-color:RED;-fx-border-width:3");
                                checks[i] = true;

                            } else {
                                q[i].setFont(Font.font("Times New Roman", FontPosture.ITALIC, 20));
                                q[i].setStyle("-fx-font-weight: BOLD;" + "-fx-border-color:RED;-fx-border-width:3");
                                checks[i] = true;
                            }
                            q1 = false;
                        }
                        }
                        for(int j = line2;j<line2+9;j++)
                        {
                            if (box.equals(q[j].getText()) && i != j) {
                                if (((y < 6 && y > 2) && (x < 6 && x > 2))
                                        || ((y < 3) && (x < 3))
                                        || ((y < 3) && (x > 5))
                                        || ((y > 5) && (x > 5))
                                        || ((y > 5) && (x < 3))) {
                                    q[i].setFont(Font.font("Times New Roman", FontPosture.ITALIC, 20));
                                    q[i].setStyle("-fx-background-color: rgba(255, 178, 0, 0.9);" + "-fx-font-weight: BOLD;" + "-fx-border-color:RED;-fx-border-width:3");
                                    checks[i] = true;

                                } else {
                                    q[i].setFont(Font.font("Times New Roman", FontPosture.ITALIC, 20));
                                    q[i].setStyle("-fx-font-weight: BOLD;" + "-fx-border-color:RED;-fx-border-width:3");
                                    checks[i] = true;
                                }
                                q1 = false;
                            }
                        }
                    if(q1)
                    {
                        if (((y < 6 && y > 2) && (x < 6 && x > 2))
                                || ((y < 3) && (x < 3))
                                || ((y < 3) && (x > 5))
                                || ((y > 5) && (x > 5))
                                || ((y > 5) && (x < 3))) {
                            q[i].setStyle("-fx-background-color: rgba(255, 178, 0, 0.9);" + "-fx-font-weight: BOLD;" + "-fx-border-color:rgb(144, 8, 0)");

                        } else {
                            q[i].setStyle("-fx-font-weight: BOLD;" + "-fx-border-color:rgb(144, 8, 0)");

                        }

                    }
                    }

            }
                    String t,t1;

             for(int i = 0;i<81;i+=27)
             {
                 for(int j = 0;j<9;j+=3)
                 {
                        for(int k = i;k<i+27;k+=9)
                        {
                            for(int l =j; l<j+3;l++)
                            {
                                t = q[k+l].getText();
                                x = (k+l)/9;
                                y = (k+l)%9;
                                q2 = true;
                                if(q[k+l].isEditable())
                                {

                                for(int k1 = i;k1<i+27;k1+=9)
                                {
                                    for(int l1 = j;l1<j+3;l1++)
                                    {
                                        t1 = q[k1+l1].getText();
                                        if(k != k1 && l != l1)
                                        {
                                            if(t1.equals(t))
                                            {
                                                if (((y < 6 && y > 2) && (x < 6 && x > 2))
                                                        || ((y < 3) && (x < 3))
                                                        || ((y < 3) && (x > 5))
                                                        || ((y > 5) && (x > 5))
                                                        || ((y > 5) && (x < 3))) {
                                                    q[k+l].setFont(Font.font("Times New Roman", FontPosture.ITALIC, 20));
                                                    q[k+l].setStyle("-fx-background-color: rgba(255, 178, 0, 0.9);" + "-fx-font-weight: BOLD;" + "-fx-border-color:RED;-fx-border-width:3");

                                                } else {
                                                    q[k+l].setFont(Font.font("Times New Roman", FontPosture.ITALIC, 20));
                                                    q[k+l].setStyle("-fx-font-weight: BOLD;" + "-fx-border-color:RED;-fx-border-width:3");

                                                }
                                                q2 = false;
                                            }
                                        }
                                    }
                                }
                                if(q2 && !checks[k+l])
                                {
                                    if (((y < 6 && y > 2) && (x < 6 && x > 2))
                                            || ((y < 3) && (x < 3))
                                            || ((y < 3) && (x > 5))
                                            || ((y > 5) && (x > 5))
                                            || ((y > 5) && (x < 3))) {
                                        q[k+l].setStyle("-fx-background-color: rgba(255, 178, 0, 0.9);" + "-fx-font-weight: BOLD;" + "-fx-border-color:rgb(144, 8, 0)");


                                    } else {
                                        q[k+l].setStyle("-fx-font-weight: BOLD;" + "-fx-border-color:rgb(144, 8, 0)");
                                    }

                                }
                                }
                            }
                        }
                 }
             }
            /////////////////////////////////////////////////////////////////////////////////////////
            String ch;
            String[] ans = s2;
            b = true;
            for(int i = 0;i<81;i++)
            {
                ch= q[i].getText();
                if(!ch.equals(ans[i]))
                {
                    b = false;
                }
            }

            if(b){
                primaryStage.hide();
                String timerec =stopWatch.peek()+"";
                String ttt=stopWatch.toString();
                Scanner in = null;
                try {
                    in = new Scanner( new File( level+".txt" ) );
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                while(in.hasNext()){
                    String a = in.next();
                    String b = in.next();
                    String c = in.next();
                    System.out.println(a+b+c);
                    forsc[count]=Long.parseLong( a );
                    nlistrec[count][0]=a;
                    nlistrec[count][1]=b;
                    nlistrec[count][2]=c;
                    count++;
                }
                forsc[5]=Long.parseLong( timerec );
                nlistrec[5][0]=timerec;
                nlistrec[5][1]=name;
                nlistrec[5][2]=ttt;
                Arrays.sort( forsc );
                for (int i = 0; i <5 ; i++) {
                    for (int j = 0; j <6 ; j++) {
                        if(forsc[i]==Long.parseLong(nlistrec[j][0])){
                            arrayList.add( nlistrec[j][0]) ;
                            arrayList.add( nlistrec[j][1]);
                            arrayList.add( nlistrec[j][2]);
                        }
                    }
                }
                PrintWriter printWriter = null;
                try {
                    printWriter = new PrintWriter( new File(level+".txt" ) );
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                for (int i = 0; i <5 ; i++) {
                    printWriter.print( arrayList.get( i*3 )+" "+arrayList.get( i*3+1 )+" "+arrayList.get( i*3+2)  );
                    printWriter.println();
                }printWriter.close();
                System.out.println("saved");

                printWriter.close();

                Stage stagecon = new Stage(  );
                congr c = new congr( stopWatch.toString() );
                c.start( stagecon );
                System.out.println("yes");
            }

            else System.out.println("NO");
        });
        pause.setOnAction( event -> {
            if(!knopka){
                stopWatch.pause();
                tm.pause();
                FadeTransition ft = new FadeTransition( Duration.millis(3000),hBoxi1 );
                ft.setFromValue(1.0);
                ft.setToValue(0.07);
                ft.setCycleCount(1);
                ft.setAutoReverse(false);
                ft.play();
                ft.play();
                pause.setText( "Play" );
                hBoxi1.setDisable( true );
                knopka=true;
            }
            else {
                FadeTransition ft = new FadeTransition( Duration.millis(2000),hBoxi1 );
                ft.setFromValue(0.07);
                ft.setToValue(1.0);
                ft.setCycleCount(1);
                ft.setAutoReverse(false);
                ft.play();
                hBoxi1.setDisable( false );
                stopWatch.resume();
                tm.play();
                pause.setText( "Pause" );
                knopka= false;
            }



        } );
    }
    private TextField createCell(int col, int row,String s) {
        TextField txtfield = new TextField();
        txtfield.setPrefWidth(45);
        txtfield.setPrefHeight(45);
        txtfield.setAlignment(Pos.CENTER);

        txtfield.setStyle("-fx-font-weight: BOLD;");
        if (((row < 6 && row > 2) && (col < 6 && col > 2))
                || ((row < 3) && (col < 3))
                || ((row < 3) && (col > 5))
                || ((row > 5) && (col > 5))
                || ((row > 5) && (col < 3)))
        {
            txtfield.setStyle("-fx-background-color: rgba(255, 178, 0, 0.9);" + "-fx-font-weight: BOLD;");
            if(!s.equals(" "))
            {
                txtfield.setStyle("-fx-background-color: rgba(255, 178, 0, 0.9);" + "-fx-font-weight: BOLD;");
            }
            else {
                txtfield.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 20));
                txtfield.setStyle("-fx-background-color: rgba(255, 178, 0, 0.9);" + "-fx-font-weight: BOLD;"+"-fx-border-color:rgb(144, 8, 0)");
            }
        }
        else
        {
            if(s.equals(" "))
            {txtfield.setStyle("-fx-font-weight: BOLD;"+"-fx-border-color:rgb(144, 8, 0)");
            txtfield.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 20));}
        }
        if(!s.equals(" "))
        {txtfield.setText(s);
            txtfield.setEditable(false);
        }
        return txtfield;
    }
    protected void updateValues() {
        if (time != null && slider != null && duration != null) {
            Platform.runLater(new Runnable() {
                public void run() {
                    Duration currentTime = mediaPlayer.getCurrentTime();
                    time.setText(formatTime(currentTime, duration));
                    slider.setDisable(duration.isUnknown());
                    if (!slider.isDisabled() && duration.greaterThan(Duration.ZERO) && !slider.isValueChanging()) {
                        slider.setValue(currentTime.divide(duration).toMillis() * 100.0);
                    }

                }
            });
        }
    }
    private static String formatTime(Duration elapsed, Duration duration) {
        int intElapsed = (int) floor(elapsed.toSeconds());
        int elapsedHours = intElapsed / (60 * 60);
        if (elapsedHours > 0) {
            intElapsed -= elapsedHours * 60 * 60;
        }
        int elapsedMinutes = intElapsed / 60;
        int elapsedSeconds = intElapsed - elapsedHours * 60 * 60
                - elapsedMinutes * 60;

        if (duration.greaterThan(Duration.ZERO)) {
            int intDuration = (int) floor(duration.toSeconds());
            int durationHours = intDuration / (60 * 60);
            if (durationHours > 0) {
                intDuration -= durationHours * 60 * 60;
            }
            int durationMinutes = intDuration / 60;
            int durationSeconds = intDuration - durationHours * 60 * 60
                    - durationMinutes * 60;
            if (durationHours > 0) {
                return format("%d:%02d:%02d/%d:%02d:%02d",
                        elapsedHours, elapsedMinutes, elapsedSeconds,
                        durationHours, durationMinutes, durationSeconds);
            } else {
                return format("%02d:%02d/%02d:%02d",
                        elapsedMinutes, elapsedSeconds, durationMinutes,
                        durationSeconds);
            }
        } else {
            if (elapsedHours > 0) {
                return format("%d:%02d:%02d", elapsedHours,
                        elapsedMinutes, elapsedSeconds);
            } else {
                return format("%02d:%02d", elapsedMinutes,
                        elapsedSeconds);
            }
        }
    }
}










