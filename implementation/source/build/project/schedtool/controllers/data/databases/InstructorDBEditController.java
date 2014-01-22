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
 * FXML Controller class
 *
 * @author Calvin
 */
public class InstructorDBEditController implements Initializable {

     @FXML
    private CheckBox active;

    @FXML
    private TextField wtu;
    
    private InstructorDB instructorDB;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instructorDB = new InstructorDB();
    }    

    @FXML
    private void edit(ActionEvent event) {
        instructorDB.editInstructor(new Instructor());
    }

    @FXML
    private void cancel(ActionEvent event) {
        Button src = (Button)event.getSource();
        Stage srcStage = (Stage)src.getScene().getWindow();
        
        srcStage.close();
    }
    
}
