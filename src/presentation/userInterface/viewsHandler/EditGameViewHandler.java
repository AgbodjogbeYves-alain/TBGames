package presentation.userInterface.viewsHandler;

import java.io.IOException;

import application.ApplicationFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import presentation.MainStage;
import presentation.userInterface.helper.DialogBoxEditEditor;
import presentation.userInterface.helper.DialogBoxEditGame;

public class EditGameViewHandler {
	@FXML private TextField gameTitle;
	@FXML private TextField descriptionGame;
	@FXML private ChoiceBox categoriesGame;
	@FXML private ChoiceBox consoleTypeGame;
	@FXML private TextField imagePath;
	
	/**
     * Called when the user clicks on the edit button.
     * @return 
     */
    @FXML
    private boolean handleEditGame() {
    	
    	try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainStage.class.getResource("userInterface/fxml/EditGameView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Game");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(MainStage.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            DialogBoxEditGame controller = loader.getController();
            controller.setDialogStage(dialogStage);
//            controller.setGame();

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}
