package dekes03_assing3.exercise11;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * Created by ekerot on 2017-03-06.
 */
public class TheBallPane extends Pane {  //Class that makes a pane for the  monsters.

    private ArrayList<Ball> balls = new ArrayList<>();
    private Ball theBall;

    public ImageView add() { //add method that adds balls to the pane
        theBall = new Ball();
        balls.add(theBall);
        ImageView ball = theBall.createBall();
        getChildren().add(ball);

        return ball;
    }

    public boolean checkCollition(){ // check for collition, unfortunally it does not work
                                    // it finds collition but only for one two different objects not all.
                                    // I could solve it in another manner that would be better, instead of
                                    //using AnimationTimer it would probably be better to use timeline instead
                                    // well I try that out when not under time pressure

        if(balls.isEmpty() || balls.size() == 1){

        }

        else {

                if (theBall.getBounds().intersects(balls.get(0).getBounds().getX(),
                        balls.get(1).getBounds().getY(), 200, 200)) {   //checking if rectangular boundaries
                                                                        //intersects
                    return true;
                }
        }
        return false;
    }
}
