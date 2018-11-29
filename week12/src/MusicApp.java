/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Админ
 */
public class MusicApp extends Application{

    public void start(Stage primaryStage) throws InterruptedException {
        VBox pane = new VBox();
        pane.setSpacing(10);
        Composite com = new Composite();
        MusicDO do1 = new MusicDO();
        MusicRE re1 = new MusicRE();
        MusicMI mi1 = new MusicMI();
        MusicFA fa1 = new MusicFA();
        MusicSOL sol1 = new MusicSOL();
        MusicLA la1 = new MusicLA();
        MusicSI si1 = new MusicSI();
        
        HBox hbox = new HBox();
        hbox.setSpacing(52);
        Text text1 = new Text("DO");
        Text text2 = new Text("RE");
        Text text3 = new Text("MI");
        Text text4 = new Text("FA");
        Text text5 = new Text("SOL");
        Text text6 = new Text("LA");
        Text text7 = new Text("SI");
        
        Button btn1 = new Button("DO");
        Button btn2 = new Button("RE");
        Button btn3 = new Button("MI");
        Button btn4 = new Button("FA");
        Button btn5 = new Button("SOL");
        Button btn6 = new Button("LA");
        Button btn7 = new Button("SI");

        com.add(new Composite1(3, 0, la1), new Composite1(3, 0, fa1),
                new Composite1(3, 0, do1), new Composite1(3, 1, fa1),
                new Composite1(0.5, 0, la1), new Composite1(0.5, 0, mi1),
                new Composite1(0.5,0,do1),new Composite1(0.5,0,mi1),
                new Composite1(0.5,1,la1)
                );
        com.setRate(1.0101);

        com.play();
        com.removeAll();
        com.setRate(1);
        btn1.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #c6ccd4, #c2c5cb, #bcbec2, #b7b7b9, #b0b0b0);\n" +
                        "-fx-border-color: black;\n" +
                        "-fx-border-style: solid;"
                        );
        btn1.setPrefSize(47,270);
        btn2.setStyle(
                "-fx-background-color:linear-gradient(to bottom, #c6ccd4, #c2c5cb, #bcbec2, #b7b7b9, #b0b0b0);" +
                        "-fx-border-color: black;\n" +
                        "-fx-border-style: solid;" +
                        "");
        btn2.setPrefSize(47,270);
        btn3.setStyle(
                "-fx-background-color:linear-gradient(to bottom, #c6ccd4, #c2c5cb, #bcbec2, #b7b7b9, #b0b0b0);\n" +
                        "-fx-border-color: black;\n" +
                        "-fx-border-style: solid;" +
                        "");
        btn3.setPrefSize(47,270);
        btn4.setStyle(
                "-fx-background-color:linear-gradient(to bottom, #c6ccd4, #c2c5cb, #bcbec2, #b7b7b9, #b0b0b0);\n" +
                        "-fx-border-color: black;\n" +
                        "-fx-border-style: solid;" +
                        "");
        btn4.setPrefSize(47,270);
        btn5.setStyle(
                "-fx-background-color:linear-gradient(to bottom, #c6ccd4, #c2c5cb, #bcbec2, #b7b7b9, #b0b0b0);" +
                        "-fx-border-color: black;\n" +
                        "-fx-border-style: solid;" +
                        "");
        btn5.setPrefSize(47,270);
        btn6.setStyle(
                "-fx-background-color:linear-gradient(to bottom, #c6ccd4, #c2c5cb, #bcbec2, #b7b7b9, #b0b0b0);\n" +
                        "-fx-border-color: black;\n" +
                        "-fx-border-style: solid;" +
                        "");
        btn6.setPrefSize(47,270);
        btn7.setStyle(
                "-fx-background-color:linear-gradient(to bottom, #c6ccd4, #c2c5cb, #bcbec2, #b7b7b9, #b0b0b0);\n" +
                        "-fx-border-color: black;\n" +
                        "-fx-border-style: solid;" +
                        "");
        btn7.setPrefSize(47,270);
        com.setVolume(0);
        btn1.setOnAction((e->{
            do1.play();
        }));
        btn2.setOnAction((e->{
            re1.play();
        }));
        btn3.setOnAction((e->{
            mi1.play();
        }));
        btn4.setOnAction((e->{
            fa1.play();
        }));
        btn5.setOnAction((e->{
            sol1.play();
        }));
        btn6.setOnAction((e->{
            la1.play();
        }));
        btn7.setOnAction((e->{
            si1.play();
        }));
        
        Button btnAdd1 = new Button("Add");
        Button btnAdd2 = new Button("Add");
        Button btnAdd3 = new Button("Add");
        Button btnAdd4 = new Button("Add");
        Button btnAdd5 = new Button("Add");
        Button btnAdd6 = new Button("Add");
        Button btnAdd7 = new Button("Add");
        btnAdd1.setOnAction((e->{
            com.add(do1);
        }));
        btnAdd2.setOnAction((e->{
            com.add(re1);
        }));
        btnAdd3.setOnAction((e->{
            com.add(mi1);
        }));
        btnAdd4.setOnAction((e->{
            com.add(fa1);
        }));
        btnAdd5.setOnAction((e->{
            com.add(sol1);
        }));
        btnAdd6.setOnAction((e->{
            com.add(la1);
        }));
        btnAdd7.setOnAction((e->{
            com.add(si1);
        }));
        
        Button playComp = new Button("PLAY");
        playComp.setOnAction((e->{
        com.play();
        com.removeAll();

        }));
        
        HBox hbox4 = new HBox();
        hbox4.getChildren().add(playComp);
        hbox4.setLayoutX(100);
        
        HBox hbox3 = new HBox();
        btnAdd1.setPrefWidth(47);
        btnAdd2.setPrefWidth(47);
        btnAdd3.setPrefWidth(47);
        btnAdd4.setPrefWidth(47);
        btnAdd5.setPrefWidth(47);
        btnAdd6.setPrefWidth(47);
        btnAdd7.setPrefWidth(47);
        hbox3.getChildren().addAll(btnAdd1, btnAdd2, btnAdd3, btnAdd4, btnAdd5, btnAdd6, btnAdd7);
        
        
        HBox hbox2 = new HBox();

        hbox2.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6, btn7);
        
        hbox.getChildren().addAll(text1, text2, text3, text4, text5, text6, text7);
        //pane.getChildren().add(hbox);
        pane.getChildren().add(hbox2);
        pane.getChildren().add(hbox3);
        pane.getChildren().add(hbox4);

        DropShadow shadow = new DropShadow();
        Scene scene = new Scene(pane, 480, 300);
        scene.setOnKeyPressed(key->{
            KeyCode keyCode = key.getCode();
            if(keyCode.equals(KeyCode.Z)){
                do1.play();


            }
            if(keyCode.equals(KeyCode.X)){
                re1.play();
            }
            if(keyCode.equals(KeyCode.C)){
                mi1.play();
            }
            if(keyCode.equals(KeyCode.V)){
                fa1.play();
            }
            if(keyCode.equals(KeyCode.B)){
                sol1.play();
            }
            if(keyCode.equals(KeyCode.N)){
                la1.play();
            }
            if(keyCode.equals(KeyCode.M)){
                si1.play();
            }
            else{
            btn1.setEffect(null);}
        });
        primaryStage.setTitle("Music App");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
   
    public static void main(String[] args) {
       launch(args);
    }
    
}
