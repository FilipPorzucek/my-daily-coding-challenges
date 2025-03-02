package com.filip.fxmodules.controler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControlPaneControler {



    @FXML
    private Button lowerCaseButton;

    @FXML
    private Button upperCaseButton;

    public Button getLowerCaseButton() {
        return lowerCaseButton;
    }

    public Button getUpperCaseButton() {
        return upperCaseButton;
    }
}