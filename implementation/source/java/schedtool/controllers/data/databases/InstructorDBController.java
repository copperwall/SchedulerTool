package controllers.data.databases;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import models.data.databases.*;

public class InstructorDBController implements Observer{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deleteButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button editButton;

    @FXML
    private TableView<Instructor> instructorTable;

    @FXML
    private Button addButton;

    @FXML
    private Button saveButton;
    
    private List<Instructor> workingInstructorSet;
    
    private InstructorDB instructorDB;
    
    @FXML
    void addInstructor(ActionEvent event) {
        try {
        	URL location = getClass().getResource("../../../views/data/databases/InstructorDBAddView.fxml");
        	FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = (Parent) fxmlLoader.load(location.openStream());
          
            InstructorDBAddController controller = (InstructorDBAddController)(fxmlLoader.getController());
            controller.passTable(instructorTable, instructorDB);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException exc) {
        }
    }

    @FXML
    void editInstructor(ActionEvent event) {
        try {
            URL location = getClass().getResource("../../../views/data/databases/InstructorDBEditView.fxml");
        	FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = (Parent) fxmlLoader.load(location.openStream());
          
            InstructorDBEditController controller = (InstructorDBEditController) (fxmlLoader.getController());
            controller.passInstructor(instructorTable.getSelectionModel().getSelectedItem());
            controller.passTable(instructorTable, instructorDB);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    void deleteInstructor(ActionEvent event) {
        Instructor selected = instructorTable.getSelectionModel().getSelectedItem();
        
        instructorDB.deleteInstructor(selected);
    }

    @FXML
    void cancelChanges(ActionEvent event) {
        
    }
    
    @FXML
    void save(ActionEvent event) {
        // save to file
        instructorDB.save();
    }

    @FXML
    void initialize() {
        assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'InstructorDB.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'InstructorDB.fxml'.";
        assert editButton != null : "fx:id=\"editButton\" was not injected: check your FXML file 'InstructorDB.fxml'.";
        assert instructorTable != null : "fx:id=\"instructorTable\" was not injected: check your FXML file 'InstructorDB.fxml'.";
        assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'InstructorDB.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'InstructorDB.fxml'.";

        instructorDB = new InstructorDB();
        instructorDB.addObserver(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		ObservableList<Instructor> items = instructorTable.getItems();
		instructorTable.setItems(null);
		items.clear();
		items.addAll(instructorDB.getAllInstructors());
		instructorTable.setItems(items);
		System.out.println("updated");
	}
}
