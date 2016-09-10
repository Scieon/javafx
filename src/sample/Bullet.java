package sample;


import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

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
            if(true){

                if(this.intersects(Enemy.fodder.getBoundsInParent())) {
                    //System.out.println("Collision");
                    root.getChildren().removeAll(this, Enemy.fodder);
                }

                for(Node r : root.getChildren()){
                   // System.out.println(r);
                }
                //System.out.println("pause");
                //impl_pickNode(428.0, 278.0);

                Bounds b1 = this.getBoundsInLocal();
                if(this.getBoundsInParent().intersects(Game.mob.getBoundsInParent())){
                    System.out.println("colliding");
                }
//                System.out.println("colliding");
            }

        }));

        //Cycle count is rough approximation 35 times * -10 px = -350 px going upwards
        //Interval is 50ms ticking at 10px
        //Should replace timeline by better threading option

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setCycleCount(35);
        timeline.play();
    }

    public void checkCollision(){
        Group root = (Group)this.getParent();

        ArrayList<Node> arr = new ArrayList<>();

        for(Node r : root.getChildren()){
            arr.add(r);

        }
        Rectangle r1, r2;

        for(int i=2; i<arr.size();i++){
             r1 = (Rectangle)arr.get(i);
            if(r1.getWidth() == 80) //Got the foe
                break;
            if(this.intersects(root.getBoundsInParent())){

            }
        }

        for(int i=2; i<arr.size();i++){
            r2 = (Rectangle)arr.get(i);
            if(r2.getWidth() == 10){ //Got the bullet

            }

        }

    }

}