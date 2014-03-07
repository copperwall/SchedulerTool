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
/* Import Models */
import models.data.databases.CourseDB;
import models.data.databases.Course;

/**
 * This class is a controller that ties the view and the model together for the Course database page. 
 * The user can add, edit, or delete a course.
 * It is an Observer of its model.
 * @author Katie Keim
 */
public class CourseDBController implements Observer{
	/**
	 * The Course database model to tie in.
	 */
    CourseDB model;

    /**
     * For the fxml.
     */
    @FXML
    private ResourceBundle resources;

    /**
     * For the fxml.
     */
    @FXML
    private URL location;
    
    /**
     * The table in the view to update with the model data.
     */
    @FXML
    private TableView<Course> courseTable;

    /**
     * Adds a course.
     * @param event the click button event
     */
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
    
   /**
    * Deletes the selected course.
    * @param event the button click event
    */
   @FXML
   void deleteCourse(ActionEvent event) {
      Course selected = courseTable.getSelectionModel().getSelectedItem();
     
      model.deleteCourse(selected);
   }

   /**
    * Edits the selected course.
    * @param event the button click event.
    */
    @FXML
    void editCourse(ActionEvent event) {
    	Course selected = courseTable.getSelectionModel().getSelectedItem();
    	
    	if (selected != null) {
	    	try {
	            URL location = getClass().getResource("/views/data/databases/CourseDBEditView.fxml");
	            FXMLLoader fxmlLoader = new FXMLLoader();
	            Parent root = (Parent) fxmlLoader.load(location.openStream());
	
	            CourseDBEditController controller = (CourseDBEditController)(fxmlLoader.getController());
	            controller.setModel(model);
	            controller.setCourse(selected);
	            
	            Scene scene = new Scene(root);
	            Stage stage = new Stage();
	            
	            stage.setScene(scene);
	            stage.show();
	        } catch (IOException exc) {
	            exc.printStackTrace();
	        }
    	}
    }

    /**
     * Initializes the CourseDB page.
     */
    @FXML
    void initialize() {
        System.out.println("CourseDBController initialized.");
        
        model = new CourseDB();
        model.addObserver(this);
    }
    
    /**
     * Updates the table with the changed model data.
     * @param o the Observable model this call came from
     * @param arg not used
     */
    @Override
	public void update(Observable o, Object arg) {
		ObservableList<Course> items = courseTable.getItems();
		items.setAll(model.getAllCourses());
		courseTable.setItems(items);
		System.out.println("Course DB table updated");
	}
}