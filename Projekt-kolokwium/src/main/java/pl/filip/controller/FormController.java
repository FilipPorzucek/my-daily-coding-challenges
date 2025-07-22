package pl.filip.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import pl.filip.util.Encryptor;
import pl.filip.util.HibernateUtil;
import pl.filip.util.UserCard;
import org.mindrot.jbcrypt.BCrypt;
import java.io.IOException;

public class FormController {

    @FXML private TextField firstNameField;
    @FXML private TextField secondNameField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private TextArea noteArea;
    @FXML private Label statusLabel;

    @FXML
    private void handleBack(){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/notes.fxml"));
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) firstNameField.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML private void handleSave(){
        String name=firstNameField.getText();
        String secondName=secondNameField.getText();
        String email=emailField.getText();
        String plainPassword = passwordField.getText();
        String password=BCrypt.hashpw(plainPassword,BCrypt.gensalt());
        String note=noteArea.getText();
        String encryptedNote;

        try {
            encryptedNote = Encryptor.encrypt(note);
        } catch (Exception e) {
            statusLabel.setText("❌ Błąd szyfrowania notatki.");
            e.printStackTrace();
            return;
        }

        if(name.isEmpty()|| secondName.isEmpty()||email.isEmpty()|| password.isEmpty()||note.isEmpty())
            statusLabel.setText("Wszystkie pola są wymagane jeśli chcesz dodać notatkę");

        UserCard user= UserCard.builder()
                .name(name)
                .secondName(secondName)
                .email(email)
                .password(password)
                .note(encryptedNote)
                .build();


        try(Session session= HibernateUtil.getSession()) {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            statusLabel.setText("Notatke zapisano pomyślnie");

        }catch (Exception e){
            statusLabel.setText("Błąd zapisuu danych"+ e.getMessage());
            e.printStackTrace();
        }

    }
}
