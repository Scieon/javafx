package sample;


import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle implements Observer{


    private List<Subject> subject = new ArrayList<>();
    private final int playerWidth = 100;
    private final int playerHeight = 50;
    private int health;
    private int score;
    private Game game;

    public Player(Game game) {
        this.setX(256-playerWidth/2);
        this.setY(400);
        this.setWidth(playerWidth);
        this.setHeight(playerHeight);
        this.health = 3;
        this.score = 0;
        this.game = game;
    }

    public void update(){
        this.increaseScore();
        game.updateText();
    }

    public void detachSubject(Subject subject){
        this.subject.remove(subject);
    }

    public void decreaseHealth(){
        this.health--;
    }

    public int getHealth(){
        return health;
    }

    public void increaseScore(){
        this.score++;
    }

    public int getScore(){
        return score;
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
                //Root should be here since it cannot be initialized in constructor (null pointer)
                Group root = (Group)this.getParent();
                Bullet bullet = new Bullet(10,50, this);
                bullet.setX(this.getX() + playerWidth/2);
                bullet.setY(this.getY() - playerHeight);
                root.getChildren().add(bullet);
                subject.add(bullet);
                bullet.move();

            }
        }
    }
}