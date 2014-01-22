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
import models.data.databases.CourseDB;

public class CourseDBController {
    CourseDB model = new CourseDB();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void addCourse(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../views/data/databases/CourseDBAddView.fxml"));
            
            CourseDBAddController controller = (CourseDBAddController)(loader.getController());
            controller.setModel(model);
            
            Parent root = FXMLLoader.load();
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
       model.deleteCourse(null);
    }

    @FXML
    void editCourse(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../views/data/databases/CourseDBEditiew.fxml"));
            
            CourseDBEditController controller = (CourseDBEditController)(loader.getController());
            controller.setModel(model);
        
            Parent root = FXMLLoader.load();
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