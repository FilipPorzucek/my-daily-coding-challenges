package pl.filip;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import pl.filip.util.HibernateUtil;
import pl.filip.util.UserCard;

public class Main extends Application {
    private static Stage primaryStage;


    @Override
    public void start(Stage stage) throws Exception {
        primaryStage=stage;
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/notes.fxml"));
        Scene scene=new Scene(loader.load());
        stage.setTitle("Notatki użytkownika");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
    launch(args);
    }
}
