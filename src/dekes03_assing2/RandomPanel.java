package dekes03_assing2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Created by ekerot on 2016-05-27.
 */

public class RandomPanel extends Application {

    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        VBox rbox = new VBox();
        rbox.setPadding(new Insets(10, 10, 10, 10));
        rbox.setSpacing(5.0);

        final TextField right = new TextField();
        right.setEditable(false);
        right.setPrefSize(100, 20);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(5.0);

        Button btn = new Button("New Random");
        btn.setPrefSize(100, 20);
        btn.setLineSpacing(5.0);

        vbox.getChildren().add(btn);
        rbox.getChildren().add(right);
        root.setRight(rbox);
        root.setLeft(vbox);

        Scene scene = new Scene(root, 250, 50);

        primaryStage.setTitle("New Random");
        primaryStage.setScene(scene);
        primaryStage.show();

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Random rnd = new Random();
                int number = rnd.nextInt(100);

                right.setText(String.valueOf(number));

            }
        });

    }

        public static void main(String[] args) {

            RandomPanel.launch(RandomPanel.class);
        }
}

