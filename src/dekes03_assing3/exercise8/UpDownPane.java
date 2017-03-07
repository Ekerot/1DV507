package dekes03_assing3.exercise8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by ekerot on 2017-02-27.
 */
public class UpDownPane extends Application {

    private static GridPane grids;
    private int row =3, column = 3;
    private Pane pane = panes();

    public void start(final Stage stage) {

        int rows = 7, columns = 7; // initialize rows and columns

        stage.setTitle("UppDownPane");

        grid();

        Scene scene = new Scene(grids, (columns * 71) + 200, (rows * 71) + 200, Color.WHITE);

        grids.add(pane, row, column); // add to show one black square when the game starts

        // on keypress move the black square in the direction you presses
        scene.setOnKeyPressed(e -> {

            if(e.getCode() == KeyCode.LEFT) {
                row = row - 1;
                if (row < 0) { // if less then zero the square appear
                                // on the other side of the application
                    row = 6;
                }
            }
            if (e.getCode() == KeyCode.RIGHT) {
                row = row + 1;
                if (row > 6) {
                    row = 0;
                }
            }
            if (e.getCode() == KeyCode.DOWN) {
                column = column + 1;
                if (column > 6) {
                    column= 0;
                }
            }
            if (e.getCode() == KeyCode.UP) {
                column = column - 1;
                if (column < 0) {
                    column = 6;
                }
            }
            grids.getChildren().remove(pane);
            grids.add(pane, row, column);

        });

        stage.setScene(scene);
        stage.show();
    }

    static Pane panes() //black pane
    {

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: black;");
        pane.setPrefSize(100, 100);

        return pane;
    }

    static void grid(){

        int rows = 7, columns = 7;

        // creates new GridPane with constraints.
        grids = new GridPane();
        for(int i = 0; i < columns; i++) {
            ColumnConstraints column = new ColumnConstraints(100);
            grids.getColumnConstraints().add(column);
        }

        for(int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints(100);
            grids.getRowConstraints().add(row);
        }

        grids.setStyle("-fx-grid-lines-visible: true");
    }

    // launch application
    public void launch(Class<UpDownMain> upDownMainClass) {
        launch();
    }
}



