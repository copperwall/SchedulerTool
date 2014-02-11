package scheduler_tool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class DesktopMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            VBox root = (VBox) FXMLLoader.load(getClass().getResource("AdminFrameView.fxml"));
            Scene scene = new Scene(root,1070,650);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(750);
            primaryStage.setMinHeight(480);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
