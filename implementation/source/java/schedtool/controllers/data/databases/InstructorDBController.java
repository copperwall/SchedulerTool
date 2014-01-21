package controllers.data.databases;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import models.data.databases.*;

public class InstructorDBController {

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
            Parent root = FXMLLoader.load(getClass().getResource("InstructorDBAdd.fxml"));

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
            Parent root = FXMLLoader.load(getClass().getResource("InstructorDBEdit.fxml"));

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
    }
}
