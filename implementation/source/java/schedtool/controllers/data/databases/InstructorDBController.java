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

/**
 * Controller for the panel containing the instructor database.
 * @author Calvin Elizan (celizan)
 *
 */
public class InstructorDBController implements Observer{

    /** resource bundle **/
	@FXML
    private ResourceBundle resources;

	/** location of resources **/
    @FXML
    private URL location;

    /** delete button on GUI **/
    @FXML
    private Button deleteButton;

    /** cancel button on GUI **/
    @FXML
    private Button cancelButton;

    /** edit button on GUI **/
    @FXML
    private Button editButton;

    /** instructor DB table on GUI **/
    @FXML
    private TableView<Instructor> instructorTable;

    /** add button on GUI **/
    @FXML
    private Button addButton;

    /** save button on GUI **/
    @FXML
    private Button saveButton;
    
    /** instructorDB that the table runs on **/
    private InstructorDB instructorDB;
    
    /** Run when add button is clicked to open add dialog **/
    @FXML
    void addInstructor(ActionEvent event) {
        try {
        	/* open FXML */
        	URL location = getClass().getResource("/views/data/databases/InstructorDBAddView.fxml");
        	FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = (Parent) fxmlLoader.load(location.openStream());
            
            /* Pass table and instructorDB to add controller */
            InstructorDBAddController controller = (InstructorDBAddController)(fxmlLoader.getController());
            controller.passTable(instructorTable, instructorDB);
            
            /* Create new window for add dialog */
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException exc) {
        }
    }

    /** run when edit button is clicked to open edit dialog **/
    @FXML
    void editInstructor(ActionEvent event) {
        try {
        	/* load FXML */
            URL location = getClass().getResource("/views/data/databases/InstructorDBEditView.fxml");
        	FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = (Parent) fxmlLoader.load(location.openStream());
          
            /* Pass instructorDB and table to controller */
            InstructorDBEditController controller = (InstructorDBEditController) (fxmlLoader.getController());
            if (instructorTable.getSelectionModel().getSelectedItem() != null) {
                controller.passInstructor(instructorTable.getSelectionModel().getSelectedItem());
                controller.passTable(instructorTable, instructorDB);
                
                /* create new window for dialog */
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        } 
    }

    /**
     * Deletes the instructor from the database. Run when the delete button is clicked.
     * @param event the button action event
     */
    @FXML
    void deleteInstructor(ActionEvent event) {
        Instructor selected = instructorTable.getSelectionModel().getSelectedItem();
        if (instructorTable.getSelectionModel().getSelectedItem() != null) {
            instructorDB.deleteInstructor(selected);
        }
    }

    /**
     * Cancel the changes to the database (probably going to be removed)
     * @param event the button action event from the cancel button
     */
    @FXML
    void cancelChanges(ActionEvent event) {
    	scheduler_tool.AdminFrameController.reloadMainTable();
    }
    
    /**
     * Save the changes to the database (probably going to be removed)
     * @param event the button action event from the save button
     */
    @FXML
    void save(ActionEvent event) {
    }

    /**
     * Called when the controller is created.
     */
    @FXML
    void initialize() {
    	/* Make sure all the GUI parts are there */
        assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'InstructorDB.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'InstructorDB.fxml'.";
        assert editButton != null : "fx:id=\"editButton\" was not injected: check your FXML file 'InstructorDB.fxml'.";
        assert instructorTable != null : "fx:id=\"instructorTable\" was not injected: check your FXML file 'InstructorDB.fxml'.";
        assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'InstructorDB.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'InstructorDB.fxml'.";

        /* Create a new instructorDB for the table */
        instructorDB = new InstructorDB();
        instructorDB.addObserver(this);
        update(null, null);
    }

    /**
     * Called whenever the InstructorDB gets updated
     */
	@Override
	public void update(Observable o, Object arg) {
		/* the list of items in the table */
		ObservableList<Instructor> items = instructorTable.getItems();
		
		/* update items */
		items.setAll(instructorDB.getAllInstructors());
		instructorTable.setItems(items);
		
		System.out.println("updated");
	}
}
