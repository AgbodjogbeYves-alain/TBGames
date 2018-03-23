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
		String username = usernameTF.getText();
		String email = emailTF.getText();
		String zipCode = zipcodeTF.getText();
		String phoneNumber = phonenumberTF.getText();
		String password = passwordTF.getText();
		String cPassword = confirmpasswordTF.getText();
		if(password == cPassword) {
			ApplicationFacade.getInstance().SignUpUser(username, email, password, zipCode, phoneNumber);
		}else{
			
		}
	}
}
