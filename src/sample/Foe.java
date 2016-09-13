package sample;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Foe extends Rectangle implements Subject{

    private final TimelineController foeGui = new TimelineController();
    private Observer observer;

    public Foe(int width, int height, Observer observer){
        this.setWidth(width);
        this.setHeight(height);
        this.observer = observer;

    }

    public void attach(Observer observer){
        this.observer = observer;
    }

    public void notifyAllObservers(){
        observer.update(2);
    }

    public void setPosition(int x, int y){
        this.setX(x);
        this.setY(y);
    }

    //should take a level parameter to set the speed
    public void descend(){

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), ae -> {

            this.setY(this.getY()+40);

            if(this.getParent() == null)
                foeGui.btn_stopmes();
            if(this.getY() > 400 ){//& this.getParent() != null){
                //System.out.println("lose");
                Group root = (Group)this.getParent();
                root.getChildren().remove(this);
                notifyAllObservers();
                observer.detachSubject(this);
                foeGui.btn_stopmes();
            }

        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        foeGui.setAnimation(timeline);
        timeline.setCycleCount(40);
        timeline.play();

    }




}
