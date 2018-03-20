package presentation.userInterface.viewsHandler;

import application.ApplicationFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import presentation.MainStage;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpUserViewHandler {

	@FXML private TextField usernameTF;
	@FXML private TextField emailTF;
	@FXML private TextField zipcodeTF;
	@FXML private TextField phonenumberTF;
	@FXML private PasswordField passwordTF;
	@FXML private PasswordField confirmpasswordTF;
	
	@FXML
	private void handlecancelsignupAction (ActionEvent event) {
		MainStage.showView("LoginUserView.fxml","Login");
	}
	
	@FXML
	private void handleconfirmsignupAction (ActionEvent event) {
		// TODO: Manage add to db
	}
}
