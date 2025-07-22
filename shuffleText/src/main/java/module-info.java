module shuffleText {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    exports pl.filip.shuffleText.main to javafx.graphics;
    opens pl.filip.shuffleText.controler to javafx.fxml;

}