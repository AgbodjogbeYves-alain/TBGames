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
import presentation.MainStage;

public class EditGameViewHandler {
	@FXML private TextField gameTitle;
	@FXML private TextField descriptionGame;
	@FXML private ChoiceBox categoriesGame;
	@FXML private ChoiceBox consoleTypeGame;
	@FXML private TextField imagePath;
	@FXML private Button browse;

	
	public void handlecancelAction(ActionEvent event) {
		System.out.println("ok");
		try {
			FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainStage.class.getResource("userInterface/fxml/EditGameView.fxml"));
    		AnchorPane view;
    		view = (AnchorPane) loader.load();
    		Scene scene = new Scene(view);
    		MainStage.getPrimaryStage().setTitle("Add game view");
    		MainStage.getPrimaryStage().setScene(scene);
    		MainStage.getPrimaryStage().show();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void handlevalidateAction(ActionEvent event) {
		String title = gameTitle.getText();
		String description = descriptionGame.getText();
		String categories = categoriesGame.getText();
		String consoleType = consoleTypeGame.getValue().toString();
		

			ApplicationFacade.getInstance().CreateGame(title, description);
			try {
				FXMLLoader loader = new FXMLLoader();
	    		loader.setLocation(MainStage.class.getResource("userInterface/fxml/EditGameView.fxml"));
	    		AnchorPane view;
	    		view = (AnchorPane) loader.load();
	    		Scene scene = new Scene(view);
	    		MainStage.getPrimaryStage().setTitle("Edit game view");
	    		MainStage.getPrimaryStage().setScene(scene);
	    		MainStage.getPrimaryStage().show();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

}
