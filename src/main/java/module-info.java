module ca.georgiancollege.assignment1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.georgiancollege.assignment1 to javafx.fxml;
    exports ca.georgiancollege.assignment1;
}