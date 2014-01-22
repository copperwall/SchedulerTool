package controllers.admin.generation;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
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
   void onLockChanged(ActionEvent event) {
      new InstructorDB().editInstructor(null);
   }

}