package presentation.userInterface.viewsHandler;

import java.io.IOException;

import application.ApplicationFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import presentation.MainStage;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SignUpEditorViewHandler {

	@FXML private TextField usernameTF;
	@FXML private TextField emailTF;
	@FXML private TextField representativeNameTF;
	@FXML private TextField zipCodeTF;
	@FXML private TextField phoneNumberTF;
	@FXML private PasswordField passwordTF;
	@FXML private PasswordField confirmpasswordTF;
	
	/**
	 * When the user click on the cancel button on the panel
	 */
	@FXML
	private void handlecancelsignupAction() {
		MainStage.showView();
	}
	
	/**
	 * When the user click on the cancel button on the panel
	 */
	@FXML
	private void handleconfirmsignupAction() {
		String username = usernameTF.getText();
		String email = emailTF.getText();
		String representativeName = representativeNameTF.getText();
		String zipCode = zipCodeTF.getText();
		String phoneNumber = phoneNumberTF.getText();
		String password = passwordTF.getText();
		String cpassword = passwordTF.getText();
		if (password.equals(cpassword)) {
			ApplicationFacade.getInstance().SignUpEditor(username, email, password, zipCode, phoneNumber,representativeName);
			MainStage.showView();
		}
	}
}
