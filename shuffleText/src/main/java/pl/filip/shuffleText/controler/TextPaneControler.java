package pl.filip.shuffleText.controler;



import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class TextPaneControler {

    @FXML
    private TextArea originalTextArea;

    @FXML
    private TextArea shuffleTextArea;

    public TextArea getOriginalTextArea() {
        return originalTextArea;
    }

    public TextArea getShuffleTextArea() {
        return shuffleTextArea;
    }

    public void initialize(){
        originalTextArea.setOnKeyReleased(keyEvent -> {
                    String originalText=originalTextArea.getText();
                     StringBuilder shuffleText=shuffleString(originalText);
                     shuffleTextArea.setText(shuffleText.toString());
                 });
    }

    private StringBuilder shuffleString(String originalText) {
        StringBuilder stringBuilder=new StringBuilder(originalText);
        StringBuilder reverse = stringBuilder.reverse();
        return reverse;
    }

}

