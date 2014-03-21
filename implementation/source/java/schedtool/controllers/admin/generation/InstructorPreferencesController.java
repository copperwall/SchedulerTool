package controllers.admin.generation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
      instructorListTable.setOnMouseClicked(new EventHandler<Event>() {

         @Override
         public void handle(Event event) {
            Instructor instructor= instructorListTable.getSelectionModel().getSelectedItem();
            populatePrefs(instructor);
         }
      });
   }
   
   private void populatePrefs(Instructor instructor) {
      ArrayList<Course> courses = new CourseDB().getAllCourses();
      
      Iterator<Node> coursePrefs = coursePreferencesGrid.getChildren().iterator();
      while (coursePrefs.hasNext()) {
         Node next = coursePrefs.next(); 
         if (next instanceof Label) {
            Label label = (Label)next;
            if (!label.getText().equals("Course No.") && !label.getText().equals("Not qualified")
               && !label.getText().equals("Don't prefer - prefer") && !label.getText().equals("Prefix"))
               coursePrefs.remove();
         }
         else
            coursePrefs.remove();
         //System.out.println("coursePref size: " + coursePrefs.size());
      }
      
      
      int rowIndex = 1;
      for (Course course : courses) {
         CheckBox checkbox = new CheckBox();
         checkbox.setSelected(instructor.getOneClassPref(course) == 0);
         
         Slider slider = new Slider();
         slider.setMajorTickUnit(1);
         slider.setMinorTickCount(0);
         slider.setMin(1);
         slider.setShowTickLabels(false);
         slider.setShowTickMarks(true);
         slider.setSnapToTicks(true);
         slider.setMax(5);
         if (instructor.getOneClassPref(course) != 0)
            slider.setValue(instructor.getOneClassPref(course));
         
         
         coursePreferencesGrid.add(new Label(course.getPrefix()), 0, rowIndex);
         coursePreferencesGrid.add(new Label(String.valueOf(course.getCourseNum())), 1, rowIndex);
         coursePreferencesGrid.add(checkbox, 2, rowIndex);
         coursePreferencesGrid.add(slider, 3, rowIndex);
         rowIndex++;
      }
      
      
      
      ArrayList<Day> timePrefs = instructor.getTimePrefs();
      //for (Day d : timePrefs)
        // System.out.println(instructor.lastName + ": " + d.text);
      ObservableList<Node> children = timePreferencesTable.getChildren();
      if (timePrefs == null || timePrefs.size() == 0) {
         for (int column = 0; column < 5; column++) {
            int row = 0;
            while (row < 16){
               children.get(21 + column * 15 + row).setStyle("-fx-background-color: white;");
               row++;
            }
         }
      }
      else {
         for (int column = 0; column < 5; column++) {
            int index;
            int row = 0;
            ArrayList<Boolean> prefs = column < timePrefs.size() ? timePrefs.get(column).getAvailability() : null;
            for (int hour = 7; hour < 22; hour++) {
               index = 21 + column * 15 + row;
               children.get(index).setStyle("-fx-background-color: " + (prefs != null && hour < prefs.size() && prefs.get(hour) ? "green" : "white") +";");
               row++;
            }
         }
      }
   }

   @FXML
   void onLockChanged(ActionEvent event) {
      
   }

}