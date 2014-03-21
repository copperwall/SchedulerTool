package controllers.data.databases;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/* Import Models */
import models.data.databases.CourseDB;
import models.data.databases.Course;

/**
 * This class is a controller for the Add Course to database page. Add course
 * is available.
 * @author Katie Keim
 */
public class CourseDBAddController {

	/**
	 * the Course database model for editing
	 */
   private CourseDB model;

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
     * The course number text field.
     */
    @FXML
    private TextField courseNoText;

    /**
     * The has lab check box.
     */
    @FXML
    private CheckBox hasLabBox;
    
    /**
     * The needs equipment check box.
     */
    @FXML
    private CheckBox equipBox;
    
    /**
     * The lab needs equipment check box.
     */
    @FXML
    private CheckBox labEquipBox;

    /**
     * The lab length text field.
     */
    @FXML
    private TextField labLengthText;

    /**
     * The lab proximity combo box.
     */
    @FXML
    private ComboBox<Course.LabProximity> labProxCombo;

    /**
     * The prefix text field.
     */
    @FXML
    private TextField prefixText;

    /**
     * The title text field.
     */
    @FXML
    private TextField titleText;

    /**
     * The number of units text field.
     */
    @FXML
    private TextField unitsText;


    /**
     * Closes the dialog without submitting.
     * @param event the button click event
     */
    @FXML
    void cancel(ActionEvent event) {
      Button src = (Button)event.getSource();
      Stage srcStage = (Stage)src.getScene().getWindow();
        
      srcStage.close();
    }

    /**
     * A change listener for the has lab check box.
     * @param event the button click listener
     */
    @FXML
    void onHasLab(ActionEvent event) {
    	labLengthText.setVisible(hasLabBox.isSelected());
    	labProxCombo.setVisible(hasLabBox.isSelected());
        labEquipBox.setVisible(hasLabBox.isSelected());
    }

    /**
     * Submits a course to add to the model and closes the dialog.
     * @param event the button click event
     */
   @FXML
   void submit(ActionEvent event) {
      boolean invalidInput = false;
      Course course;
   
      if (prefixText.getText().length() <= 0) {
         invalidInput = true;  
      }
      else if (courseNoText.getText().length() <= 0) {
         invalidInput = true;
      }

      if (!invalidInput) {
         if (hasLabBox.isSelected()) {
        	course = new Course(prefixText.getText(), Integer.valueOf(courseNoText.getText()), Integer.valueOf(unitsText.getText()), titleText.getText(), equipBox.isSelected(), Integer.valueOf(labLengthText.getText()), labProxCombo.getValue(), labEquipBox.isSelected());
         }
         else {
        	 course = new Course(prefixText.getText(), Integer.valueOf(courseNoText.getText()), Integer.valueOf(unitsText.getText()), titleText.getText(), equipBox.isSelected(), 0, null, false);
         }
         
         model.addCourse(course);
         
         cancel(event);
      }
   }
    
   /**
    * Sets the model for this dialog
    * @param mod the model for this dialog
    */
    void setModel(CourseDB mod) {
      model = mod;
    }

    /** 
     * Initializes a CourseDB Add page.
     */
    @FXML
    void initialize() {
        assert courseNoText != null : "fx:id=\"courseNoText\" was not injected: check your FXML file 'CourseDBAddView.fxml'.";
        assert hasLabBox != null : "fx:id=\"hasLabBox\" was not injected: check your FXML file 'CourseDBAddView.fxml'.";
        assert labLengthText != null : "fx:id=\"labLengthText\" was not injected: check your FXML file 'CourseDBAddView.fxml'.";
        assert labProxCombo != null : "fx:id=\"labProxCombo\" was not injected: check your FXML file 'CourseDBAddView.fxml'.";
        assert prefixText != null : "fx:id=\"prefixText\" was not injected: check your FXML file 'CourseDBAddView.fxml'.";
        assert titleText != null : "fx:id=\"titleText\" was not injected: check your FXML file 'CourseDBAddView.fxml'.";
        assert unitsText != null : "fx:id=\"unitsText\" was not injected: check your FXML file 'CourseDBAddView.fxml'.";

       labProxCombo.getItems().clear();
       labProxCombo.getItems().addAll(Course.LabProximity.values());
       labLengthText.setVisible(hasLabBox.isSelected());
       labProxCombo.setVisible(hasLabBox.isSelected());
       labEquipBox.setVisible(hasLabBox.isSelected());
    }
}
