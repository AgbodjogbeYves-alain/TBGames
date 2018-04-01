package presentation.userInterface.viewsHandler;


import application.ApplicationFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.userInterface.helper.AlertBox;
import presentation.userInterface.tableCells.AdministratorCell;

public class ListAdministratorsViewHandler {
	
	@FXML TableView<AdministratorCell> tableView ;
	@FXML TableColumn<AdministratorCell, String> usernameCol;
	@FXML TableColumn<AdministratorCell, String> emailCol;
	@FXML private Label adminUsername;
	@FXML private Label adminEmail;
	@FXML private Button deleteBTN;
	@FXML private Button EditBTN;

	@FXML
	protected void initialize(){
        // Initialize the person table with the two columns.
    	usernameCol.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
		emailCol.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		
		tableView.setItems(ApplicationFacade.getInstance().getAdministratorsList());
		
		 // Clear admin details.
	    showAdministratorDetails(null);

	    // Listen for selection changes and show the person details when changed.
	    tableView.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showAdministratorDetails(newValue));
	}
	
	public void showAdministratorDetails(AdministratorCell administrator) {
		if (administrator != null) {
            // Fill the labels with info from the administrator object.
			adminUsername.setText(administrator.getUN());
			adminEmail.setText(administrator.getEmail());

        } else {
            // Administrator is null, remove all the text.
        	System.out.print("HERE");
        	adminUsername.setText("");
        	adminEmail.setText("");
        }
	}
	
	 /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteAdministrator() {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	
        	String idAdmin = ApplicationFacade.getInstance().getAdministratorsList().get(selectedIndex).getId();
        	ApplicationFacade.getInstance().getAdministratorsList().remove(selectedIndex);
        	ApplicationFacade.getInstance().deleteActor(idAdmin);
            tableView.getItems().remove(selectedIndex);
            AlertBox.showAlert("Delete succeed", "", "Administratior deletion");
            
        } else {
            AlertBox.showAlert("", "", "");
        }
    }
}
