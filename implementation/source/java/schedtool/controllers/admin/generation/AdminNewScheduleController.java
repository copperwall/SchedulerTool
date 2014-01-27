package controllers.admin.generation;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/* Import Models */
import models.admin.generation.*;
import scheduler_tool.AdminFrameController;


public class AdminNewScheduleController {
	private AdminNewSchedule model = new AdminNewSchedule();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button createButton;

    @FXML
    private Button cancelButton;

    @FXML
    void createNewSchedule(ActionEvent event) {
    	this.model.createNewSchedule();
    }
    
    @FXML
    void cancel(ActionEvent event) {
    	this.model.cancel();
    	AdminFrameController.reloadMainTable();
    }

    @FXML
    void initialize() {
    	assert createButton != null : "fx:id=\"createButton\" was not injected: check your FXML file 'AdminNewSchedule.fxml'.";

    }

}
