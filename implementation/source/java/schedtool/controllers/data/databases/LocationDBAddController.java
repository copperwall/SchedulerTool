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

/* Models */
import models.data.databases.LocationDB;
import models.data.databases.Location;

/**
 * Controller for the add dialog for LocationDB
 *
 * @author Jarred Stelfox
 */


public class LocationDBAddController {
    private LocationDB model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField buildingText;

    @FXML
    private TextField capacityText;

    @FXML
    private TextField equipmentText;

    @FXML
    private TextField roomText;


    @FXML
    void cancel(ActionEvent event) {
       Button src = (Button)event.getSource();
       Stage srcStage = (Stage)src.getScene().getWindow();

       srcStage.close();
    }

    @FXML
    void submit(ActionEvent event) {
       boolean isInvalid = false;

       if (buildingText.getText().length() < 2) {
          isInvalid = true;
       }
       else if (roomText.getText().length() < 2) {
          isInvalid = true;
       }

       if (!isInvalid) {
         model.addLocation(buildingText.getText(), roomText.getText(), capacityText.getText(), equipmentText.getText());
       }
       else {

       }
       cancel(event);
    }

    void setModel(LocationDB model) {
       this.model = model;
    }

    @FXML
    void initialize() {
        assert buildingText != null : "fx:id=\"buildingText\" was not injected: check your FXML file 'LocationDBAddView.fxml'.";
        assert capacityText != null : "fx:id=\"capacityText\" was not injected: check your FXML file 'LocationDBAddView.fxml'.";
        assert equipmentText != null : "fx:id=\"equipmentText\" was not injected: check your FXML file 'LocationDBAddView.fxml'.";
        assert roomText != null : "fx:id=\"roomText\" was not injected: check your FXML file 'LocationDBAddView.fxml'.";


    }

}
