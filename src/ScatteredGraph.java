import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.String;
import java.lang.Double;
import java.util.LinkedList;


public class ScatteredGraph extends Application {

    static LinkedList<Double> x_axis_list=new LinkedList<>();
    static LinkedList<Double> y_axis_list=new LinkedList<>();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Scatter Chart Sample");
        final NumberAxis xAxis = new NumberAxis(0.0, 10.0, 0.25);
        final NumberAxis yAxis = new NumberAxis(-100.0, 500.0, 20.0);
        final ScatterChart<Number,Number> scatterChart = new ScatterChart<>(xAxis,yAxis);
        xAxis.setLabel("X-axis");
        yAxis.setLabel("Y-axis");
        scatterChart.setTitle("Radar Coordinates");

        XYChart.Series series = new XYChart.Series();
        series.setName("Coordinates");
        for(int i=0;i<x_axis_list.size();i++){
            series.getData().add(new XYChart.Data(x_axis_list.get(i),y_axis_list.get(i)));
        }

        scatterChart.getData().addAll(series);
        Scene scene  = new Scene(scatterChart, 1500, 900);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\91992\\Documents\\xyz.txt");
            BufferedReader tempbuffer = new BufferedReader(new FileReader(file));
            String string;
            while (((string = tempbuffer.readLine()) != null)) {
                String[] line = string.split("\t");
                x_axis_list.addLast(Double.parseDouble(line[0]));
                y_axis_list.addLast(Double.parseDouble(line[1]));
            }
            launch(args);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
