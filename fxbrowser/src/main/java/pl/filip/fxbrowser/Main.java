package pl.filip.fxbrowser;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

    @FXML
   private WebView webView;
    @FXML
    private Button nextButton;
    @FXML
    private Button backButton;

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane mainPane = FXMLLoader.load(getClass().getResource("/fxml/browserPane.fxml"));
        Scene scene = new Scene(mainPane);
        stage.setScene(scene);
        stage.setTitle("Browser");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void initialize(){
        WebEngine engine = webView.getEngine();
        engine.load("https://google.pl");
        backButton.setOnAction(event -> engine.executeScript("history.back()"));
        nextButton.setOnAction(event -> engine.executeScript("history.forward"));
    }
}
