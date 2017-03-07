package dekes03_assing1.exercise6;

import org.knowm.xchart.*;
import org.knowm.xchart.style.PieStyler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Histogram {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Integer> prime;
        prime = add();

        int one = 0, two = 0, three = 0, four = 0, five = 0,
                six = 0, seven = 0, eight = 0, nine = 0, ten = 0, other = 0;

        for (int j = 0; j < prime.size(); j++) {

            if (prime.get(j) <= 10) {
                one++;
            } else if (prime.get(j) > 10 && prime.get(j) <= 20) {
                two++;
            } else if (prime.get(j) > 20 && prime.get(j) <= 30) {
                three++;
            } else if (prime.get(j) > 30 && prime.get(j) <= 40) {
                four++;
            } else if (prime.get(j) > 40 && prime.get(j) <= 50) {
                five++;
            } else if (prime.get(j) > 50 && prime.get(j) <= 60) {
                six++;
            } else if (prime.get(j) > 60 && prime.get(j) <= 70) {
                seven++;
            } else if (prime.get(j) > 70 && prime.get(j) <= 80) {
                eight++;
            } else if (prime.get(j) > 80 && prime.get(j) <= 90) {
                nine++;
            } else if (prime.get(j) > 90 && prime.get(j) <= 100) {
                ten++;
            } else {
                other++;
            }
        }

        histogram(one, two, three, four, five, six, seven, eight, nine, ten, other);
        showPieChart(one, two, three, four, five, six, seven, eight, nine, ten, other);
    }

    public static ArrayList<Integer> add() { //adding temp list into prime list

        ArrayList<Integer> temp = new ArrayList<>();

        try {
            File file = new File("heltal.dat");

            Scanner scan = new Scanner(file);

            while (scan.hasNext()) {
                int digit = scan.nextInt();
                temp.add(digit);
            }
            scan.close();

        } catch (FileNotFoundException e) { //Exception if no file found
            System.err.println(e + "The file is not found, restart and try again!");
            System.exit(0);
        }

        return temp;

    }

    //here is where this exercise begins, method makes a histogram from the results from heltal.dat
    public static void histogram(int one,int two,int three,int four,int five,
                                 int six,int seven,int eight,int nine,int ten,int other) {

        //creating and defining the chart
        CategoryChart chart = new CategoryChartBuilder().width(800).
                height(600).title("Histogram").xAxisTitle("Interval").
                yAxisTitle("Amount").build();

        //Customize chart
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setLegendVisible(false);

        //adding series to the chart
        chart.addSeries("Numbers", Arrays.asList(new String[] { "0-10", "11-20", "21-30", "31-40",
                        "41-50", "51-60", "61-70", "71-80", "81-90", "91-100", "Other"}),
                Arrays.asList(new Integer[] {one, two, three, four, five, six, seven, eight, nine, ten, other}));

        new SwingWrapper(chart).displayChart(); //displayChart
    }

    //building and displaying pie chart
    public static void showPieChart(int one,int two,int three,int four,int five,
                                    int six,int seven,int eight,int nine,int ten,int other){

        //creating and defining chart
        PieChart chart = new PieChartBuilder().width(800).height(600).title("How many in each?").build();

        //Customize chart
        chart.getStyler().setLegendVisible(false);
        chart.getStyler().setAnnotationDistance(.82);
        chart.getStyler().setPlotContentSize(.9);
        chart.getStyler().setAnnotationType(PieStyler.AnnotationType.LabelAndPercentage);

        chart.addSeries("0-10", one);
        chart.addSeries("11-20", two);
        chart.addSeries("21-30", three);
        chart.addSeries("31-40", four);
        chart.addSeries("41-50", five);
        chart.addSeries("51-60", six);
        chart.addSeries("61-70", seven);
        chart.addSeries("71-80", eight);
        chart.addSeries("81-90", nine);
        chart.addSeries("91-100", ten);
        chart.addSeries("Other", other);

        new SwingWrapper(chart).displayChart();
    }
}



