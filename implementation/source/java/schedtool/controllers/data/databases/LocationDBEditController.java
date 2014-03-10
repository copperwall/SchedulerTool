package controllers.data.databases;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

/* Import Models */
import models.data.databases.LocationDB;
import models.data.databases.Location;

/**
 * Controller for edit dialog for LocationDB
 *
 * @author Chris Opperwall
 */


public class LocationDBEditController implements Initializable {

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

    private Location location;

    void edit(ActionEvent event) {
       Location generated = genLocation();

       locationDB.editLocation(location, generated);

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

    @FXML
    void submit(ActionEvent event) {
    	// TODO Adds new row to grid view
    }

    public void passLocation(Location target) {
       location = target;

       buildingText.setText(location.getBuilding());
       buildingNumberText.setText(location.getBuildingNumber());
       roomText.setText(location.getRoom());
       capacityText.setText(location.getCapacity());
       equipmentText.setText(location.getEquipment() ? "yes" : "no");

    }

    public void passTable(TableView<Location> table, LocationDB locationDB) {
       this.locationDB = locationDB;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

   private Location genLocation() {
      return new Location(buildingText.getText(), buildingNumberText.getText(),
       roomText.getText(), Integer.parseInt(capacityText.getText()),
       equipmentText.getText().equals("yes"));
   }

}
