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
import models.data.databases.LocationDB;
import models.data.databases.Location;

/**
 * Controller for edit dialog for LocationDB
 *
 * @author Chris Opperwall
 */


public class LocationDBEditController {
   private LocationDB model;

   private Location location;

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
    	// TODO Adds new row to grid view
    }

    void setModel(LocationDB model) {
       this.model = model;
    }

    void setLocation(Location location) {
         this.location = location;
         // TODO Finish
         
    }

    @FXML
    void initialize() {
        assert buildingText != null : "fx:id=\"buildingText\" was not injected: check your FXML file 'LocationDBEditView.fxml'.";
        assert capacityText != null : "fx:id=\"capacityText\" was not injected: check your FXML file 'LocationDBEditView.fxml'.";
        assert equipmentText != null : "fx:id=\"equipmentText\" was not injected: check your FXML file 'LocationDBEditView.fxml'.";
        assert roomText != null : "fx:id=\"roomText\" was not injected: check your FXML file 'LocationDBEditView.fxml'.";

        // Should fill up fields with selected data. Future work perhaps
         //TODO Finish stuff

   }
}
