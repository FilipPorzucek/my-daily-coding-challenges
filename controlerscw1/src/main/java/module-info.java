module controlerscw {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    exports com.filip.mvc to javafx.graphics;
    opens com.filip.mvc to javafx.fxml;
}