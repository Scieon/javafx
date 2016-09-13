package sample;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {

    public static ArrayList<Foe> foeList = new ArrayList<>(); //leak
    private Group root;
    private Player player;


    public Enemy(Group root, Player player){
        this.root = root;
        this.player = player;

    }
    public void spawn(int level){

        int [] spawnRate = {0,1}; //Spawn 1 per 5 cycle, etc..


        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), ae -> {

            for(int i=0; i<spawnRate[level];i++){

                Random rand = new Random();
                int randomXPosition = rand.nextInt(425) + 10; //50 is the maximum and the 1 is our minimum

                Foe fodder = new Foe(80, 50, player);
                fodder.setPosition(randomXPosition,0);
                //fodder.setY(n); //50 just switch back to 50 since they always start from up
                //fodder.setX(randomXPosition);

                root.getChildren().add(fodder);
                player.subject.add(fodder);
                foeList.add(fodder);
                fodder.descend();

            }
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setCycleCount(5); //number of spawning
        timeline.play();

    }

}
