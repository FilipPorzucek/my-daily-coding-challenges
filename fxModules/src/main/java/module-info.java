module fxModules {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.filip.fxmodules.main;
    opens com.filip.fxmodules.controler to javafx.fxml;
}