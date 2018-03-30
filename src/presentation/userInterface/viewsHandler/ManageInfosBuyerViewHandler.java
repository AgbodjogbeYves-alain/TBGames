package presentation.userInterface.viewsHandler;

import java.io.IOException;

import application.Actor;
import application.ApplicationFacade;
import application.Buyer;
import application.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import presentation.MainStage;
import presentation.userInterface.helper.AlertBox;
import presentation.userInterface.helper.DialogBoxEditBuyer;

public class ManageInfosBuyerViewHandler {

	@FXML private Label phoneNumberLabelBuyer;
	@FXML private Label emailLabelBuyer;
	@FXML private Label userNameLabelBuyer;
	@FXML private Label zipCodeLabelBuyer;
	@FXML private Button deleteBTN;
	@FXML private Button validateBTN;
	
	
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML public void initialize() {
    	User buyer = ((User) ApplicationFacade.getInstance().getConnectedUser());
    	phoneNumberLabelBuyer.setText(buyer.getPhoneNumber());
    	emailLabelBuyer.setText(buyer.getEmail());
    	userNameLabelBuyer.setText(buyer.getUsername());
    	zipCodeLabelBuyer.setText(buyer.getZipCode());
    	
    }
    
	/**
     * Method called when the user clicks on the edit button.
     * @return 
     */
    @FXML
    private boolean handleEditBuyer() {
    	
    	try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainStage.class.getResource("userInterface/fxml/EditBuyerPane.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainStage.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            DialogBoxEditBuyer controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setActor();

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteBuyer() {
        String result = AlertBox.showAlertYesNo("Are you sure you want to delete your account?","","Suppress Account");
        System.out.println(result);
        if(result == "yes") {
        	ApplicationFacade.getInstance().deleteActor(((Actor) ApplicationFacade.getInstance().getConnectedUser()).getIdActor());
            AlertBox.showAlert("Delete successfull", "", "Buyer deletion");
            ApplicationFacade.getInstance().logOff();
            MainStage.showView();
        } 
    }
}
