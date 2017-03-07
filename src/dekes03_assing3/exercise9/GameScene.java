package dekes03_assing3.exercise9;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by ekerot on 2017-03-01.
 */

public class GameScene extends Application {

    private int counter = 0;

    public void start(Stage stage) {

        BorderPane root = new BorderPane();

        VBox box = new VBox();
        box.setPrefSize(250, 100);

        stage.setTitle("Catch the creature");

        Scene scene = new Scene(root, 800, 800);

        Creature creature1 = new Creature();

        ImageView creature = creature1.creature();

        final Timeline timeline = new Timeline();

        // timeline to trigger when dialogs should show and game is over
        //this one ain´ pretty but it works well
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(300),
                ae -> {

                    if(counter == 26){
                        timeline.stop();
                        dialog(creature1);
                    }
                    counter++;
                }));

        timeline.setCycleCount(53);
        timeline.setAutoReverse(true);
        timeline.play();

        Label label = new Label("Your score: 0");

        // for each mouse click check and update stus of the result
        box.setOnMouseClicked((e) -> label.setText("Your score: " + creature1.getResult()));

        box.getChildren().addAll(creature, label);
        root.setBottom(box);

        stage.setScene(scene);

        stage.show();
    }

    //Alert dialog when game is over, present points and let the user exit game when he wants
    public void dialog(Creature creature) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION); //using a alert box
        alert.setTitle("The End");
        alert.setHeaderText("Man, you are awesome!");
        alert.setContentText("Your score: " + creature.getResult());

        ButtonType exit = new ButtonType("Exit");

        alert.getButtonTypes().setAll(exit);

        alert.showingProperty().addListener((observable,oldValue,newValue)->{
            if (!newValue){
                try {
                    close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        alert.show();
    }

    //close application
    public void close(){
        System.exit(1);
    }
}
