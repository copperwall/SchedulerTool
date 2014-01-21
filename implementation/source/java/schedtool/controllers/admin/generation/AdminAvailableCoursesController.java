package controllers.admin.generation;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/* Import Models */
import models.admin.generation.*;


public class AdminAvailableCoursesController {
    private AdminAvailableCoursesModel model = new AdminAvailableCoursesModel();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void cancelChanges(ActionEvent event) {
    }

    @FXML
    void loadFromTerm(ActionEvent event) {
        this.model.loadFromTerm("Test Term");
    }

    @FXML
    void loadSuggested(ActionEvent event) {
        this.model.loadSuggested();
    }

    @FXML
    void saveChanges(ActionEvent event) {
        this.model.saveSections();
    }

    @FXML
    void initialize() {
        System.out.println("AdminAvailableCoursesController initialized.");
    }

}
