package controllers.data.databases;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.fxml.JavaFXBuilderFactory;
/* Import Models */
import models.data.databases.LocationDB;
import models.data.databases.Location;

/**
 * Controller for LocationDB
 *
 * @author Chris Opperwall
 */

public class LocationDBController implements Observer {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Location> locationTable;

    private LocationDB locationDB;

    @FXML
    void addLocation(ActionEvent event) {
        try {
           URL location = getClass().getResource("/views/data/databases/LocationDBAddView.fxml");
           FXMLLoader loader = new FXMLLoader();
           Parent root = (Parent)loader.load(location.openStream());

           LocationDBAddController controller = (LocationDBAddController)(loader.getController());

            controller.passTable(locationTable, locationDB);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void editLocation(ActionEvent event) {
        try {
           URL location = getClass().getResource("/views/data/databases/LocationDBEditView.fxml");
           FXMLLoader loader = new FXMLLoader();
           Parent root = (Parent) loader.load(location.openStream());

           LocationDBEditController controller = (LocationDBEditController)(loader.getController());

           controller.passLocation(locationTable.getSelectionModel().getSelectedItem());
           controller.passTable(locationTable, locationDB);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void deleteLocation(ActionEvent event) {
         Location selected = locationTable.getSelectionModel().getSelectedItem();

         locationDB.deleteLocation(selected);
    }

    @FXML
    void cancelChanges(ActionEvent event) {
         scheduler_tool.AdminFrameController.reloadMainTable();
    }

    @FXML
    void save(ActionEvent event) {}

    @FXML
    void initialize() {
        System.out.println("LocationDBController initialized.");
        
        locationDB = new LocationDB();
        locationDB.addObserver(this);
        update(null, null);
    }

    @Override
    public void update(Observable o, Object arg) {
       ObservableList<Location> items = locationTable.getItems();
       items.setAll(locationDB.getAllLocations());
       locationTable.setItems(items);
       System.out.println("LocationDB Updated");
    }
}
