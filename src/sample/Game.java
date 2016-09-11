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
    public static Enemy mob; //Privacy leak

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


        player = new Player();
        mob = new Enemy(root);
        Label label1 =  new Label("Health: " + Integer.toString(player.getHealth()));
        Label label2 =  new Label("Score: " + Integer.toString(player.getScore()));

        vbox.setSpacing(10);
        vbox.getChildren().addAll(label1, label2);

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

    public static void remove(Group root, Foe f, Bullet b){
        root.getChildren().removeAll(f,b);
    }

}
