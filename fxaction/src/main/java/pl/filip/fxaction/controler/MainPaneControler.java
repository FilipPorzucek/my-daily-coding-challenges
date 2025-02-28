package pl.filip.fxaction.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class MainPaneControler {

    @FXML
    private Button lowerCaseButton;

    @FXML
    private TextArea mainTextArea;

    public void initialize() {


        }

public void toLowerCaseAction(ActionEvent event){
            System.out.println("Wcisnieto przycisk");
            System.out.println(event.getEventType());
            String originalText = mainTextArea.getText();
            String lowerText = originalText.toLowerCase();
            mainTextArea.setText(lowerText);

    }


}