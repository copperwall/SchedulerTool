package controllers.admin.generation;

/**
 *
 * @author Chase Kragenbrink
 */
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import models.admin.generation.AdminGeneralSettings;
import models.admin.generation.Constraint;
import models.admin.generation.TimePrefRow;
import models.data.databases.Instructor;
import models.data.databases.InstructorDB;

public class GeneralSettingsController implements Observer {

   @FXML
   private CheckBox mwPattern;

   @FXML
   private Slider startTimeSlider;

   @FXML
   private Slider endTimeSlider;

   @FXML
   private CheckBox mwfPattern;

   @FXML
   private TextField constraintText;

   @FXML
   private CheckBox thPattern;

   @FXML
   private TableView<TimePrefRow> blockedOutTimesTable;

   @FXML
   private Button addConstraintBtn;

   @FXML
   private CheckBox wfPattern;

   @FXML
   private CheckBox mtwhPattern;

   @FXML
   private CheckBox mtwfPattern;

   @FXML
   private TableView<Constraint> constraintTable;

   @FXML
   private CheckBox mfPattern;

   AdminGeneralSettings generalSettings;
   
   @FXML
   void initialize() {
      System.out.println("Initializing GenSettingsController");
      generalSettings = new AdminGeneralSettings();
      generalSettings.addObserver(this);
      generalSettings.initTimePrefsTable();
  }

   @FXML
   void onEndTimeDone(ActionEvent event) {
      generalSettings.setEndTime(0);
   }

   @FXML
   void onStartTimeDone(ActionEvent event) {
      generalSettings.setEndTime(0);
   }

   @FXML
   void onAddConstraintBtnEvent(ActionEvent event) {
      System.out.println("text " + constraintText.getText());
      generalSettings.addConstraint(constraintText.getText());
   }

   @FXML
   void onMwfEvent(ActionEvent event) {
      generalSettings.updateTimePattern(AdminGeneralSettings.TIME_PATTERN.MWF,
         mwfPattern.isSelected());
   }

   @FXML
   void onThEvent(ActionEvent event) {
      generalSettings.updateTimePattern(AdminGeneralSettings.TIME_PATTERN.TH,
         thPattern.isSelected());
   }

   @FXML
   void onMwEvent(ActionEvent event) {
      generalSettings.updateTimePattern(AdminGeneralSettings.TIME_PATTERN.MW,
         mwPattern.isSelected());
   }

   @FXML
   void onWfEvent(ActionEvent event) {
      generalSettings.updateTimePattern(AdminGeneralSettings.TIME_PATTERN.WF,
         wfPattern.isSelected());
   }

   @FXML
   void onMfEvent(ActionEvent event) {
      generalSettings.updateTimePattern(AdminGeneralSettings.TIME_PATTERN.MF,
         mfPattern.isSelected());
   }

   @FXML
   void onMtwhEvent(ActionEvent event) {
      generalSettings.updateTimePattern(AdminGeneralSettings.TIME_PATTERN.MTWH,
         mtwhPattern.isSelected());
   }

   @FXML
   void onMtwfEvent(ActionEvent event) {
      generalSettings.updateTimePattern(AdminGeneralSettings.TIME_PATTERN.MTWF,
         mtwfPattern.isSelected());
   }

   @Override
   public void update(Observable observable, Object data) {
      ArrayList<Constraint> constraints = generalSettings.getConstraints();
      ObservableList<Constraint> items = constraintTable.getItems();
      constraintTable.setItems(null);
      items.clear();
      items.addAll(constraints);
      constraintTable.setItems(items);
      
      TimePrefRow[] blockTimes = generalSettings.getBlockedOutTimes();
      ObservableList<TimePrefRow> blockTimeItems = blockedOutTimesTable.getItems();
      blockedOutTimesTable.setItems(null);
      blockTimeItems.clear();
      blockTimeItems.addAll(blockTimes);
      blockedOutTimesTable.setItems(blockTimeItems);
      
      System.out.println("in GeneralSettings.update");
      System.out.print(generalSettings.toString());
   }

}
