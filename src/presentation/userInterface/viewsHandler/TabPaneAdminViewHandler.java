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

public class TabPaneAdminViewHandler {

	@FXML TabPane tabPaneAdmin;
	 private static TableView<Editor> tableViewEditors = new TableView<Editor>();
	 private static ObservableList<Editor> data = ApplicationFacade.getInstance().getEditorsList();
	 @FXML private static TableColumn<Editor,String> representativeNameColumnEditor ;
	 @FXML private static TableColumn<Editor,String> nameColumnEditor ;
	 @FXML private Label phoneNumberLabelEditor ;
	 @FXML private Label labelDescriptionEditors ;
	 @FXML private Label emailLabelEditor ;
	 @FXML private Tab manageEditorsPane;



	 
	 /**
	     * Initializes the controller class. This method is automatically called
	     * after the fxml file has been loaded.
	     */
	    @FXML public static void initialize() {
	        // Initialize the person table with the two columns.
	        
    		try {
    			FXMLLoader loader = new FXMLLoader();
        		loader.setLocation(MainStage.class.getResource("userInterface/fxml/HomeViewAdsministrators.fxml"));

        		AnchorPane view;
				view = (AnchorPane) loader.load();
				Scene scene = new Scene(view);
	    		MainStage.getPrimaryStage().setTitle("Administrator view");
	    		MainStage.getPrimaryStage().setScene(scene);
	    		MainStage.getPrimaryStage().show();
		    	nameColumnEditor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsername()));
		        representativeNameColumnEditor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
		        tableViewEditors.setItems(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
