package controllers.admin.generation;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
   private TableView<Instructor> instructorListTable;

   @FXML
   private CheckBox lockInstructorPrefsCheckbox;

   @FXML
   private GridPane timePreferencesTable;
   
   @FXML
   private GridPane coursePreferencesGridPane;
   
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
   
   private void addCoursePrefRow(CoursePreference course, int rowIndex) {
      //coursePreferencesGridPane.getChildren().clear();
      int columnIndex = 0;
      Label prefix = new Label(course.course.getPrefix());
      coursePreferencesGridPane.add(prefix, columnIndex++, rowIndex);
      
      Label courseNo = new Label(String.valueOf(course.course.getCourseNum()));
      coursePreferencesGridPane.add(courseNo, columnIndex++, rowIndex);
      
      CheckBox notQualified = new CheckBox();
      notQualified.setSelected(course.preference == 0);
      coursePreferencesGridPane.add(notQualified, columnIndex++, rowIndex);
      
      Slider slider = new Slider();
      slider.setBlockIncrement(1.0);
      slider.setMajorTickUnit(1.0);
      slider.setMax(5.0);
      slider.setMin(1.0);
      slider.setMinorTickCount(0);
      slider.setShowTickMarks(true);
      slider.setSnapToTicks(true);
      slider.setValue(course.preference); 
      
      coursePreferencesGridPane.add(slider, columnIndex, rowIndex);
   }

}