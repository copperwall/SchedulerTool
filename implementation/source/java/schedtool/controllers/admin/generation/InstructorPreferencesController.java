package controllers.admin.generation;

import java.util.ArrayList;
import java.util.Vector;

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
import models.data.databases.Course.LabProximity;

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
   private GridPane coursePreferencesGrid;
   
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
      InstructorDB instructorDB = new InstructorDB();
      
      Vector<Instructor> instructors = instructorDB.getAllInstructors();
      ObservableList<Instructor> instructorsObservable = instructorListTable.getItems();
      instructorsObservable.clear();
      instructorsObservable.addAll(instructors);
      instructorListTable.setItems(instructorsObservable);
      
      Vector<Course> courses = new CourseDB().getAllCourses();
      courses.add(new Course("CPE", 101, 0, "", true, 0, LabProximity.DIFF_DAY, false));
      courses.add(new Course("CPE", 102, 0, "", true, 0, LabProximity.DIFF_DAY, false));
      courses.add(new Course("CPE", 103, 0, "", true, 0, LabProximity.DIFF_DAY, false));
      courses.add(new Course("CPE", 141, 0, "", true, 0, LabProximity.DIFF_DAY, false));
      courses.add(new Course("CPE", 225, 0, "", true, 0, LabProximity.DIFF_DAY, false));
      courses.add(new Course("CPE", 300, 0, "", true, 0, LabProximity.DIFF_DAY, false));
      courses.add(new Course("CPE", 307, 0, "", true, 0, LabProximity.DIFF_DAY, false));
      courses.add(new Course("CPE", 308, 0, "", true, 0, LabProximity.DIFF_DAY, false));
      courses.add(new Course("CPE", 309, 0, "", true, 0, LabProximity.DIFF_DAY, false));
      
      int rowIndex = 1;
      for (Course course : courses) {
         CheckBox checkbox = new CheckBox();
         checkbox.setSelected(instructors.get(0).getOneClassPref(course) == 0);
         
         Slider slider = new Slider();
         slider.setMajorTickUnit(1);
         slider.setMinorTickCount(0);
         slider.setMin(1);
         slider.setShowTickLabels(false);
         slider.setShowTickMarks(true);
         slider.setSnapToTicks(true);
         slider.setMax(5);
         if (instructors.get(0).getOneClassPref(course) != 0)
            slider.setValue(instructors.get(0).getOneClassPref(course));
         
         coursePreferencesGrid.add(new Label(course.getPrefix()), 0, rowIndex);
         coursePreferencesGrid.add(new Label(String.valueOf(course.getCourseNum())), 1, rowIndex);
         coursePreferencesGrid.add(checkbox, 2, rowIndex);
         coursePreferencesGrid.add(slider, 3, rowIndex);
         rowIndex++;
      }
      Day monday = new Day("101001010111001");
      ArrayList<Day> timePref = new ArrayList<Day>();
      timePref.add(monday);
      instructors.get(0).setTimePrefs(timePref);
      
      ArrayList<Day> timePrefs = instructors.get(0).getTimePrefs();
      if (timePrefs != null) {
         for (int column = 0; column < 5 && column < timePrefs.size(); column++) {
            int row = 0;
            if (timePrefs.get(column) != null) {
               for (boolean isAvailable : timePrefs.get(column).getAvailability()) {
                  children.get(21 + column + row * 5).setStyle("-fx-background-color: " + (isAvailable ? "green" : "white") +";");
                  row++;
               }
            }
         }
      }
   }

   @FXML
   void onLockChanged(ActionEvent event) {
      new InstructorDB().editInstructor(null);
   }

}