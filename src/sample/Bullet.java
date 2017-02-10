package sample;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Bullet extends ImageView implements Subject {

    private final TimelineController bulletGui = new TimelineController();
    private Observer observer;

    public Bullet(int x, int y, Observer observer) {

        super("Image/bullet1.png");
        this.setFitWidth(x);
        this.setFitHeight(y);
        attach(observer);

    }

    public void attach(Observer observer){
        this.observer = observer;
    }

    public void notifyAllObservers(){observer.update(1);}

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

            if(checkCollision()){
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