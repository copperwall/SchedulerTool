package controllers.admin.generation;

import java.net.URL;
import java.util.ResourceBundle;

import models.admin.generation.AdminPublish;
import scheduler_tool.AdminFrameController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class AdminPublishController {
	private AdminPublish model = new AdminPublish();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Button cancelButton;

    @FXML
    private Button publishButton;


    @FXML
    void cancel(ActionEvent event) {
    	this.model.cancel();
    	AdminFrameController.reloadMainTable();
    }

    @FXML
    void publish(ActionEvent event) {
    	this.model.publish();
    }

    @FXML
    void initialize() {
        assert AnchorPane != null : "fx:id=\"AnchorPane\" was not injected: check your FXML file 'AdminPublish.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'AdminPublish.fxml'.";
        assert publishButton != null : "fx:id=\"publishButton\" was not injected: check your FXML file 'AdminPublish.fxml'.";


    }

}
