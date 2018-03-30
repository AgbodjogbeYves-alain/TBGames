package presentation.userInterface.viewsHandler;

import java.io.IOException;

import application.ApplicationFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import presentation.MainStage;
import presentation.userInterface.helper.DialogBoxEditGame;

public class AddGameViewHandler {
	@FXML private TextField gameTitle;
	@FXML private TextField descriptionGame;
	@FXML private TextField imagePath;
	@FXML private Button browse;
	@FXML private Button chooseImage;
	
	 @FXML
	    private boolean handleAddGame() {
	    	
	    	try {
	            // Load the fxml file and create a new stage for the popup dialog.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainStage.class.getResource("userInterface/fxml/AddGameView.fxml"));
	            AnchorPane page = (AnchorPane) loader.load();

	            // Create the dialog Stage.
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Add Game");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(MainStage.getPrimaryStage());
	            Scene scene = new Scene(page);
	            dialogStage.setScene(scene);

	            // Set the person into the controller.
	            DialogBoxEditGame controller = loader.getController();
	            controller.setDialogStage(dialogStage);
//	            controller.setGame();

	            // Show the dialog and wait until the user closes it
	            dialogStage.showAndWait();
	            return controller.isOkClicked();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

}
