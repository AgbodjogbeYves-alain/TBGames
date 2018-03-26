package presentation.userInterface.viewsHandler;

import java.io.IOException;

import application.ApplicationFacade;
import application.Editor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import presentation.MainStage;
import presentation.userInterface.helper.AlertBox;
import presentation.userInterface.tableCells.EditorCell;

public class ListEditorsViewHandler {

	 @FXML private TableView<EditorCell> tableViewEditors;
	 @FXML private TableColumn<EditorCell,String> representativeNameColumnEditor ;
	 @FXML private TableColumn<EditorCell,String> nameColumnEditor ;
	 @FXML private Label phoneNumberLabelEditor ;
	 @FXML private Label labelDescriptionEditors ;
	 @FXML private Label emailLabelEditor ;
	 @FXML private Tab manageEditorsPane;



	 
	 /**
	     * Initializes the controller class. This method is automatically called
	     * after the fxml file has been loaded.
	     */
	    @FXML public void initialize() {
	        // Initialize the person table with the two columns.
	    	representativeNameColumnEditor.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
			nameColumnEditor.setCellValueFactory(cellData -> cellData.getValue().representativenameProperty());
			
			tableViewEditors.setItems(ApplicationFacade.getInstance().getEditorsList());
			
			 // Clear person details.
		    showEditorDetails(null);

		    // Listen for selection changes and show the person details when changed.
		    tableViewEditors.getSelectionModel().selectedItemProperty().addListener(
		            (observable, oldValue, newValue) -> showEditorDetails(newValue));
	    }

	    /**
	     * Fills all text fields to show details about the person.
	     * If the specified person is null, all text fields are cleared.
	     *
	     * @param person the person or null
	     */
	    private void showEditorDetails(EditorCell editor) {
	        if (editor != null) {
	            // Fill the labels with info from the person object.
	        	phoneNumberLabelEditor.setText(editor.getPhoneNumber());
	            labelDescriptionEditors.setText(editor.getDescription());
	            emailLabelEditor.setText(editor.getEmail());
	            
	        } else {
	            // Person is null, remove all the text.
	        	phoneNumberLabelEditor.setText("");
	            labelDescriptionEditors.setText("");
	            emailLabelEditor.setText("");
	        }
	    }
	    
	    
	    /**
	     * Called when the user clicks on the delete button.
	     */
	    @FXML
	    private void handleDeleteEditor() {
	        int selectedIndex = tableViewEditors.getSelectionModel().getSelectedIndex();
	        if (selectedIndex >= 0) {
	            tableViewEditors.getItems().remove(selectedIndex);
	        } else {
	            AlertBox.showAlert("", "", "");
	        }
	    }
   
//    /**
//     * Returns the data as an observable list of Persons. 
//     * @return
//     */
//    public ObservableList<Person> getPersonData() {
//        return personData;
//    }

}
