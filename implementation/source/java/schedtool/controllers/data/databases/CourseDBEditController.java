package controllers.data.databases;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class CourseDBEditController {

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
    private TextField labProximityText;

    @FXML
    private TextField prefixText;

    @FXML
    private TextField titleText;

    @FXML
    private TextField unitsText;


    @FXML
    void cancel(ActionEvent event) {
    }

    @FXML
    void onHasLab(ActionEvent event) {
      labLengthText.setEditable(hasLabBox.isSelected());
      labProximityText.setEditable(hasLabBox.isSelected());
    }

    @FXML
    void submit(ActionEvent event) {
       model.editCourse(null);
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

        //FILL IN DATA HERE!
        
       labLengthText.setEditable(hasLabBox.isSelected());
       labProximityText.setEditable(hasLabBox.isSelected());
    }

}
