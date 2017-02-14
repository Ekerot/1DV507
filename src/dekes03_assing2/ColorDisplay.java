package dekes03_assing2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ColorDisplay extends Application {

    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        HBox upperBox = new HBox();  //Defining and customizing the upperBox
        upperBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        upperBox.setPrefSize(250, 100);
        upperBox.setAlignment(Pos.TOP_CENTER);
        upperBox.setPadding(new Insets(10, 10, 10, 10));
        upperBox.setSpacing(5);

        Text text = new Text(65, 50, "Display Color");
        text.setFont(Font.font("Arial", 20));


        HBox centerBox = new HBox();    //Defining and customizing the centerBox
        centerBox.setPrefSize(250, 100);
        centerBox.setAlignment(Pos.BOTTOM_CENTER);
        centerBox.setPadding(new Insets(10, 10, 10, 10));
        centerBox.setSpacing(5);

        //defining and customizing the text and text fields
        Text textRed = new Text(30, 155, "Red");
        final TextField field1 = new TextField();
        field1.setPrefSize(100, 20);

        Text textGreen = new Text(105, 155, "Green");
        final TextField field2 = new TextField();
        field2.setPrefSize(100, 20);

        Text textBlue = new Text(188, 155, "Blue");
        final TextField field3 = new TextField();
        field3.setPrefSize(100, 20);

        HBox bottomBox = new HBox();  //defining and customizing the bottomBox
        bottomBox.setPrefSize(250, 100);
        bottomBox.setAlignment(Pos.BOTTOM_CENTER);
        bottomBox.setPadding(new Insets(10, 10, 10, 10));
        bottomBox.setSpacing(5);


        Button btn = new Button("Display Color");
        btn.setPrefSize(100, 20);
        btn.setLineSpacing(5.0);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try { //catch if anything is wrong for example no inputs

                    int red = Integer.parseInt(field1.getText());  //getting the RGBnumbers
                    int blue = Integer.parseInt(field2.getText());
                    int green = Integer.parseInt(field3.getText());

                    //if number is outside the interval
                    if (red > 255 || blue > 255 || green > 255 || red < 0 || blue < 0 || green < 0) {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION); //using a alert box to pop up as a warning
                        alert.setTitle("Error");
                        alert.setHeaderText("Wrong RGB number");
                        alert.setContentText("You need to input numbers between 0-255");
                        alert.showAndWait();

                    } else {

                        String hex = String.format("#%02x%02x%02x", red, blue, green);
                        //convert to hexadecimals

                        upperBox.setStyle("-fx-background-color: " + hex); //set the background color

                    }

                    field1.clear(); //clear the fields
                    field2.clear();
                    field3.clear();

                }
                catch(Exception e){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("No inputs!");
                    alert.setContentText("You need to input numbers between 0-255");
                    alert.showAndWait();
                }

            }
        });

        root.getChildren().addAll(textRed, textGreen, textBlue); //set children to the boxes
        upperBox.getChildren().add(text);
        centerBox.getChildren().addAll(field1, field2, field3);
        bottomBox.getChildren().add(btn);

        root.setTop(upperBox); //set where to different boxes should be placed
        root.setCenter(centerBox);
        root.setBottom(bottomBox);

        Scene scene = new Scene(root, 250, 250);  //define scene

        primaryStage.setTitle("Display Color");  //set primarey stage
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) { //to launch the application

        launch(args);

    }
}
