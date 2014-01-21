import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;


public class CourseDBController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    void addCourse(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CourseDBAddView.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    void cancelChanges(ActionEvent event) {
    }

    @FXML
    void deleteCourse(ActionEvent event) {
    }

    @FXML
    void editCourse(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("CourseDBEditView.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    void saveChanges(ActionEvent event) {
    }

    @FXML
    void initialize() {


    }

}
