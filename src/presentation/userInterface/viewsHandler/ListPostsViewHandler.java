package presentation.userInterface.viewsHandler;

import java.awt.Button;

import application.ApplicationFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.userInterface.helper.AlertBox;
import presentation.userInterface.tableCells.ConsoleCell;
import presentation.userInterface.tableCells.PostCell;

public class ListPostsViewHandler {

	@FXML private TableView<PostCell> tableViewPosts;
	 @FXML private TableColumn<PostCell,String> gameTitleColumn ;
	 @FXML private TableColumn<PostCell,String> postTypeColumn ;
	 @FXML private TableColumn<PostCell,String> offerordemandColumn ;
	 @FXML private TableColumn<PostCell,String> dateColumn ;
	 @FXML private Button addButton ;
	 @FXML private Button filterButton ;
	 @FXML private Button sortButton;




	 
	 /**
	     * Initializes the controller class. This method is automatically called
	     * after the fxml file has been loaded.
	     */
	    @FXML public void initialize() {
	        // Initialize the post table with 4 columns.
	    	gameTitleColumn.setCellValueFactory(cellData -> cellData.getValue().idPostProperty());
	    	postTypeColumn.setCellValueFactory(cellData -> cellData.getValue().getPostTypeProperty());
	    	offerordemandColumn.setCellValueFactory(cellData -> cellData.getValue().getStatusPostProperty());
	    	dateColumn.setCellValueFactory(cellData -> cellData.getValue().DatePostProperty());
	    	
			
			tableViewPosts.setItems(ApplicationFacade.getInstance().getPostsList());
			
	    }

	    
	    
	    /**
	     * Called when the user clicks on the delete button.
	     */
	    @FXML
	    private void handleDeletePost() {
	        int selectedIndex = tableViewPosts.getSelectionModel().getSelectedIndex();
	        if (selectedIndex >= 0) {
	        	String idItem = ApplicationFacade.getInstance().getPostsList().get(selectedIndex).getIdPost();
	        	ApplicationFacade.getInstance().getEditorsList().remove(selectedIndex);
	        	ApplicationFacade.getInstance().deleteConsole(idItem);
	            tableViewPosts.getItems().remove(selectedIndex);
	            AlertBox.showAlert("Delete succeed", "", "Post deletion");
	            
	        } else {
	            AlertBox.showAlert("", "", "");
	        }
	    }
	
}
