import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class scene1 extends Application{
    String[] nmenu ={"easy","medium","hard"};
    @Override
    public void start(Stage primaryStage) throws IOException {
        VBox nvBox = new VBox( 5 );
        TextField ntextField = new TextField( "Name" );
        ntextField.setMaxSize( 120,20 );
        ComboBox<String> ncbo = new ComboBox<>(  );
        ncbo.setPrefWidth(100);
        ncbo.setValue("LEVEL");
        ObservableList<String> items =
                FXCollections.observableArrayList(nmenu);
        ncbo.getItems().addAll(items);
        ImageView nimageView = new ImageView( new Image( "giphy.gif" ) );
        Button nbutton = new Button( "play" );
        nbutton.setPrefSize( 60,20 );
        ntextField.getStyleClass().add( "text" );
        ncbo.getStyleClass().add( "level" );

        nvBox.getChildren().addAll( ntextField,ncbo ,nbutton);
        StackPane nstackPane = new StackPane(  );



        Tooltip tooltipname= new Tooltip( "NICKNAME" );
        Tooltip tooltiplevel = new Tooltip( "select LEVEL" );
        ntextField.setTooltip( tooltipname );
        ncbo.setTooltip( tooltiplevel );
        tooltipname.setFont( Font.font( "Times New Roman" ,FontWeight.BOLD,12 ));
        tooltiplevel.setFont( Font.font( "Times New Roman" ,FontWeight.BOLD,12 ));
        Tooltip.install( ntextField,tooltipname );
        Tooltip.install( ncbo,tooltiplevel );

        nstackPane.getChildren().addAll( nimageView,nvBox);
        nvBox.setAlignment( Pos.CENTER );
        nbutton.getStyleClass().add( "play" );
        System.out.println(ncbo.getValue().getClass());

        nbutton.setOnAction( event -> {

            if(!ncbo.getValue().equals("LEVEL")) {
                Project1 project1 = new Project1(ntextField.getText(),ncbo.getValue());
                Stage stage1 = new Stage();
                try {
                    project1.start( stage1 );
                } catch (IOException e) {
                    e.printStackTrace();
                }
                primaryStage.hide();
            }

        } );
        Scene scene = new Scene( nstackPane,300,200 );
        scene.getStylesheets().add( "bbb.css" );

        primaryStage.setScene( scene );
        primaryStage.setTitle( "sudoku" );
        primaryStage.show();
    }
}
