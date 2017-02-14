package dekes03_assing2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OneTwoThree extends Application {

    public void start(Stage primaryStage) {

        //defining the three different text elements
        Text one = new Text(15, 20, "One");
        Text two = new Text(250, 150, "Two");
        Text three = new Text(430, 285, "Three");

        //defining and customizing the three recatangle elements
        Rectangle blue = new Rectangle(0, 0, 500, 100);
        blue.setFill(Color.BLUE);

        Rectangle green = new Rectangle(0, 100, 500, 200);
        green.setFill(Color.GREEN);

        Rectangle red = new Rectangle(0, 200, 500, 300);
        red.setFill(Color.RED);

        //defining text fonts
        one.setFont(Font.font("Arial", 20));
        two.setFont(Font.font("Arial", 20));
        three.setFont(Font.font("Arial", 20));

        Group root = new Group();
        root.getChildren().addAll(blue, green, red, one, two, three); //attach children
        Scene scene = new Scene(root, 500, 300); //defining scene

        //setting primary stage
        primaryStage.setTitle("One,two,three");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }
}
