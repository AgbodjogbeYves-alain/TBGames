package presentation.userInterface.helper;

import java.io.IOException;

import application.ApplicationFacade;
import application.Buyer;
import application.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import presentation.MainStage;
import presentation.userInterface.viewsHandler.ManageInfosBuyerViewHandler;

public class DialogBoxEditBuyer {
	
	@FXML private TextField phoneNumberTF ;
	@FXML private TextField emailTF ;
	@FXML private TextField usernameTF;
	@FXML private TextField zipCodeTF;
	@FXML private PasswordField passwordTF;
	
	private boolean okClicked = false;
	private Stage dialogStage;
	
	/**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    
    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param person the person object to be edited
     */
    public void showEditDialog(Object actor) {
        try {
        	
        	 // Initialize the person table with the two columns.
	    	Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainStage.getPrimaryStage());
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainStage.class.getResource("userInterface/fxml/EditBuyerPane.fxml"));
            
            AnchorPane page = (AnchorPane) loader.load();
            Buyer buyer = ((Buyer) actor);
            
            // Create the dialog Stage.
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            this.setActor();

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * @return
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (usernameTF.getText() == null || usernameTF.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (emailTF.getText() == null || emailTF.getText().length() == 0) {
            errorMessage += "No valid email!\n"; 
        }
        if (passwordTF.getText() == null || passwordTF.getText().length() == 0) {
            errorMessage += "No valid password!\n"; 
        }
        
        if (zipCodeTF.getText() == null || zipCodeTF.getText().length() == 0) {
            errorMessage += "No valid zip code!\n"; 
        }
        
        if (phoneNumberTF.getText() == null || phoneNumberTF.getText().length() == 0) {
            errorMessage += "No valid phone number!\n"; 
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
        	Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            return false;
        }
    }
    
    /**
     * Sets the actor to be edited in the dialog.
     *
     */
    public void setActor() {
    	User b = (User) ApplicationFacade.getInstance().getConnectedUser();
        phoneNumberTF.setText(b.getPhoneNumber());
    	emailTF.setText(b.getEmail());
    	usernameTF.setText(b.getUsername());
    	zipCodeTF.setText(b.getZipCode());
    }
    
    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
   
    /**
     * Called when the user clicks on the validation button.
     */
    @FXML
    private void handleValidateBuyerModification() {
    	if (isInputValid()) {
         ApplicationFacade.getInstance().updateBuyer(usernameTF.getText(),emailTF.getText(),passwordTF.getText(),phoneNumberTF.getText(),zipCodeTF.getText());
         AlertBox.showAlert("Your informations changed. You need to reauthentificate yourself", "Update succeed","Update notification");
         okClicked = true;
         dialogStage.close();
         ApplicationFacade.getInstance().logOff();
         MainStage.showView();
    	}
    }
    
    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
}
