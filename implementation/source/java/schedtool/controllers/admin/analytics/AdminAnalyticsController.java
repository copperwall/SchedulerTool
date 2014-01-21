package controllers.admin.analytics;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/* Import Models */
import models.admin.analytics.*;

/**
 * Controller for the admin analytics view.
 * 
 * @author Alex Kavanaugh
 *
 */
public class AdminAnalyticsController {
    private AdminAnalytics model = new AdminAnalytics();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    void initialize() {
        System.out.println("AdminAnalyticsController initialized.");
        this.model.calculate_overall();
        //TODO
        this.model.calculate_individual("Test string");
    }

}