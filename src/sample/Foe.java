package sample;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class Foe extends Rectangle {


    public Foe(int width, int height){
        this.setWidth(width);
        this.setHeight(height);
    }

    public void setPosition(int x, int y){
        this.setX(x);
        this.setY(y);
    }

    //should take a level parameter to set the speed
    public void descend(){

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), ae -> {

            this.setY(this.getY()+10);

        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setCycleCount(40);
        timeline.play();

    }




}
