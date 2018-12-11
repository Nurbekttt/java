import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class eR extends Application {

    String name ="Beknur";
    long [] bytime = new long[6];
    String [][] justlist = new String[6][3];

    @Override
    public void start(Stage primaryStage) throws IOException{

        WritingIO writingIO = new WritingIO( "hard");
        Label label1 = new Label(  );
        Label label2 = new Label( );
        Label label3 = new Label(  );
        Label label4 = new Label(  );
        Label label5 = new Label(  );
        Label []listlab ={label1,label2,label3,label4,label5};
        VBox vBox = new VBox( 5 );
        vBox.getChildren().addAll( label1,label2,label3,label4,label5 );
        vBox.setAlignment( Pos.CENTER);

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
            System.out.println(bytime1[0]+" "+bytime[0]);
            int sz =0;
            for (int i = 0; i <5 ; i++) {
                for (int j = 0; j <6 ; j++) {
                    if(bytime1[i]==Long.parseLong( justlist[j][0] )){
                        {listlab[sz].setText( justlist[j][1]+" "+justlist[j][2]);
                        sz++;}
                        System.out.println(justlist[j][1]+" "+justlist[j][2]);

                    }
                }

            }

        } ));
        tm.setCycleCount(Timeline.INDEFINITE);
        stopWatch.start();
        tm.play();

        Scene scene = new Scene( vBox );
        primaryStage.setTitle( "abs" );
        primaryStage.setScene( scene );
        primaryStage.show();
        FadeTransition ft =
                new FadeTransition(Duration.millis(3000), vBox);
        ft.setFromValue(1.0);
        ft.setToValue(0.07);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();
    }
}
