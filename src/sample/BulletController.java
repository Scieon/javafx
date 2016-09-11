package sample;

import javafx.animation.Timeline;
import javafx.fxml.FXML;

public class BulletController{

    private Timeline animation;


    public void setAnimation(Timeline animation) {
        this.animation = animation;
    }

    @FXML
    public void btn_stopmes() {
        if (animation != null) {
            animation.stop();
        }
    }

}
