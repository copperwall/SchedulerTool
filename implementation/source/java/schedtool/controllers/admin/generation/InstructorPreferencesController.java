package controllers.admin.generation;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import models.data.databases.*;

/**
 * @author Chase Kragenbrink
 */
public class InstructorPreferencesController {

   @FXML
   private TableView<?> instructorListTable;

   @FXML
   private CheckBox lockInstructorPrefsCheckbox;

   @FXML
   private GridPane timePreferencesTable;
   
   @FXML
   void initialize() {
      ObservableList<Node> children = timePreferencesTable.getChildren();
      for (final Node n : children) {
         if (n instanceof Label)
            continue;
         n.setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
               
               if (n.getStyle().equals("-fx-background-color: green;"))
                  n.setStyle("-fx-background-color: white;");
               else
                  n.setStyle("-fx-background-color: green;");
            }
            
         });
         
      }
      
   }

   @FXML
   void onLockChanged(ActionEvent event) {
      new InstructorDB().editInstructor(null);
   }

}