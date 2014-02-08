package controllers.admin.generation;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
/* Import Models */
import models.admin.generation.*;


public class AdminAvailableCoursesController implements Observer {
    private AdminAvailableCourses model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<AvailableCoursesRow> availableCoursesTable;
    
    @FXML
    private TableColumn<AvailableCoursesRow, String> sectionsColumn;
    
    @FXML
    void loadFromTerm(ActionEvent event) {
        //this.model.loadFromTerm("Test Term");
    }

    @FXML
    void loadSuggested(ActionEvent event) {
       this.model.loadSuggested();
    }

    @FXML
    void initialize() {
        this.model = new AdminAvailableCourses();
        this.model.addObserver(this);
        this.sectionsColumn.setCellFactory(TextFieldTableCell.<AvailableCoursesRow>forTableColumn());
        this.update(this.model, this.availableCoursesTable);
    }

    @Override
    public void update(Observable arg0, Object arg1)
    {
        ObservableList<AvailableCoursesRow> items = this.availableCoursesTable.getItems();
        this.availableCoursesTable.setItems(null);
        items.removeAll(items);
        items.addAll(this.model.getAvailableCourses());
        this.availableCoursesTable.setItems(items);
        this.availableCoursesTable.getColumns().get(4).setVisible(false);
        this.availableCoursesTable.getColumns().get(4).setVisible(true);
    }

}
