module fxProperties {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    exports pl.filip.fxproperties.main to javafx.graphics;
    opens  pl.filip.fxproperties.controler to javafx.fxml;
}