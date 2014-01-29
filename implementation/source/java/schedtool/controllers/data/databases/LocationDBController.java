package controllers.data.databases;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/* Import Models */
import models.data.databases.LocationDB;

/**
 * Controller for LocationDB
 *
 * @author Chris Opperwall
 */

public class LocationDBController {
    LocationDB model = new LocationDB();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void addLocation(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../../../views/data/databases/LocationDBAddView.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    void cancelChanges(ActionEvent event) {
    }

    @FXML
    void deleteLocation(ActionEvent event) {
    }

    @FXML
    void editLocation(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../../../views/data/databases/LocationDBEditView.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    void saveChanges(ActionEvent event) {
        this.model.save_changes();
    }

    @FXML
    void initialize() {
        System.out.println("LocationDBController initialized.");
    }

}
