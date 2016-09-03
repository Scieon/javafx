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

    Scene scene1;
    Label label;
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
   
        window = primaryStage;
        primaryStage.setTitle("Project1");

        window.setOnCloseRequest(e->{
            e.consume(); //Consume the exit request
            closeProgram();
        });

        Button button = new Button("Click Me");
        Button closeButton = new Button("Close Button");

        button.setOnAction(e->{
            boolean result = ConfirmBox.display("Title", "Are you sure you are strong?");
            System.out.println(result);
        });

        closeButton.setOnAction(e->closeProgram());

        VBox layout = new VBox();
        layout.getChildren().addAll(button, closeButton);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void closeProgram(){
        boolean answer = ConfirmBox.display("Title", "Are you sure you want to exit?");
        if(answer)
            window.close();
    }

    public static void main(String[] args) {
        //Human h1 = new Human();
        //h1.display();
        //Human.display();

        launch(args);

    }

    public static class Human{
        public static void display(){
            System.out.println("Human.display");
        }
    }
}
