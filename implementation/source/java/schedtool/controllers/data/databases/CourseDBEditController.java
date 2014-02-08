package controllers.data.databases;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
 * This class is a controller for the Edit Course dialog in the Course database page.
 * @author Katie Keim
 */
public class CourseDBEditController {

   private CourseDB model;
   private Course course;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField courseNoText;

    @FXML
    private CheckBox hasLabBox;

    @FXML
    private TextField labLengthText;

    @FXML
    private ComboBox<Course.LabProximity> labProxCombo;

    @FXML
    private TextField prefixText;

    @FXML
    private TextField titleText;

    @FXML
    private TextField unitsText;


    @FXML
    void cancel(ActionEvent event) {
      Button src = (Button)event.getSource();
      Stage srcStage = (Stage)src.getScene().getWindow();
        
      srcStage.close();
    }

    @FXML
    void onHasLab(ActionEvent event) {
      labLengthText.setEditable(hasLabBox.isSelected());
    }

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
              model.editCourse(prefixText.getText(), Integer.valueOf(courseNoText.getText()), hasLabBox.isSelected(), Integer.valueOf(unitsText.getText()), titleText.getText(), Integer.valueOf(labLengthText.getText()), labProxCombo.getValue());
           }
           else {
              model.editCourse(prefixText.getText(), Integer.valueOf(courseNoText.getText()), hasLabBox.isSelected(), Integer.valueOf(unitsText.getText()), titleText.getText());
           }
           cancel(event);
        }
    }
    
    void setModel(CourseDB mod) {
      model = mod;
    }
    
    void setCourse(Course course) {
        this.course = course;
        
        courseNoText.setText("" + course.getCourseNum());
        prefixText.setText(course.getPrefix());
        titleText.setText(course.getTitle());
        unitsText.setText("" + course.getUnits());
        hasLabBox.setSelected(course.getHasLab());
        
        if (hasLabBox.isSelected())
        {
     	   labLengthText.setText("" + course.getLabLength());
     	   labProxCombo.setValue(course.getLabProx());
     	   
     	   labLengthText.setEditable(hasLabBox.isSelected());
        }
    }

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
       labLengthText.setEditable(hasLabBox.isSelected());
       labProxCombo.getItems().clear();
       labProxCombo.getItems().addAll(Course.LabProximity.values());
    }
    
    /* From http://stackoverflow.com/questions/14206768/how-to-check-if-a-string-is-numeric */
    public boolean isNumeric(String s) {  
        return s.matches("[-+]?\\d*\\.?\\d+");  
    }
}
