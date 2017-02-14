package dekes03_assing2.exercise6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.Random;


public class RandomPanel extends Application {

    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        HBox leftBox = new HBox();  //constructing the upperBox and customizing it

        Text text = new Text("");

        HBox rightBox = new HBox(); //constructing the upperBox and customizing it
        text.setTextAlignment(TextAlignment.LEFT);

        Button btn = new Button("New Random"); //Customizing and defining the button
        btn.setMaxSize(180, 100);

        leftBox.getChildren().add(btn);    //attach button and text to their respectively pane
        rightBox.getChildren().add(text);

        root.setLeft(leftBox);
        root.setRight(rightBox);

        Scene scene = new Scene(root, 270, 100);  //define

        primaryStage.setTitle("New Random");  //Set the primary stage
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        btn.setOnAction(new EventHandler<ActionEvent>() {  //eventhandler for button

            @Override
            public void handle(ActionEvent event) { // action random int between 1 - 100

                Random rnd = new Random();
                int number = rnd.nextInt(101);

                text.setFont(Font.font(number));
                text.setText(String.valueOf(number));
            }
        });
    }
}

