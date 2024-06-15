module ca.georgiancollege.assignment1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ca.georgiancollege.assignment1 to javafx.fxml;
    exports ca.georgiancollege.assignment1;
}