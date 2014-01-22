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
import javafx.scene.layout.VBox;


public class AdminFrameController {
    private AnchorPane adminGeneralSettings;
    private AnchorPane adminMainTable;
    private AnchorPane adminAnalytics;
    private AnchorPane adminAvailableCourses;
    private AnchorPane locationDB;
    private AnchorPane coursesDBView;
    private AnchorPane instructorsDB;

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
            children.add((Node) adminGeneralSettings);
         } 
         catch (Exception exc)
         {
             exc.printStackTrace();
         }
    }

    @FXML
    void loadAdminGenerateView(ActionEvent event) {
    }

    @FXML
    void loadAdminInstructorPreferencesView(ActionEvent event) {
    }

    @FXML
    void loadAdminMainView(MouseEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
                
         try {
            children.add((Node) adminMainTable);
         } 
         catch (Exception exc)
         {
             exc.printStackTrace();
         }
    }

    @FXML
    void loadAdminPublishView(ActionEvent event) {
    }

    @FXML
    void loadCoursesDBView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
                
         try {
        	coursesDBView = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/data/databases/CourseDBView.fxml"));
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
             adminGeneralSettings = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/admin/generation/AdminExistingSchedules.fxml"));
             children.add((Node) adminGeneralSettings);
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
            children.add((Node)locationDB);
        } catch(Exception exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    void loadNewScheduleView(ActionEvent event) {
    }

    @FXML
    void initialize() {
        assert topPane != null : "fx:id=\"topPane\" was not injected: check your FXML file 'AdminFrameView.fxml'.";
        List<Node> children = topPane.getChildren();
        try {
        	adminMainTable = (AnchorPane) FXMLLoader.load(getClass().getResource("../views/admin/generation/AdminMainTable.fxml"));
            children.add((Node)adminMainTable);
        } catch(Exception exc) {
            exc.printStackTrace();
        }


    }

}
