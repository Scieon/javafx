package sample;


import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import static java.lang.Thread.sleep;


/**
 * Bullet extends rectangle
 */
public class Bullet extends Rectangle {

    private Group root;

    public Bullet(int x, int y, Group root) {

        super(x, y);
        this.root = root;

    }

    /**
     * Move bullet up in timed intervals
     */
    public void move(){
        //move bullet according to slot timer and remove it from scene when it touches
        //a) the ceiling
        //b) an enemy
        //c) another bullet
        final long startNanoTime = System.nanoTime();

        Bullet bullet = this;
        Task<Integer> task = new Task<Integer>() {

            @Override protected Integer call() throws Exception {
                int iterations;
                for (iterations = 0; iterations < 100; iterations++) {
                    if (isCancelled()) {
                        break;
                    }
                    //System.out.println("Iteration " + iterations);

                    bullet.setY(bullet.getY()-10);
                    if(bullet.getY()<=0){
                        System.out.println("Deleting");

                        break;
                    }
                    sleep(100);


                }
                return iterations;
            }
            //task.call();
        };

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
        //root.getChildren().remove(bullet);
    }

    public void move2(){

        Bullet bullet = this;

        /*
        final long startNanoTime = System.nanoTime();
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                //double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                bullet.setY(bullet.getY()-10);
                if(bullet.getY()<=100){
                    System.out.println("Deleting");
                    root.getChildren().remove(bullet);
                    System.out.println("stopping");
                    this.stop();
                }

            }
        }.start();
        */

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), ae -> {
            bullet.setY(bullet.getY()-10);
            if(bullet.getY()<=0){
                root.getChildren().remove(bullet);
                //System.out.println("gone");
            }
        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setCycleCount(35);
        timeline.play();
    }


}