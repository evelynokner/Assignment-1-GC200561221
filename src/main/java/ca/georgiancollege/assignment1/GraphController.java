package ca.georgiancollege.assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class GraphController {

    @FXML
    private Button tableButton;

    @FXML
    private BarChart<String, Number> graphView;
    
    @FXML
    void handleTableButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("table-view.fxml"));
        Stage stage = (Stage)tableButton.getScene().getWindow();
        stage.setScene(new Scene(root, 700, 400));
    }

    @FXML
    public void initialize(){
        // Bar Graph
        if (graphView == null)
            graphView = new BarChart<String,Number>(new CategoryAxis(), new NumberAxis());

        XYChart.Series<String, Number> data = new XYChart.Series<>();
        //x: Version #  y: Revenue in $
        data.getData().add(
                new XYChart.Data<>("1.0-1.2", 110577288)
        );
        data.getData().add(
                new XYChart.Data<>("1.3-1.5", 81546696)
        );
        data.getData().add(
                new XYChart.Data<>("1.6-2.1", 81921292)
        );
        data.getData().add(
                new XYChart.Data<>("2.2-2.4", 107217232)
        );
        data.getData().add(
                new XYChart.Data<>("2.5-2.7", 152140892)
        );
        data.getData().add(
                new XYChart.Data<>("2.8-3.2", 140777603)
        );

        graphView.setTitle("Genshin Impact Character Revenue by Version");
        graphView.getData().add(data);

    }
}
