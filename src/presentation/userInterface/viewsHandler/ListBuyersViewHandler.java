package presentation.userInterface.viewsHandler;

import application.ApplicationFacade;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.userInterface.helper.AlertBox;
import presentation.userInterface.tableCells.BuyerCell;
import presentation.userInterface.tableCells.EditorCell;

public class ListBuyersViewHandler {
	
	@FXML private TableView<BuyerCell> tableViewBuyers;
	@FXML private TableColumn<BuyerCell,String> nameColumnBuyer;
	@FXML private Label userNameLabelBuyer;
	@FXML private Label zipCodeLabelBuyer;
	@FXML private Label phoneNumberLabelBuyer;
	@FXML private Label emailLabelBuyer;
	@FXML private Button deleteBTN;
	
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML 
    public void initialize() {
        // Initialize the person table with the two columns.
		nameColumnBuyer.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());		
		
		tableViewBuyers.setItems(ApplicationFacade.getInstance().getBuyerList());
		
		 // Clear person details.
	    showBuyerDetails(null);

	    // Listen for selection changes and show the person details when changed.
	    tableViewBuyers.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showBuyerDetails(newValue));
    }
    
	/**
     * Method called when the user clicks on the delete button.
     */
    @FXML
	private void handleDeleteBuyer() {
		int selectedIndex = tableViewBuyers.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	String idActor = ApplicationFacade.getInstance().getBuyerList().get(selectedIndex).getId();
        	ApplicationFacade.getInstance().getBuyerList().remove(selectedIndex);
        	ApplicationFacade.getInstance().deleteActor(idActor);
            tableViewBuyers.getItems().remove(selectedIndex);
            AlertBox.showAlert("Delete succeed", "", "Buyer deletion");
        } else {
            AlertBox.showAlert("", "", "");
        }
	}
	
	/**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param person the person or null
     */
    private void showBuyerDetails(BuyerCell buyer) {
        if (buyer != null) {
            // Fill the labels with info from the person object.
        	phoneNumberLabelBuyer.setText(buyer.getPhoneNumber());
        	emailLabelBuyer.setText(buyer.getEmail());
        	userNameLabelBuyer.setText(buyer.getUN());
        	zipCodeLabelBuyer.setText(buyer.getZipCode());
        } else {
            // Person is null, remove all the text.
        	phoneNumberLabelBuyer.setText("");
            emailLabelBuyer.setText("");
            userNameLabelBuyer.setText("");
            zipCodeLabelBuyer.setText("");
        }
    }
}
