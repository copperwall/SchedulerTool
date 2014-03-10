package scheduler_tool;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import models.admin.generation.MainTableRow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class AdminFrameController {
    private AnchorPane adminGeneralSettings;
    private static AnchorPane adminMainTable;
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
    private static VBox topPane;


    @FXML
    void loadAdminAnalyticsView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
        children.add((Node) adminAnalytics);
    }
    
    @SuppressWarnings("unchecked")
	public static TableView<MainTableRow> getAdminMainTable()
    {
    	TableView<MainTableRow> tableView = null;
    	List<Node> children = adminMainTable.getChildren();

    	BorderPane bp = (BorderPane) children.get(0);
    	children = bp.getChildren();
    	if(children.get(1) instanceof TableView)
    	{
    		tableView = (TableView<MainTableRow>) children.get(1);
    	}
    		return tableView;
    }
    

    @FXML
    void loadAdminAvailableCoursesView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
        children.add((Node) adminAvailableCourses);
    }

    @FXML
    void loadAdminGeneralSettingsView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
        children.add((Node) adminGeneralSettings);
    }

    @FXML
    void loadAdminGenerateView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
        children.add((Node) adminGenerating);
        controllers.admin.generation.GenerateController.generate();
    }

    @FXML
    void loadAdminInstructorPreferencesView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
        children.add((Node) adminInstructorPrefs);
    }

    @FXML
    void loadAdminMainView(MouseEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
        children.add((Node) adminMainTable);
    }

    @FXML
    void loadAdminPublishView(ActionEvent event) {
    	List<Node> children = topPane.getChildren();
    	children.remove(2);
    	children.add((Node) adminPublish);
    }

    @FXML
    void loadCoursesDBView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
        children.add((Node) coursesDBView);
    }

    @FXML
    void loadExistingScheduleView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
        children.add((Node) adminExistingSchedules);
    }

    @FXML
    void loadInstructorsDBView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
        children.add((Node)instructorsDB);
    }

    @FXML
    void loadLocationsDBView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
        children.add((Node)locationDB);
    }

    @FXML
    void loadNewScheduleView(ActionEvent event) {
        List<Node> children = topPane.getChildren();
        children.remove(2);
        children.add((Node) adminNewSchedule);
    }
    
    public static void reloadMainTable(){
    	List<Node> children = topPane.getChildren();
        children.remove(2);
        children.add((Node) adminMainTable);
    }

    @FXML
    void initialize() {
        assert topPane != null : "fx:id=\"topPane\" was not injected: check your FXML file 'AdminFrameView.fxml'.";
        List<Node> children = topPane.getChildren();
        try {
        	adminMainTable = (AnchorPane) FXMLLoader.load(getClass().getResource("AdminMainTable.fxml"));
        	VBox.setVgrow(adminMainTable, Priority.ALWAYS);
            children.add((Node)adminMainTable);
            
            
            adminNewSchedule = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/admin/generation/AdminNewSchedule.fxml"));
            //locationDB = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/data/databases/LocationDBView.fxml"));
            instructorsDB = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/data/databases/InstructorDBView.fxml"));
            adminExistingSchedules = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/admin/generation/AdminExistingSchedules.fxml"));
            coursesDBView = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/data/databases/CourseDBView.fxml"));
            adminPublish = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/admin/generation/AdminPublish.fxml"));
            adminAnalytics = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/admin/analytics/AdminAnalyticsView.fxml"));
            adminAvailableCourses = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/admin/generation/AdminAvailableCoursesView.fxml"));
            adminGeneralSettings = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/admin/generation/AdminGeneralSettingsView.fxml"));
       	    adminGenerating = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/admin/generation/AdminGenerating.fxml"));
            adminInstructorPrefs = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/admin/generation/AdminInstructorPreferencesView.fxml"));
            
            VBox.setVgrow(adminNewSchedule, Priority.ALWAYS);
            //VBox.setVgrow(locationDB, Priority.ALWAYS);
            VBox.setVgrow(instructorsDB, Priority.ALWAYS);
            VBox.setVgrow(adminExistingSchedules, Priority.ALWAYS);
            VBox.setVgrow(coursesDBView, Priority.ALWAYS);
            VBox.setVgrow(adminPublish, Priority.ALWAYS);
            VBox.setVgrow(adminMainTable, Priority.ALWAYS);
            VBox.setVgrow(adminInstructorPrefs, Priority.ALWAYS);
            VBox.setVgrow(adminGenerating, Priority.ALWAYS);
            VBox.setVgrow(adminGeneralSettings, Priority.ALWAYS);
            VBox.setVgrow(adminAnalytics, Priority.ALWAYS);
            VBox.setVgrow(adminAvailableCourses, Priority.ALWAYS);
            
        } catch(Exception exc) {
            exc.printStackTrace();
        }
        
        


    }

}
