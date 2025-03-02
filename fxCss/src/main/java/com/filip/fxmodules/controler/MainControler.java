package com.filip.fxmodules.controler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainControler {

    @FXML
    private ContentPaneControler contentPaneController;

    @FXML
    private ControlPaneControler controlPaneController;

    public void initialize() {
        Button lowerCaseButton = controlPaneController.getLowerCaseButton();
        Button upperCaseButton = controlPaneController.getUpperCaseButton();
        TextArea mainTextArea = contentPaneController.getMainTextArea();

        lowerCaseButton.setOnAction(event->{
            String text = mainTextArea.getText();
            mainTextArea.setText(text.toLowerCase());
        });

        upperCaseButton.setOnAction(event->{
            String text = mainTextArea.getText();
            mainTextArea.setText(text.toUpperCase());
        });

    }
}
