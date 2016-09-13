package sample;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Game extends Application {

    private static Player player;
    private static Enemy mob;
    private Label health, score;

    @Override
    public void start(Stage window) throws Exception{

        window.setTitle("Project Animus");

        VBox vbox = new VBox(20); //Spaced out 20px

        Group root = new Group();
        Scene theScene = new Scene(root);
        window.setScene(theScene);

        Canvas canvas = new Canvas(512, 400);
        root.getChildren().add(canvas);
        window.setResizable(false);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        //Image space = new Image( "/resources/space.png" );


        player = new Player(this);
        mob = new Enemy(root, player);
        health =  new Label("Health: " + Integer.toString(player.getHealth()));
        score =  new Label("Score: " + Integer.toString(player.getScore()));

        vbox.setSpacing(10);
        vbox.getChildren().addAll(health, score);

        //--
        for(int level=0; level<=1; level++){
            mob.spawn(level);

        }

        root.getChildren().addAll(player, vbox);
        //System.out.println(root);

        theScene.setOnKeyPressed(e->{
            player.keyPressedEvent(e);

        });

        window.show();

    }

   public void updateScore(){
       score.setText("Score: " + Integer.toString(player.getScore()));
   }

   public void updateHealth(){ health.setText("Health: " + Integer.toString(player.getHealth()));}

   public void endGame(){

   }

}
