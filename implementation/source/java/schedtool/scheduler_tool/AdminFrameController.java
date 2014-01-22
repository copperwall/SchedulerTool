package scheduler_tool;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class AdminFrameController {
    private AnchorPane adminGeneralSettings;
    private AnchorPane adminMainTable;
    private AnchorPane adminAnalytics;
    private AnchorPane adminAvailableCourses;
    private AnchorPane locationDB;
    private AnchorPane coursesDBView;
    private AnchorPane instructorsDB;
    private AnchorPane adminExistingSchedules;
    private AnchorPane adminNewSchedule;
    private AnchorPane adminPublish;
    private AnchorPane adminGenerating;
    private AnchorPane adminInstructorPrefs;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox topPane;


    @FXML
    void loadAdminAnalyticsView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
                
         try {
            adminAnalytics = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/admin/analytics/AdminAnalyticsView.fxml"));
            VBox.setVgrow(adminAnalytics, Priority.ALWAYS);
            children.add((Node) adminAnalytics);
         } 
         catch (Exception exc)
         {
             exc.printStackTrace();
         }
    }

    @FXML
    void loadAdminAvailableCoursesView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
                
         try {
            adminAvailableCourses = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/admin/generation/AdminAvailableCoursesView.fxml"));
            VBox.setVgrow(adminAvailableCourses, Priority.ALWAYS);
            children.add((Node) adminAvailableCourses);
         } 
         catch (Exception exc)
         {
             exc.printStackTrace();
         }
    }

    @FXML
    void loadAdminGeneralSettingsView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
                
         try {
            adminGeneralSettings = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/admin/generation/AdminGeneralSettingsView.fxml"));
            VBox.setVgrow(adminGeneralSettings, Priority.ALWAYS);
            children.add((Node) adminGeneralSettings);
         } 
         catch (Exception exc)
         {
             exc.printStackTrace();
         }
    }

    @FXML
    void loadAdminGenerateView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
                
         try {
        	 adminGenerating = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/admin/generation/AdminGenerating.fxml"));
        	 VBox.setVgrow(adminGenerating, Priority.ALWAYS);
        	 children.add((Node) adminGenerating);
         } 
         catch (Exception exc)
         {
             exc.printStackTrace();
         }
    }

    @FXML
    void loadAdminInstructorPreferencesView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
                
         try {
            adminInstructorPrefs = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/admin/generation/AdminInstructorPreferencesView.fxml"));
            VBox.setVgrow(adminInstructorPrefs, Priority.ALWAYS);
            children.add((Node) adminInstructorPrefs);
         } 
         catch (Exception exc)
         {
             exc.printStackTrace();
         }
    }

    @FXML
    void loadAdminMainView(MouseEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
         try {
        	VBox.setVgrow(adminMainTable, Priority.ALWAYS);
            children.add((Node) adminMainTable);
         } 
         catch (Exception exc)
         {
             exc.printStackTrace();
         }
    }

    @FXML
    void loadAdminPublishView(ActionEvent event) {
   	 List<Node> children = topPane.getChildren();
     children.remove(2);
             
      try {
         adminPublish = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/admin/generation/AdminPublish.fxml"));
         VBox.setVgrow(adminPublish, Priority.ALWAYS);
         children.add((Node) adminPublish);
      } 
      catch (Exception exc)
      {
          exc.printStackTrace();
      }
    }

    @FXML
    void loadCoursesDBView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
                
         try {
        	coursesDBView = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/data/databases/CourseDBView.fxml"));
        	VBox.setVgrow(coursesDBView, Priority.ALWAYS);
        	children.add((Node) coursesDBView);
         } 
         catch (Exception exc)
         {
             exc.printStackTrace();
         }
    }

    @FXML
    void loadExistingScheduleView(ActionEvent event) {
    	 List<Node> children = topPane.getChildren();
         children.remove(2);
                 
          try {
             adminExistingSchedules = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/admin/generation/AdminExistingSchedules.fxml"));
             VBox.setVgrow(adminExistingSchedules, Priority.ALWAYS);
             children.add((Node) adminExistingSchedules);
          } 
          catch (Exception exc)
          {
              exc.printStackTrace();
          }
    }

    @FXML
    void loadInstructorsDBView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
        
        try {
        	instructorsDB = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/data/databases/InstructorDBView.fxml"));
        	VBox.setVgrow(instructorsDB, Priority.ALWAYS);
        	children.add((Node)instructorsDB);
        } catch(Exception exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    void loadLocationsDBView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
        
        try {
            locationDB = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/data/databases/LocationDBView.fxml"));
            VBox.setVgrow(locationDB, Priority.ALWAYS);
            children.add((Node)locationDB);
        } catch(Exception exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    void loadNewScheduleView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
                
         try {
        	 adminNewSchedule = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/admin/generation/AdminNewSchedule.fxml"));
        	 VBox.setVgrow(adminNewSchedule, Priority.ALWAYS);
            children.add((Node) adminNewSchedule);
         } 
         catch (Exception exc)
         {
             exc.printStackTrace();
         }
    }

    @FXML
    void initialize() {
        assert topPane != null : "fx:id=\"topPane\" was not injected: check your FXML file 'AdminFrameView.fxml'.";
        List<Node> children = topPane.getChildren();
        try {
        	adminMainTable = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/admin/generation/AdminMainTable.fxml"));
        	VBox.setVgrow(adminMainTable, Priority.ALWAYS);
            children.add((Node)adminMainTable);
        } catch(Exception exc) {
            exc.printStackTrace();
        }


    }

}
