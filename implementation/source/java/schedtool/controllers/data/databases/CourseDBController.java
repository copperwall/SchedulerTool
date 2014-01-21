package controllers.data.databases;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/* Import Models */
import models.data.*;

public class CourseDBController {
    CourseDB model = new CourseDB();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void addCourse(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CourseDBAddView.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    void cancelChanges(ActionEvent event) {
    }

    @FXML
    void deleteCourse(ActionEvent event) {
    }

    @FXML
    void editCourse(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CourseDBEditView.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    void saveChanges(ActionEvent event) {
        this.model.save_changes();
    }

    @FXML
    void initialize() {
        System.out.println("CourseDBController initialized.");
    }

}
