package pl.filip.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.Session;
import pl.filip.util.HibernateUtil;
import pl.filip.util.UserCard;

import java.io.IOException;
import java.util.List;

public class NotesController {

    @FXML
    private VBox notesPane;


    @FXML
    public void initialize(){
        try(Session session= HibernateUtil.getSession()){
            List<UserCard> users=session.createQuery("from UserCard",UserCard.class).list();

            for(UserCard user:users){
                VBox card=new VBox();
                card.setSpacing(5);



                card.setMaxWidth(420); // lub np. 380
                card.setPrefWidth(420);
                card.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 10; -fx-padding: 10; -fx-effect: dropshadow(gaussian, gray, 5, 0.3, 0, 2);");

                Label nameLabel=new Label(user.getName()+" "+user.getSecondName());
                nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

                Label emailLabel=new Label(user.getEmail());
                emailLabel.setStyle("-fx-text-fill: #666666;");

                Label noteLabel=new Label(user.getNote());
                noteLabel.setWrapText(true);
                noteLabel.setMaxWidth(400);

                card.getChildren().addAll(nameLabel,emailLabel,noteLabel);
                notesPane.getChildren().add(card);

                card.setOnMouseClicked(event->{
                    try {
                        handleNoteClick(user);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void handleNoteClick(UserCard userCard) throws IOException {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/PasswordPrompt.fxml"));
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Podaj Hasło");

            Scene scene=new Scene(loader.load());
            stage.setScene(scene);

            PasswordPromptController controller = loader.getController();
            controller.setUserCard(userCard);

            stage.showAndWait();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddNote(ActionEvent event){
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/form.fxml"));
            Scene scene=new Scene(loader.load());
            Stage stage=(Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
