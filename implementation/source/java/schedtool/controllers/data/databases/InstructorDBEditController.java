package controllers.data.databases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.data.databases.Instructor;
import models.data.databases.InstructorDB;

/**
 * FXML Controller class for the edit dialog
 *
 * @author Calvin Elizan (celizan)
 */
public class InstructorDBEditController implements Initializable {

	/** The Active checkbox on the GUI */
     @FXML
    private CheckBox active;

     /** The work time units text field on the GUI */
    @FXML
    private TextField wtu;

    /** The User ID text field on the GUI */
    @FXML
    private TextField userID;
    
    /** Reference to the instructor database */
    private InstructorDB instructorDB;
    /** Reference to the instructor that is being edited */
    private Instructor instructor;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    /**
     * Make the changes in the dialog
     * @param event button action for the Edit button
     */
    @FXML
    private void edit(ActionEvent event) {
    	/* Creates a new instructor with the properties we need */
        instructorDB.editInstructor(new Instructor("Placeholder Name", 
        			userID.getText(), Integer.parseInt(wtu.getText()), active.isSelected()));
        /* Close the dialog */
        Button src = (Button)event.getSource();
        Stage srcStage = (Stage)src.getScene().getWindow();
        
        srcStage.close();
    }

    /**
     * Closes the dialog
     * @param event button action for the cancel button
     */
    @FXML
    private void cancel(ActionEvent event) {
    	/* close the dialog */
        Button src = (Button)event.getSource();
        Stage srcStage = (Stage)src.getScene().getWindow();
        
        srcStage.close();
    }
    
    /**
     * Set the text fields to default with the instructor's current values and
     * save the old instructor.
     * @param target
     */
    public void passInstructor(Instructor target) {
    	instructor = target;
    	
    	active.setSelected(instructor.getAct());
    	wtu.setText("" + instructor.getWtu());
    	userID.setEditable(true);
    	userID.setText("" + instructor.getUser());
    	userID.setEditable(false);
    }
    
    /**
     * Pass the references this dialog needs.
     * @param table the instructordb table
     * @param instructorDB the current instructorDB
     */
    public void passTable(TableView<Instructor> table, InstructorDB instructorDB) {
    	this.instructorDB = instructorDB;
    }
}
