package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Main extends Application{ //implements EventHandler<ActionEvent>{

    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Label label1 =  new Label("Scene 1");
        Button button1 = new Button("Go to Scene 2");
        button1.setOnAction(e->primaryStage.setScene(scene2));

        //Layout 1
        VBox layout1 = new VBox(20); //Spaced out 20px
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200, 200);

        Button button2 = new Button("Go back to scene 1");
        button2.setOnAction(e->primaryStage.setScene(scene1));

        //Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 300);

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Project1");
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }
}
