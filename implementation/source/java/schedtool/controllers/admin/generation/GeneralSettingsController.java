package controllers.admin.generation;


/**
 *
 * @author Chase Kragenbrink
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import models.admin.generation.AdminGeneralSettings;

public class GeneralSettingsController {

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
    private TableView<?> blockedOutTimesTable;

    @FXML
    private Button addConstraintBtn;

    @FXML
    private CheckBox wfPattern;

    @FXML
    private CheckBox mtwhPattern;

    @FXML
    private CheckBox mtwfPattern;

    @FXML
    private TableView<?> constraintTable;

    @FXML
    private CheckBox mfPattern;

    @FXML
    void onEndTimeExit(ActionEvent event) {
       new AdminGeneralSettings().setEndTime(0);
    }

    @FXML
    void onStartTimeDone(ActionEvent event) {
        new AdminGeneralSettings().setEndTime(0);
    }

    @FXML
    void onAddConstraintBtnEvent(ActionEvent event) {
        new AdminGeneralSettings().addConstraint(constraintText.getText());
    }

    @FXML
    void onMwfEvent(ActionEvent event) {
        new AdminGeneralSettings().updateTimePattern(AdminGeneralSettings.TIME_PATTERN.MWF, mwfPattern.isSelected());
    }

    @FXML
    void onThEvent(ActionEvent event) {
        new AdminGeneralSettings().updateTimePattern(AdminGeneralSettings.TIME_PATTERN.TH, thPattern.isSelected());
    }

    @FXML
    void onMwEvent(ActionEvent event) {
        new AdminGeneralSettings().updateTimePattern(AdminGeneralSettings.TIME_PATTERN.MW, mwPattern.isSelected());
    }

    @FXML
    void onWfEvent(ActionEvent event) {
        new AdminGeneralSettings().updateTimePattern(AdminGeneralSettings.TIME_PATTERN.WF, wfPattern.isSelected());
    }

    @FXML
    void onMfEvent(ActionEvent event) {
        new AdminGeneralSettings().updateTimePattern(AdminGeneralSettings.TIME_PATTERN.MF, mfPattern.isSelected());
    }

    @FXML
    void onMtwhEvent(ActionEvent event) {
        new AdminGeneralSettings().updateTimePattern(AdminGeneralSettings.TIME_PATTERN.MTWH, mtwhPattern.isSelected());
    }

    @FXML
    void onMtwfEvent(ActionEvent event) {
        new AdminGeneralSettings().updateTimePattern(AdminGeneralSettings.TIME_PATTERN.MTWF, mtwfPattern.isSelected());
    }

}


