package dekes03_assing3.exercise9;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Created by ekerot on 2017-03-01.
 */

public class Creature {

    private int counter = 0;
    private int key = 0;
    private int result = 0;


    public ImageView creature() {

        final Timeline timeline = new Timeline();

        Image creature = new Image(getClass().
                getResourceAsStream("creature.png"));

        ImageView poppingCreature = new ImageView(creature);

        poppingCreature.setFitHeight(200);
        poppingCreature.setFitWidth(200);

        // Timeline animation ti meke the creature popping up on different locations
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(300),
                ae -> {

                    if(key == 0) {
                        poppingCreature.setVisible(true);
                        key = 1;
                    }

                    else{
                        poppingCreature.setVisible(false);
                        key = 0;
                    }

                    //randomize location
                    int y = (int)((Math.random()*601)-600);
                    int x = (int)((Math.random()*601));

                    // set x and y location
                    poppingCreature.setTranslateX(x);
                    poppingCreature.setTranslateY(y);

                    counter++;

                    if(counter == 26)
                        timeline.stop();

                }));

        timeline.setCycleCount(53); //how many cycles. Creature will be visible 25 times
        timeline.setAutoReverse(true);
        timeline.play();


        poppingCreature.setOnMouseClicked(e -> catchedCreature());

        return poppingCreature;
    }

    public void catchedCreature() { // if creature is catched + on result

        result++;
    }

    public int getResult() {

        return result;
    }

    public int getCounter() {
        return counter;
    }
}
