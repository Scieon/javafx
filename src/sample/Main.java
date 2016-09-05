package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.*;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Main extends Application{ //implements EventHandler<KeyEvent>{

    Scene scene1;
    Label label;
    Stage window;

    @Override
    public void start(Stage window) throws Exception{

        window.setTitle("Project Animus");

        Group root = new Group();
        Scene theScene = new Scene(root);
        window.setScene( theScene );

        Canvas canvas = new Canvas(512, 400);
        root.getChildren().add(canvas);
        window.setResizable(false);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image space = new Image( "/resources/space.png" );

        Player r = new Player(root);


//        final int playerWidth = 100;
//        final int playerHeight = 50;
//        r.setX(256-playerWidth/2);
//        r.setY(400);
//        r.setWidth(playerWidth);
//        r.setHeight(playerHeight);
//        r.setArcHeight(20);
//        r.setArcWidth(20);
        root.getChildren().add(r);

        theScene.setOnKeyPressed(e->{
            r.keyPressedEvent(e);
            System.out.println(e.getCode());


            //System.out.println(e.getText()); //gives letter
            //System.out.println(e.getEventType()); KEY_PRESSED
        });

        window.show();

    }

    private void closeProgram(){
        boolean answer = ConfirmBox.display("Title", "Are you sure you want to exit?");
        if(answer)
            window.close();
    }

    public static void main(String[] args) {

        launch(args);

    }
    
}
