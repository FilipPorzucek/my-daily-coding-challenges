package pl.filip.fxproperties.controler;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class VolumeControler {

    @FXML
    private Label volumeLevelLabel;

    @FXML
    private Slider volumeSlider;
    public void initialize(){
      volumeLevelLabel.textProperty().bind(volumeSlider.valueProperty().asString());


      volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
          @Override
          public void changed(ObservableValue<? extends Number> observableValue, Number oldnumber, Number newnumber) {
              double volume=(Double) newnumber;
              if(volume>75){
                  System.out.println("Za głosno");
              }else if(volume<10){
                  System.out.println("Za cicho");
              }
          }
      });
    }

}
