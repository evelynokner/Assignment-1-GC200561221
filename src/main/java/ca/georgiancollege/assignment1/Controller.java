package ca.georgiancollege.assignment1;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {

    /*

    GRAPH VIEW: Genshin Character Revenue by patch version <- Legend
    TABLE VIEW: version(int), version_name(String), character(String)
                start_date(String), end_date(String), revenue(int), banner_days(int)

     */
    EventHandler<MouseEvent> mouseEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            //System.out.println("Random Mouse Event");
        }
    };

    @FXML
    Button graphButton, tableButton;

    public void handleTableButton() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("table-view.fxml"));
        Stage stage = (Stage)graphButton.getScene().getWindow();
        stage.setScene(new Scene(root, 600, 400));
    }

    public void initialize(){}
}
