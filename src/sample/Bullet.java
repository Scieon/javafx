package sample;


import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Bullet extends Rectangle {

    public Bullet(int x, int y) {

        super(x, y);

    }

    /**
     * Moves bullet vertically while handling possible collision scenarios
     * a) the ceiling [CHECK]
     * b) an enemy
     * c) another bullet
     */

    public void move(){

        Group root = (Group)this.getParent();
        //Ceiling collision
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), ae -> {
            this.setY(this.getY()-10);
            if(this.getY()<=0){
                root.getChildren().remove(this);
                //System.out.println("gone");
            }

        }));

        //Cycle count is rough approximation 35 times * -10 px = -350 px going upwards
        //Interval is 50ms ticking at 10px
        //Should replace timeline by better threading option

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setCycleCount(35);
        timeline.play();
    }

}