package dekes03_assing3.exercise11;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * Created by ekerot on 2017-03-05.
 */
public class Ball {

    private Image image;
    private ImageView ball;
    private int x;
    private int y;

    public Ball() {

        image = new Image(getClass().
                getResourceAsStream("creature.png"));
        ball = new ImageView(image);
        y = (int)((Math.random()*601)-600);
        x = (int)((Math.random()*601));
    }

    public ImageView createBall() {

        ball.setFitHeight(200);
        ball.setFitWidth(200);
        getBounds();

        return this.ball;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,200,200);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
