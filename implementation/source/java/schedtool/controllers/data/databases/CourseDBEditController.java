package controllers.data.databases;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/* Import Models */
import models.data.databases.CourseDB;
import models.data.databases.Course;

/**
 * This class is a controller for the Edit Course dialog from the Course database page.
 * @author Katie Keim
 */
public class CourseDBEditController {

	/**
	 * the Course database model for editing
	 */
   private CourseDB model;
   
   /**
    * the course to edit
    */
   private Course course;

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
     * A listener function for when the has lab check box is changed.
     * @param event the button click event
     */
    @FXML
    void onHasLab(ActionEvent event) {
    	labLengthText.setVisible(hasLabBox.isSelected());
    	labProxCombo.setVisible(hasLabBox.isSelected());
        labEquipBox.setVisible(hasLabBox.isSelected());
    }

    /**
     * Submits the edit to the model and closes the dialog.
     * @param event the button click event
     */
    @FXML
    void submit(ActionEvent event) {
    	boolean invalidInput = false;
    	   
        if (prefixText.getText().length() <= 0) {
           invalidInput = true;
        }
        else if (courseNoText.getText().length() <= 0) {
           invalidInput = true;
        }

        if (!invalidInput) {
           if (hasLabBox.isSelected()) {
        	  System.out.println("EDITTING A COURSE");
              model.editCourse(this.course, prefixText.getText(), Integer.valueOf(courseNoText.getText()), Integer.valueOf(unitsText.getText()), titleText.getText(), equipBox.isSelected(), Integer.valueOf(labLengthText.getText()), labProxCombo.getValue(), labEquipBox.isSelected());
           }
           else {
              model.editCourse(this.course, prefixText.getText(), Integer.valueOf(courseNoText.getText()), Integer.valueOf(unitsText.getText()), titleText.getText(), equipBox.isSelected(), 0, null, false);
           }
           cancel(event);
        }
    }
    
    /**
     * Sets the model.
     * @param mod the model to set
     */
    void setModel(CourseDB mod) {
      model = mod;
    }
    
    /**
     * Sets the course the dialog is editing
     * @param course the course the dialog is editing
     */
    void setCourse(Course course) {
        this.course = course;
        
        courseNoText.setText("" + course.getCourseNum());
        prefixText.setText(course.getPrefix());
        titleText.setText(course.getTitle());
        unitsText.setText("" + course.getUnits());
        hasLabBox.setSelected(course.getHasLab());
        equipBox.setSelected(course.getHasEquipment());
        
        if (hasLabBox.isSelected())
        {
     	   labLengthText.setText("" + course.getLabLength());
     	   labProxCombo.setValue(course.getLabProx());
     	   labEquipBox.setSelected(course.getLabHasEquipment());
     	   labProxCombo.setVisible(hasLabBox.isSelected());
     	   labLengthText.setVisible(hasLabBox.isSelected());
     	   labEquipBox.setVisible(hasLabBox.isSelected());
        }
    }

    /**
     * Initializes this CourseDB Edit page.
     */
    @FXML
    void initialize() {
        assert courseNoText != null : "fx:id=\"courseNoText\" was not injected: check your FXML file 'CourseDBAdd.fxml'.";
        assert hasLabBox != null : "fx:id=\"hasLabBox\" was not injected: check your FXML file 'CourseDBAdd.fxml'.";
        assert labLengthText != null : "fx:id=\"labLengthText\" was not injected: check your FXML file 'CourseDBAdd.fxml'.";
        assert labProxCombo != null : "fx:id=\"labProximityText\" was not injected: check your FXML file 'CourseDBAdd.fxml'.";
        assert prefixText != null : "fx:id=\"prefixText\" was not injected: check your FXML file 'CourseDBAdd.fxml'.";
        assert titleText != null : "fx:id=\"titleText\" was not injected: check your FXML file 'CourseDBAdd.fxml'.";
        assert unitsText != null : "fx:id=\"unitsText\" was not injected: check your FXML file 'CourseDBAdd.fxml'.";

       courseNoText.setEditable(false);
       prefixText.setEditable(false);
       labLengthText.setVisible(hasLabBox.isSelected());
       labProxCombo.getItems().clear();
       labProxCombo.getItems().addAll(Course.LabProximity.values());
       labProxCombo.setVisible(hasLabBox.isSelected());
       labEquipBox.setVisible(hasLabBox.isSelected());
    }
}
