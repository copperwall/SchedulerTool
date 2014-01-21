import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class InstructorDBController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deleteButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button editButton;

    @FXML
    private TableView<?> instructorTable;

    @FXML
    private Button addButton;

    @FXML
    private Button saveButton;

    @FXML
    void addInstructor(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("InstructorDBAdd.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException exc) {
        }
    }

    @FXML
    void editInstructor(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("InstructorDBEdit.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    void deleteInstructor(ActionEvent event) {

    }

    @FXML
    void cancelChanges(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'InstructorDB.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'InstructorDB.fxml'.";
        assert editButton != null : "fx:id=\"editButton\" was not injected: check your FXML file 'InstructorDB.fxml'.";
        assert instructorTable != null : "fx:id=\"instructorTable\" was not injected: check your FXML file 'InstructorDB.fxml'.";
        assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'InstructorDB.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'InstructorDB.fxml'.";

    }
}
