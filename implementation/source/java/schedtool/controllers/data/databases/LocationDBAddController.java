package controllers.data.databases;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

/* Models */
import models.data.databases.LocationDB;
import models.data.databases.Location;

/**
 * Controller for the add dialog for LocationDB
 *
 * @author Jarred Stelfox and Chris Opperwall
 */


public class LocationDBAddController implements Initializable {
    @FXML
    private URL location;

    @FXML
    private TextField buildingText;

    @FXML
    private TextField buildingNumberText;

    @FXML
    private TextField capacityText;

    @FXML
    private TextField equipmentText;

    @FXML
    private TextField roomText;

    private LocationDB locationDB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    void submit(ActionEvent event) {
       locationDB.addLocation(buildingText.getText(), buildingNumberText.getText(),
        roomText.getText(), capacityText.getText(),
        equipmentText.getText().equals("yes"));

       Button src = (Button)event.getSource();
       Stage srcStage = (Stage)src.getScene().getWindow();

       srcStage.close();
    }

    @FXML
    void cancel(ActionEvent event) {
       Button src = (Button)event.getSource();
       Stage srcStage = (Stage)src.getScene().getWindow();

       srcStage.close();
    }

    public void passTable(TableView<Location> table, LocationDB locationDB) {
         this.locationDB = locationDB;
    }
}
