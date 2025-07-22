package com.filip.mvc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controler {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Label label1;

    @FXML
    private Label label2;


    public void initialize(){
      label1.setText("Etykieta1");
      label2.setText("Etykieta2");
      button1.setText("Przycisk1");
      button2.setText("Przycisk2");
    }
}
