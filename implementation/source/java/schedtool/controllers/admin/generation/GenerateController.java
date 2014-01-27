package controllers.admin.generation;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
/* Import Models */
import models.admin.generation.*;
import javafx.scene.layout.AnchorPane;

public class GenerateController {
	private static AdminGenerating model = new AdminGenerating();
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane;
    
    @FXML
    public static void generate() {
        model.generate();
    }


    @FXML
    void initialize() {
        assert AnchorPane != null : "fx:id=\"AnchorPane\" was not injected: check your FXML file 'AdminGenerating.fxml'.";

    }
}
