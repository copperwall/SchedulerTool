package controllers.admin.generation;
import scheduler_tool.*;

import java.net.URL;
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
/* Import Models */
import models.admin.generation.*;
import javafx.scene.layout.AnchorPane;

import java.util.Observable;
import java.util.Observer;
public class GenerateController implements Observer {
	private static AdminGenerating model;
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPane;
    
    @FXML
    private TableView<MainTableRow> adminMainTable = AdminFrameController.getAdminMainTable();
    
    @FXML
    public static void generate() {
        model.generate();
    }


    @FXML
    void initialize() {
        assert AnchorPane != null : "fx:id=\"AnchorPane\" was not injected: check your FXML file 'AdminGenerating.fxml'.";
        model = new AdminGenerating();
        model.getSchedule().addObserver(this);
        this.update(null, (Object)this.adminMainTable);
    }
    
    @Override
    public void update(Observable arg0, Object arg1)
    {
        ObservableList<MainTableRow> items = this.adminMainTable.getItems();
        this.adminMainTable.setItems(null);
        items.removeAll(items);
        items.addAll(model.getSchedule().getSections());
        this.adminMainTable.setItems(items);
    }
}
