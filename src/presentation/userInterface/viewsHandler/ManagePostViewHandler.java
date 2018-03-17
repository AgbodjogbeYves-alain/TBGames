package presentation.userInterface.viewsHandler;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ManagePostViewHandler extends Application {
	@FXML private TextField usernameTF;
	@FXML private Button validateBTN;
	@FXML private Button cancelBTN;
	
	@Override
	public void start(Stage primaryStage) {
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
