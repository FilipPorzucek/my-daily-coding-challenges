package pl.filip.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
import pl.filip.util.Encryptor;
import pl.filip.util.UserCard;

public class PasswordPromptController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    private UserCard userCard;

    public void setUserCard(UserCard userCard) {
        this.userCard = userCard;
    }

    @FXML
    private void handleDecrypt() {
        String enteredPassword = passwordField.getText();

        if (BCrypt.checkpw(enteredPassword, userCard.getPassword())) {
            try {
                String decryptedNote = Encryptor.decrypt(userCard.getNote());


                NoteViewer.showNote(decryptedNote);


                Stage stage = (Stage) passwordField.getScene().getWindow();
                stage.close();

            } catch (Exception e) {
                statusLabel.setText("Błąd odszyfrowania notatki.");
                e.printStackTrace();
            }
        } else {
            statusLabel.setText("Niepoprawne hasło.");
        }
    }
}

