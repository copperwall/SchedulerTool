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
 * FXML Controller class
 *
 * @author Calvin
 */
public class InstructorDBAddController implements Initializable {

    
    @FXML
    private URL location;

    @FXML
    private CheckBox active;

    @FXML
    private TextField userID;

    @FXML
    private TextField wtu;
    
    private TableView<Instructor> table;
    
    private InstructorDB instructorDB;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void submit(ActionEvent event) {
        instructorDB.addInstructor(new Instructor("Placeholder Name", userID.getText(), Integer.parseInt(wtu.getText()), active.isSelected()));
        Button src = (Button)event.getSource();
        Stage srcStage = (Stage)src.getScene().getWindow();
        
        srcStage.close();
    }

    @FXML
    private void cancel(ActionEvent event) {
        Button src = (Button)event.getSource();
        Stage srcStage = (Stage)src.getScene().getWindow();
        
        srcStage.close();
    }
    
    public void passTable(TableView<Instructor> table, InstructorDB instructorDB) {
    	this.table = table;
    	this.instructorDB = instructorDB;
    }
}
