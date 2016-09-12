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
import java.util.List;

public class Bullet extends Rectangle implements Subject {

    final BulletController bulletGui = new BulletController();
    private Observer observer;

    public Bullet(int x, int y, Observer observer) {

        super(x, y);
        attach(observer);

    }

    public void attach(Observer observer){
        this.observer = observer;
    }

    public void notifyAllObservers(){
        observer.update();
    }

    /**
     * Moves bullet vertically while handling possible collision scenarios
     * a) the ceiling [CHECK]
     * b) an enemy [CHECK]
     * c) another bullet
     */

    public void move(){

        Group root = (Group)this.getParent();
        //Ceiling collision
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), ae -> {
            this.setY(this.getY()-10);
            if(this.getY()<=0){
                root.getChildren().remove(this);
                observer.detachSubject(this);
                //System.out.println("gone");
                bulletGui.btn_stopmes();
            }

            if(checkCollision() ==  true){
                bulletGui.btn_stopmes();
                observer.detachSubject(this);
                //System.out.println("gone");
                notifyAllObservers();
            }

        }));

        //Cycle count is rough approximation 35 times * -10 px = -350 px going upwards
        //Interval is 50ms ticking at 10px
        //Should replace timeline by better threading option

        timeline.setCycleCount(Animation.INDEFINITE);
        bulletGui.setAnimation(timeline);
        timeline.setCycleCount(40);
        timeline.play();
    }

    public boolean checkCollision(){

        Group root = (Group)this.getParent();

        for(Foe f : Enemy.foeList){
            if(this.intersects(f.getBoundsInParent())){
                //System.out.println("Collision");

                root.getChildren().removeAll(this, f);
                Enemy.foeList.remove(f);
                return true;

            }
        }
        return false;
    }

}