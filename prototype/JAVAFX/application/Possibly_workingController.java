/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Layer 0
 */
public class Possibly_workingController implements Initializable {
    @FXML
    private StackPane contentPane;
    @FXML
    private VBox topPane;
    private AnchorPane generalsettings;
    private AnchorPane analytics;
    private AnchorPane adminavailablecourses;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
   private void loadGeneralSettings(ActionEvent event) {
      List<Node> children = topPane.getChildren();
      children.remove(2);
              
       try {
          generalsettings = (AnchorPane) FXMLLoader.load(getClass().getResource("general_settings.fxml"));
          children.add((Node)generalsettings);
       } 
       catch (IOException exc)
       {
       }
   }
   @FXML
   private void loadAnalytics(ActionEvent event) {
      List<Node> children = topPane.getChildren();
      children.remove(2);
              
       try {
          analytics = (AnchorPane) FXMLLoader.load(getClass().getResource("analytics.fxml"));
          children.add((Node)analytics);
       } 
       catch (IOException exc)
       {
       }
   }
   @FXML
  private void loadAdminAvailableCourses(ActionEvent event) {
      List<Node> children = topPane.getChildren();
      children.remove(2);
              
       try {
          adminavailablecourses = (AnchorPane) FXMLLoader.load(getClass().getResource("AdminAvailableCourses.fxml"));
          children.add((Node)adminavailablecourses);
       } 
       catch (IOException exc)
       {
       }
   }

    @FXML
    private void openInstructorsDB(ActionEvent event) {
        Pane safe = (Pane) topPane;
        
        List<Node> children = safe.getChildren();
        children.remove(2);
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("InstructorDB.fxml"));

            Scene scene = new Scene(root);
            
            children.add((Node)root);
        } catch (IOException exc) {
        }
    }
    
}
