package sample;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;

public class Enemy extends Rectangle {

    private int health;
    private Group root;

    public Enemy(Group root){
        this.root = root;
    }
    public Enemy(int x, int y) {
        super(x, y);
    }

    public void descend(){

    }

    public void spawn(int level){

        int [] spawnRate = {0,1}; //Spawn 1 per 5 cycle, etc..

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), ae -> {

            for(int i=0; i<spawnRate[level];i++){

                Random rand = new Random();
                int randomXPosition = rand.nextInt(425) + 10; //50 is the maximum and the 1 is our minimum
                int n = rand.nextInt(300) + 10;

                Enemy fodder = new Enemy(75, 50);
                fodder.setY(n); //50 just switch back to 50 since they always start from up 
                fodder.setX(randomXPosition);
                root.getChildren().add(fodder);

            }
        }));


        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setCycleCount(5);
        timeline.play();
        //Enemy fodder = new Enemy(75, 35);
        //root.getChildren().add(fodder);
    }

}
