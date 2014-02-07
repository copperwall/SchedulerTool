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
      labProxCombo.setEditable(hasLabBox.isSelected());
    }

   @FXML
   void submit(ActionEvent event) {
      boolean invalidInput = false;
   
      if (prefixText.getText().length <= 0) {
         invalidInput = true;
         JOptionPane.showMessageDialog(null,"Invalid prefix entry.");
      }
      else if (courseNoText.getText().length <= 0 || Integer.valueof(courseNoText.getText()) {
         invalidInput = true;
         JOptionPane.showMessageDialog(null,"Invalid course number.");
      }

      if (!invalidInput) {
         if (hasLabBox.isSelected()) {
            model.addCourse(prefixText.getText(), Integer.valueof(courseNoText.getText()), hasLabBox.isSelected(), Integer.valueof(unitsText.getText()), titleText.getText(), Integer.valueof(labLength.getText()), labProx.getValue());
         }
         else {
            model.addCourse(prefixText.getText(), Intger.valueof(courseNoText.getText()), hasLabBox.isSelected(), Intger.valueof(unitsText.getText()), titleText.getText(), null, null);
         }
         cancel(event);
      }
   }
    
    void setModel(CourseDB mod) {
      model = mod;
    }

    @FXML
    void initialize() {
        assert courseNoText != null : "fx:id=\"courseNoText\" was not injected: check your FXML file 'CourseDBAdd.fxml'.";
        assert hasLabBox != null : "fx:id=\"hasLabBox\" was not injected: check your FXML file 'CourseDBAdd.fxml'.";
        assert labLengthText != null : "fx:id=\"labLengthText\" was not injected: check your FXML file 'CourseDBAdd.fxml'.";
        assert labProximityText != null : "fx:id=\"labProximityText\" was not injected: check your FXML file 'CourseDBAdd.fxml'.";
        assert prefixText != null : "fx:id=\"prefixText\" was not injected: check your FXML file 'CourseDBAdd.fxml'.";
        assert titleText != null : "fx:id=\"titleText\" was not injected: check your FXML file 'CourseDBAdd.fxml'.";
        assert unitsText != null : "fx:id=\"unitsText\" was not injected: check your FXML file 'CourseDBAdd.fxml'.";

       labLengthText.setEditable(hasLabBox.isSelected());
       labProxCombo.setEditable(hasLabBox.isSelected());
       labProxCombo.setItems(Course.LabProximity.values());
    }

}
