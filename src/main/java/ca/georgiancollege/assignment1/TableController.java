package ca.georgiancollege.assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableController {

    DBUtility db = new DBUtility("Assignment1", "GenshinImpact");

    @FXML
    private Button graphButton;

    @FXML
    private TableView<GenshinData> tableView;

    @FXML
    void handleGraphButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("graph-view.fxml"));
        Stage stage = (Stage)graphButton.getScene().getWindow();
        stage.setScene(new Scene(root, 700, 400));
    }

    public void initialize(){
        // Create Table
        TableColumn<GenshinData, String> versionColumn = new TableColumn<>("Version");
        versionColumn.setCellValueFactory( // links to the GenshinData
                //parameter refers to instance variable of GenshinData class of String datatype
                new PropertyValueFactory<>("version")
        );

        TableColumn<GenshinData, String> characterColumn = new TableColumn<>("Character");
        characterColumn.setCellValueFactory(
                new PropertyValueFactory<>("character")
        );

        TableColumn<GenshinData, String> revenueColumn = new TableColumn<>("Revenue");
        revenueColumn.setCellValueFactory(
                new PropertyValueFactory<>("revenue")
        );

        TableColumn<GenshinData, String> startDateColumn = new TableColumn<>("Start Date");
        startDateColumn.setCellValueFactory(
                new PropertyValueFactory<>("startDate")
        );

        TableColumn<GenshinData, String> endDateColumn = new TableColumn<>("End Date");
        endDateColumn.setCellValueFactory(
                new PropertyValueFactory<>("endDate")
        );

        TableColumn<GenshinData, String> bannerDaysColumn = new TableColumn<>("Banner Days");
        bannerDaysColumn.setCellValueFactory(
                new PropertyValueFactory<>("bannerDays")
        );

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        tableView.getColumns().addAll(versionColumn, characterColumn, revenueColumn,
                startDateColumn, endDateColumn, bannerDaysColumn);

        try {
            fillFromDatabase();
        } catch (SQLException e) {
            System.out.println("The database is not initialized!!!!!!!\n " +
                    "Please follow instructions in README to initialize database and fill table data");
            throw new RuntimeException(e);
        }

    }

    private void fillFromDatabase() throws SQLException {
        ResultSet resultSet  = db.getAllRows("GenshinImpact");
        while(resultSet.next()) {
            double version = resultSet.getDouble(1);
            String character = resultSet.getString(2);
            int revenue = resultSet.getInt(3);
            String start_date = resultSet.getString(4);
            String end_date = resultSet.getString(5);
            int banner_days = resultSet.getInt(6);
            tableView.getItems().add(new GenshinData(version, character, revenue,
                    start_date, end_date, banner_days));

        }
    }

}