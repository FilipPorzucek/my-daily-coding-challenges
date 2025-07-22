package pl.filip.controller;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NoteViewer {

    public static void showNote(String noteContent) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Twoja notatka");

        Label noteLabel = new Label(noteContent);
        noteLabel.setWrapText(true);
        noteLabel.setStyle("-fx-font-size: 14px; -fx-padding: 20;");

        VBox layout = new VBox(noteLabel);
        layout.setStyle("-fx-background-color: #ffffff;");
        layout.setPrefSize(400, 300);

        stage.setScene(new Scene(layout));
        stage.showAndWait();
    }
}

