package pl.filip.shuffleText.controler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class MainPaneControler {
    @FXML
    private Button clearWindowsButton;

    @FXML
    private TextArea originalTextArea;

    @FXML
    private TextArea shuffleTextArea;

    public void initialize(){
       originalTextArea.setOnKeyReleased(keyEvent -> {
           String originalText=originalTextArea.getText();
           StringBuilder shuffleText=shuffleString(originalText);
           shuffleTextArea.setText(shuffleText.toString());
       });
       clearWindowsButton.addEventFilter(MouseEvent.MOUSE_PRESSED,MouseEvent->{
           originalTextArea.clear();
           shuffleTextArea.clear();
       });
    }

    private StringBuilder shuffleString(String originalText) {
        StringBuilder stringBuilder=new StringBuilder(originalText);
        StringBuilder reverse = stringBuilder.reverse();
        return reverse;
    }

}
