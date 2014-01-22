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
import javafx.scene.layout.Pane;
import javafx.fxml.JavaFXBuilderFactory;
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
            URL location = getClass().getResource("../../../views/data/databases/CourseDBAddView.fxml");

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

            Parent root = (Parent) fxmlLoader.load(location.openStream());

            CourseDBAddController controller = (CourseDBAddController)(fxmlLoader.getController());
            controller.setModel(model);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
    
    @FXML
    void deleteCourse(ActionEvent event) {
       model.deleteCourse(0);
    }

    @FXML
    void editCourse(ActionEvent event) {
        try {
            URL location = getClass().getResource("../../../views/data/databases/CourseDBEditiew.fxml");

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

            Parent root = (Parent) fxmlLoader.load(location.openStream());

            CourseDBEditController controller = (CourseDBEditController)(fxmlLoader.getController());
            controller.setModel(model);
        
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        System.out.println("CourseDBController initialized.");
    }

}