package controllers.data.databases;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller for edit dialog for LocationDB
 *
 * @author Chris Opperwall
 */


public class LocationDBAddController {

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
    	// TODO Close view
    }

    @FXML
    void submit(ActionEvent event) {
    	// TODO Adds new row to grid view
    }

    @FXML
    void initialize() {
        assert buildingText != null : "fx:id=\"buildingText\" was not injected: check your FXML file 'LocationDBEditView.fxml'.";
        assert capacityText != null : "fx:id=\"capacityText\" was not injected: check your FXML file 'LocationDBEditView.fxml'.";
        assert equipmentText != null : "fx:id=\"equipmentText\" was not injected: check your FXML file 'LocationDBEditView.fxml'.";
        assert roomText != null : "fx:id=\"roomText\" was not injected: check your FXML file 'LocationDBEditView.fxml'.";

        // Should fill up fields with selected data. Future work perhaps


}
