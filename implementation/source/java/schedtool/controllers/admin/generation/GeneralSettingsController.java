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
import models.admin.generation.*;

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
       System.out.println("In onEndTimeExit()");
    }

    @FXML
    void onStartTimeExit(ActionEvent event) {
        System.out.println("In onStartTimeExit()");
    }

    @FXML
    void onAddConstraintBtnEvent(ActionEvent event) {
        System.out.println("In onAddConstraintBtnEvent()");
    }

    @FXML
    void onMwfEvent(ActionEvent event) {
        System.out.println("In onMwfEvent()");
    }

    @FXML
    void onThEvent(ActionEvent event) {
        System.out.println("In onThEvent()");
    }

    @FXML
    void onMwEvent(ActionEvent event) {
        System.out.println("In onMwEvent()");
    }

    @FXML
    void onWfEvent(ActionEvent event) {
        System.out.println("In onWfEvent()");
    }

    @FXML
    void onMfEvent(ActionEvent event) {
        System.out.println("In onMfEvent()");
    }

    @FXML
    void onMtwhEvent(ActionEvent event) {
        System.out.println("In onMtwhEvent()");
    }

    @FXML
    void onMtwfEvent(ActionEvent event) {
        System.out.println("In onMtwfEvent()");
    }

}

