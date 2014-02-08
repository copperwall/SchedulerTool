package controllers.data.databases;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
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

   private CourseDB model;

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
    	 System.out.println("ADDING A COURSE");
         if (hasLabBox.isSelected()) {
            model.addCourse(prefixText.getText(), Integer.valueOf(courseNoText.getText()), hasLabBox.isSelected(), Integer.valueOf(unitsText.getText()), titleText.getText(), Integer.valueOf(labLengthText.getText()), labProxCombo.getValue());
         }
         else {
            model.addCourse(prefixText.getText(), Integer.valueOf(courseNoText.getText()), hasLabBox.isSelected(), Integer.valueOf(unitsText.getText()), titleText.getText());
         }
         cancel(event);
      }
   }
    
    void setModel(CourseDB mod) {
      model = mod;
    }

    @FXML
    void initialize() {
        assert courseNoText != null : "fx:id=\"courseNoText\" was not injected: check your FXML file 'CourseDBAddView.fxml'.";
        assert hasLabBox != null : "fx:id=\"hasLabBox\" was not injected: check your FXML file 'CourseDBAddView.fxml'.";
        assert labLengthText != null : "fx:id=\"labLengthText\" was not injected: check your FXML file 'CourseDBAddView.fxml'.";
        assert labProxCombo != null : "fx:id=\"labProxCombo\" was not injected: check your FXML file 'CourseDBAddView.fxml'.";
        assert prefixText != null : "fx:id=\"prefixText\" was not injected: check your FXML file 'CourseDBAddView.fxml'.";
        assert titleText != null : "fx:id=\"titleText\" was not injected: check your FXML file 'CourseDBAddView.fxml'.";
        assert unitsText != null : "fx:id=\"unitsText\" was not injected: check your FXML file 'CourseDBAddView.fxml'.";

       labLengthText.setEditable(hasLabBox.isSelected());
       labProxCombo.getItems().addAll(Course.LabProximity.values());
    }
    
    /* From http://stackoverflow.com/questions/14206768/how-to-check-if-a-string-is-numeric */
    public boolean isNumeric(String s) {  
        return s.matches("[-+]?\\d*\\.?\\d+");  
    }

}
