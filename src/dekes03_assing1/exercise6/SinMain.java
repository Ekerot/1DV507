package dekes03_assing1.exercise6;

import org.knowm.xchart.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ekerot on 2017-01-12.
 */

public class SinMain {

    public static void main(String[] args){

        List<Double> xData = new ArrayList<>();
        List<Double> yData= new ArrayList<>();

        for(double x = 0; x < 2*Math.PI; x += 2*Math.PI/1000) { //needed to use 1000plots or more to get a nice looking graf
                xData.add(x); //first get all the values for the x axis
        }

        for(int i =0; i <xData.size(); i++){  //get the values for plotting the x on the y axis
            yData.add((1 + xData.get(i)/Math.PI)*Math.cos(xData.get(i))*Math.cos(40*xData.get(i)));
        }

        //make a nice chart, not very costumized but it looks ok
        XYChart chart = QuickChart.getChart("Sinus Curve", "X", "Y", " ", xData, yData);
        chart.getStyler().setMarkerSize(16);
        chart.getStyler().setHasAnnotations(true);

        new SwingWrapper<>(chart).displayChart();

    }
}


