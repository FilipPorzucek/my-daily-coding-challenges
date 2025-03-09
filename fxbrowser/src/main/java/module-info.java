module fxbrowser {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.web;


    exports pl.filip.fxbrowser to javafx.graphics;
    opens pl.filip.fxbrowser to javafx.fxml;
}