package sample;


import javafx.animation.AnimationTimer;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

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
}