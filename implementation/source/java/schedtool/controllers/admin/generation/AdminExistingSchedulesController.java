package controllers.admin.generation;

import java.net.URL;
import java.util.ResourceBundle;

import scheduler_tool.AdminFrameController;
import models.admin.generation.AdminExistingSchedules;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class AdminExistingSchedulesController {
	private AdminExistingSchedules model = new AdminExistingSchedules();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Button cancelButton;

    @FXML
    private Button loadButton;


    @FXML
    void cancel(ActionEvent event) {
    	this.model.cancel();
    	AdminFrameController.reloadMainTable();
    }

    @FXML
    void load(ActionEvent event) {
    	this.model.load();
    }

    @FXML
    void initialize() {
        assert AnchorPane != null : "fx:id=\"AnchorPane\" was not injected: check your FXML file 'AdminExistingSchedules.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'AdminExistingSchedules.fxml'.";
        assert loadButton != null : "fx:id=\"loadButton\" was not injected: check your FXML file 'AdminExistingSchedules.fxml'.";


    }

}
