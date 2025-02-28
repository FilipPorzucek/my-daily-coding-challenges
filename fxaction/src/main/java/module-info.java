module fxaction {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    exports pl.filip.fxaction.main to javafx.graphics;
    opens pl.filip.fxaction.controler to javafx.fxml;

}