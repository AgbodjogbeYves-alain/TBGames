package presentation.userInterface.helper;

import java.io.IOException;

import application.ApplicationFacade;
import application.Actor;
import application.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import presentation.MainStage;
import presentation.userInterface.viewsHandler.EditGameViewHandler;



public class DialogBoxEditGame {
	
	@FXML private TextField gameTitle;
	@FXML private TextField descriptionGame;
	@FXML private ChoiceBox categoriesGame;
	@FXML private ChoiceBox consoleTypeGame;
	@FXML private TextField imagePath;
	
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
    public void showEditDialog(Game game) {
        try {
        	
        	 // Initialize the person table with the two columns.
	    	Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit game");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainStage.getPrimaryStage());
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainStage.class.getResource("userInterface/fxml/EditGameView.fxml"));
            
            AnchorPane page = (AnchorPane) loader.load();
            Game gm = game;
            
            // Create the dialog Stage.
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            this.setGame(game); 

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

        if (gameTitle.getText() == null || gameTitle.getText().length() == 0) {
            errorMessage += "No valid game title!\n"; 
        }
        if (descriptionGame.getText() == null || descriptionGame.getText().length() == 0) {
            errorMessage += "No valid description!\n"; 
        }
        if (categoriesGame.getValue() == null) {
            errorMessage += "No valid category!\n"; 
        }

        if (consoleTypeGame.getValue() == null) {
            errorMessage += "No valid representative console type!\n"; 
        
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
     * @param game2 
     *
     */
    public void setGame(Game game2) {
    	
        gameTitle.setText(game2.getName());
    	descriptionGame.setText(game2.getDescription());
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
    private void handleValidateGameModification() {
    	if (isInputValid()) {
    	String idItem = ((Actor)ApplicationFacade.getInstance().getConnectedUser()).getIdActor();
    	 String idUser = ((Actor) ApplicationFacade.getInstance().getConnectedUser()).getIdActor();
         ApplicationFacade.getInstance().updateGame(idItem, gameTitle.getText(),descriptionGame.getText(), categoriesGame.getValue().toString(),consoleTypeGame.getValue().toString());
         AlertBox.showAlert("Your game's information changed.", "Update succeed","Update notification");
         okClicked = true;
         dialogStage.close();
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
