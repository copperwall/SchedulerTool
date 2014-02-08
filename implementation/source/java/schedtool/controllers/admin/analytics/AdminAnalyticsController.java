package controllers.admin.analytics;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.HashMap;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
/* Import Models */
import models.admin.analytics.*;

/**
 * Controller for the admin analytics view.
 * 
 * @author Alex Kavanaugh
 * 
 */
public class AdminAnalyticsController
{
    private AdminAnalytics model = new AdminAnalytics();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<AnalyticsRow> analyticsTable;
    
    @FXML
    private Label avgText;
    
    @FXML
    private Label medianText;
    
    @FXML
    private Label modeText;
    
    @FXML
    private Label stdDevText;

    @FXML
    void initialize() {
        this.model.calculate();
        
        ObservableList<AnalyticsRow> items = this.analyticsTable.getItems();
        this.analyticsTable.setItems(null);
        items.clear();
        items.addAll(this.model.getIndividualAnalytics());
        this.analyticsTable.setItems(items);
        
        HashMap<String, ArrayList<Integer>> overall = this.model.getOverallAnalytics();
        
        this.avgText.setText(overall.get("Average").get(0).toString());
        this.medianText.setText(overall.get("Median").get(0).toString());
        
        StringBuilder builder = new StringBuilder();
        
        for (Integer modeItem : overall.get("Mode"))
        {
            builder.append(modeItem.toString() + ", ");
        }
        
        this.modeText.setText(builder.toString());
        
        this.stdDevText.setText(overall.get("Standard Deviation").get(0).toString());
    }
}
