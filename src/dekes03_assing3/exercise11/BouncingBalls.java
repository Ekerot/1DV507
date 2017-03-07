package dekes03_assing3.exercise11;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;



/**
 * Created by ekerot on 2017-03-05.
 */
public class BouncingBalls extends Application{

        public void start(Stage stage) {

            BorderPane root = new BorderPane();

            TheBallPane ballPane = new TheBallPane();
            ballPane.setMaxSize(800,800);

            VBox box = new VBox();

            stage.setTitle("Bouncing balls");

            Button button = new Button();

            button.setText("Release a monster!");
            button.setPrefSize(150, 20);

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    createAnimation(ballPane.add(), ballPane);
                }
            });

            box.getChildren().add(button);

            root.setBottom(ballPane);
            root.setTop(box);
            Scene scene = new Scene(root, 800, 800);
            stage.setScene(scene);

            stage.show();
        }

    public void createAnimation(ImageView image, TheBallPane ballPane){

        new AnimationTimer() {
            boolean up = true;
            boolean right = true;
            int y = (int)((Math.random()*601)-600);
            int x = (int)((Math.random()*601));

            @Override
            public void handle(long arg0) {
                if(right)
                {
                    if(x <= 600)
                        x += 10;
                    else if(x >= 600)
                        right=false;
                }
                else
                {
                    if(x >= 0)
                        x -= 10;
                    else if (x <= 0)
                        right = true;
                }

                if(up)
                {
                    if(y <= 0)
                        y += 10;
                    else if(y >= 0)
                        up=false;
                }
                else
                {
                    if(y >= -600)
                        y -= 10;
                    else if (y <= -600)
                        up = true;
                }
                image.setTranslateX(x);
                image.setTranslateY(y);
               if(ballPane.checkCollition()){
                   y = y-10;
                   x = x+10;
               }
                image.setTranslateX(x);
                image.setTranslateY(y);
            }

        }.start();
    }


    public static void main(String[] args) {
        launch();
    }
}

