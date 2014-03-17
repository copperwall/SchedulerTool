package controllers.admin.generation;

/**
 *
 * @author Chase Kragenbrink
 */
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import models.admin.generation.AdminGeneralSettings;
import models.admin.generation.Constraint;
import models.admin.generation.Constraint.InvalidConstraintText;
import models.admin.generation.Range.RangeOutOfBoundsException;
import models.admin.generation.Range.StartAfterEndException;
import models.admin.generation.TimePrefRow;

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
   private GridPane blockedOutTimesTable;

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

   /**
    * JavaFX will call this when this controller needs to be initialized
    */
   @FXML
   void initialize() {
      generalSettings = new AdminGeneralSettings();
      generalSettings.addObserver(this);
      
      ObservableList<Node> children = blockedOutTimesTable.getChildren();
      for (final Node n : children) {
         if (n instanceof Label)
            continue;
         n.setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
               
               if (n.getStyle().equals("-fx-background-color: red;"))
                  n.setStyle("-fx-background-color: white;");
               else
                  n.setStyle("-fx-background-color: red;");
            }
            
         });
         
      }

      // Set ChangeListener for the endTimeSlider
      endTimeSlider.valueProperty().addListener(new ChangeListener<Number>() {
         @Override
         public void changed(ObservableValue<? extends Number> observable, Number oldValue,
            Number newValue) {
            if (newValue.doubleValue() - newValue.intValue() == 0)
               generalSettings.setEndTime(newValue.intValue());
         }
      });

      // Set ChangeListener for the startTimeSlider
      startTimeSlider.valueProperty().addListener(new ChangeListener<Number>() {
         @Override
         public void changed(ObservableValue<? extends Number> observable, Number oldValue,
            Number newValue) {
            if (newValue.doubleValue() - newValue.intValue() == 0)
               generalSettings.setStartTime(newValue.intValue());
         }
      });

      endTimeSlider.setValue(10);
   }

   /**
    * When Add Constraint button is clicked
    * @param event 
    * @throws StartAfterEndException 
    * @throws RangeOutOfBoundsException 
    */
   @FXML
   void onAddConstraintBtnEvent(ActionEvent event) throws RangeOutOfBoundsException, StartAfterEndException {
      try {
         generalSettings.addConstraint(constraintText.getText());
      }
      catch (InvalidConstraintText e) {
         e.printStackTrace();
      }
   }

   /**
    * When MWF checkbox is checked or unchecked
    * @param event
    */
   @FXML
   void onMwfEvent(ActionEvent event) {
      generalSettings.updateTimePattern(AdminGeneralSettings.TIME_PATTERN.MWF,
         mwfPattern.isSelected());
   }

   /**
    * When TH checkbox is checked or unchecked
    * @param event
    */
   @FXML
   void onThEvent(ActionEvent event) {
      generalSettings.updateTimePattern(AdminGeneralSettings.TIME_PATTERN.TH,
         thPattern.isSelected());
   }

   /**
    * When MW checkbox is checked or unchecked
    * @param event
    */
   @FXML
   void onMwEvent(ActionEvent event) {
      generalSettings.updateTimePattern(AdminGeneralSettings.TIME_PATTERN.MW,
         mwPattern.isSelected());
   }

   /**
    * When WF checkbox is checked or unchecked
    * @param event
    */
   @FXML
   void onWfEvent(ActionEvent event) {
      generalSettings.updateTimePattern(AdminGeneralSettings.TIME_PATTERN.WF,
         wfPattern.isSelected());
   }

   /**
    * When MF checkbox is checked or unchecked
    * @param event
    */
   @FXML
   void onMfEvent(ActionEvent event) {
      generalSettings.updateTimePattern(AdminGeneralSettings.TIME_PATTERN.MF,
         mfPattern.isSelected());
   }

   /**
    * When MTWH checkbox is checked or unchecked
    * @param event
    */
   @FXML
   void onMtwhEvent(ActionEvent event) {
      generalSettings.updateTimePattern(AdminGeneralSettings.TIME_PATTERN.MTWH,
         mtwhPattern.isSelected());
   }

   /**
    * When MTWF checkbox is checked or unchecked
    * @param event
    */
   @FXML
   void onMtwfEvent(ActionEvent event) {
      generalSettings.updateTimePattern(AdminGeneralSettings.TIME_PATTERN.MTWF,
         mtwfPattern.isSelected());
   }

   /**
    * Gets called when the observable calls notifyObservers(). This updates the table view of constraints
    * and the table view of time preferences (even though time preferences don't change more than once
    * yet). Does a dump of all the settings.
    */
   @Override
   public void update(Observable observable, Object data) {
      ArrayList<Constraint> constraints = generalSettings.getConstraints();
      ObservableList<Constraint> items = constraintTable.getItems();
      constraintTable.setItems(null);
      items.clear();
      items.addAll(constraints);
      constraintTable.setItems(items);

      System.out.print(generalSettings.toString());
   }

}
