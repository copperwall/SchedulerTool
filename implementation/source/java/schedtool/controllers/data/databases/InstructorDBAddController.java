package controllers.data.databases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.data.databases.Instructor;
import models.data.databases.InstructorDB;

/**
 * FXML Controller class for the Add Instructor GUI.
 *
 * @author Calvin Elizan (celizan)
 */
public class InstructorDBAddController implements Initializable {

    /** location of resources */
    @FXML
    private URL location;
    
    /** first name field on GUI */
    @FXML
    private TextField firstName;

    /** last name field on GUI */
    @FXML
    private TextField lastName;

    /** active checkbox on GUI */
    @FXML
    private CheckBox active;

    /** user ID text field on GUI */
    @FXML
    private TextField userID;

    /** WTU text field on GUI */
    @FXML
    private TextField wtu;
    
    /** WTU error field on GUI */
    @FXML
    private Label lblWtuError;
    
    /** current InstructorDB reference */
    private InstructorDB instructorDB;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    /**
     * Adds the instructor described by the user in the dialog.
     * @param event the add button action
     */
    @FXML
    private void submit(ActionEvent event) {
        // work time units
        int wtuInt;
        
        try
        {
            wtuInt = Integer.parseInt(wtu.getText());

            /* create a new instructor to add to the database */
            instructorDB.addInstructor(new Instructor(firstName.getText(), lastName.getText(), userID.getText(), Integer.parseInt(wtu.getText()), active.isSelected()));
            /* close the window */
            Button src = (Button)event.getSource();
            Stage srcStage = (Stage)src.getScene().getWindow();
            srcStage.close();
        }
        catch (NumberFormatException exc)
        {
            lblWtuError.setText("Invalid work time units value.");
        }
    }

    /**
     * Close the dialog.
     * @param event the cancel button action
     */
    @FXML
    private void cancel(ActionEvent event) {
    	/* close the dialog */
        Button src = (Button)event.getSource();
        Stage srcStage = (Stage)src.getScene().getWindow();
        
        srcStage.close();
    }
    
    /**
     * Saves the necessary information for this dialog.
     * @param table the TableView of instructors.
     * @param instructorDB the instructor database
     */
    public void passTable(TableView<Instructor> table, InstructorDB instructorDB) {
    	this.instructorDB = instructorDB;
    }
}
