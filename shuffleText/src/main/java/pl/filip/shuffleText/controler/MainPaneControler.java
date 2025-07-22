package pl.filip.shuffleText.controler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class MainPaneControler {
    @FXML
    private TextPaneControler textPaneController;

    @FXML
    private Button clearWindowsButton;



    public void initialize(){

        System.out.println(textPaneController);
        TextArea originalTextArea = textPaneController.getOriginalTextArea();
        TextArea shuffleTextArea = textPaneController.getShuffleTextArea();
        clearWindowsButton.setOnAction(event->{
              originalTextArea.clear();
            shuffleTextArea.clear();
          });


   }


}
