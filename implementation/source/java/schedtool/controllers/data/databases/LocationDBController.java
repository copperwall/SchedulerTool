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

public class LocationDBController {
    LocationDB model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Location> locationTable;

    @FXML
    void addLocation(ActionEvent event) {
        try {
           URL location = getClass().getResource("/views/data/databases/LocationDBAddView.fxml");
           FXMLLoader loader = new FXMLLoader();
           Parent root = FXMLLoader.load(location.openStream());

           LocationDBAddController controller = (LocationDBAddController)(loader.getController());

           controller.setModel(model);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    void deleteLocation(ActionEvent event) {
       Location selected = locationTable.getSelectionModel().getSelectedItem();

       model.deleteLocation(selected);
    }

    @FXML
    void editLocation(ActionEvent event) {
       Location selected = locationTable.getSelectionModel().getSelectedItem();

       if (selected != null) {
           try {
              URL location = getClass().getResource("/views/data/databases/LocationDBAddView.fxml");
              FXMLLoader loader = new FXMLLoader();
              Parent root = FXMLLoader.load(location.openStream());

              LocationDBEditController controller = (LocationDBEditController)(loader.getController());
              controller.setModel(model);
              controller.setLocation(selected);

               Scene scene = new Scene(root);
               Stage stage = new Stage();
               
               stage.setScene(scene);
               stage.show();
           } catch (IOException exc) {
               exc.printStackTrace();
           }
      }
    }

    @FXML
    void initialize() {
        System.out.println("LocationDBController initialized.");
        
        model = new LocationDB();
        model.addObserver(this);
    }

    public void update(Observable o, Object arg) {
       ObservableList<Location> items = locationTable.getItems();
       item.setAll(model.getAllLocations());
       locationTable.setItems(items);
       System.out.println("LocationDB Updated");
    }
}
