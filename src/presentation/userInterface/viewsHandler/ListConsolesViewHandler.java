package presentation.userInterface.viewsHandler;

import application.ApplicationFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.userInterface.helper.AlertBox;
import presentation.userInterface.tableCells.ConsoleCell;
import presentation.userInterface.tableCells.EditorCell;

public class ListConsolesViewHandler {
	 @FXML private TableView<ConsoleCell> tableViewConsole;
	 @FXML private TableColumn<ConsoleCell,String> nameConsoleColumn ;
	 @FXML private TableColumn<ConsoleCell,String> categoryConsoleColumn ;
	 @FXML private Label consoleNameLabel ;
	 @FXML private Label consoleTypeLabel ;
	 @FXML private Label ratingLabel;



	 
	 /**
	     * Initializes the controller class. This method is automatically called
	     * after the fxml file has been loaded.
	     */
	    @FXML public void initialize() {
	        // Initialize the consoles table with the two columns.
	    	nameConsoleColumn.setCellValueFactory(cellData -> cellData.getValue().itemNameProperty());
	    	categoryConsoleColumn.setCellValueFactory(cellData -> cellData.getValue().consoleTypeProperty());
			
			tableViewConsole.setItems(ApplicationFacade.getInstance().getConsolesList());
			
			 // Clear console details.
		    showConsoleDetails(null);

		    // Listen for selection changes and show the console details when changed.
		    tableViewConsole.getSelectionModel().selectedItemProperty().addListener(
		            (observable, oldValue, newValue) -> showConsoleDetails(newValue));
	    }

	    /**
	     * Fills all text fields to show details about the console.
	     * If the specified console is null, all text fields are cleared.
	     *
	     * @param Console the console or null
	     */
	    private void showConsoleDetails(ConsoleCell console) {
	        if (console != null) {
	            // Fill the labels with info from the console object.
	        	consoleNameLabel.setText(console.getName());
	        	consoleTypeLabel.setText(console.getConsoleType());
	        	ratingLabel.setText(String.valueOf(console.getRate()));
	            
	        } else {
	            // console is null, remove all the text.
	        	consoleNameLabel.setText("");
	        	consoleTypeLabel.setText("");
	        	ratingLabel.setText("");
	        }
	    }
	    
	    
	    /**
	     * Called when the user clicks on the delete button.
	     */
	    @FXML
	    private void handleDeleteConsole() {
	        int selectedIndex = tableViewConsole.getSelectionModel().getSelectedIndex();
	        if (selectedIndex >= 0) {
	        	String idItem = ApplicationFacade.getInstance().getConsolesList().get(selectedIndex).getId();
	        	ApplicationFacade.getInstance().getEditorsList().remove(selectedIndex);
	        	ApplicationFacade.getInstance().deleteConsole(idItem);
	            tableViewConsole.getItems().remove(selectedIndex);
	            AlertBox.showAlert("Delete succeed", "", "Console deletion");
	        } else {
	            AlertBox.showAlert("", "", "");
	        }
	    }
}
