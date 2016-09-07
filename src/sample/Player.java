package sample;

import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Player extends Rectangle{


    private final int playerWidth = 100;
    private final int playerHeight = 50;
    private int health;
    private int score;

    public Player() {
        this.setX(256-playerWidth/2);
        this.setY(400);
        this.setWidth(playerWidth);
        this.setHeight(playerHeight);
        //this.setArcHeight(20);
        //this.setArcWidth(20);
    }
    public void keyPressedEvent(KeyEvent e){

        if(e.getCode().toString() == "LEFT"){
            if(this.getX()>0)
                this.setX(this.getX()-25);
        }

        if(e.getCode().toString() == "RIGHT"){
            if(this.getX()+100<512)
                this.setX(this.getX()+25);
        }

        if(e.getCode().toString()=="UP"){
            //this.setY(this.getY()-25); //minus!!
        }

        if(e.getCode().toString()=="DOWN"){
            //this.setY(this.getY()+25);
        }

        if(e.getCode().toString()=="SPACE"){

            if(e.getCode().toString() == "SPACE"){
                //root.getChildren().remove(this);
                //Root should be here since it cannot be initialized in constructor (null pointer)
                Group root = (Group)this.getParent();
                Bullet bullet = new Bullet(10,50);
                bullet.setX(this.getX() + playerWidth/2);
                bullet.setY(this.getY() - playerHeight);
                root.getChildren().add(bullet);
                bullet.move();

            }
        }
    }
}