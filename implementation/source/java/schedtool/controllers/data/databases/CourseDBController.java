package controllers.data.databases;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.fxml.JavaFXBuilderFactory;
/* Import Models */
import models.data.databases.CourseDB;
import models.data.databases.Course;
import models.data.databases.InstructorDB;

/**
 * This class is a controller for the Course database page. Add/edit/delete course
 * are available.
 * @author Katie Keim
 */
public class CourseDBController implements Observer{
    CourseDB model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableView<Course> courseTable;

    @FXML
    void addCourse(ActionEvent event) {
        try {
            URL location = getClass().getResource("/views/data/databases/CourseDBAddView.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
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
      Course selected = courseTable.getSelectionModel().getSelectedItem();
     
      model.deleteCourse(selected);
   }

    @FXML
    void editCourse(ActionEvent event) {
    	try {
            URL location = getClass().getResource("/views/data/databases/CourseDBEditView.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
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
        
        model = new CourseDB();
        model.addObserver(this);
    }
    
   @Override
	public void update(Observable o, Object arg) {
		ObservableList<Course> items = courseTable.getItems();
		courseTable.setItems(null);
		items.clear();
		items.addAll(model.getAllCourses());
		courseTable.setItems(items);
		items.add(new Course());
		items.remove(items.size() -1);
		System.out.println("Course DB table updated");
	}
}