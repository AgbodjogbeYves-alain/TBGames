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
	
	@FXML
	private void handlecancelsignupAction(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainStage.class.getResource("userInterface/fxml/LoginUserView.fxml"));
    		AnchorPane view;
    		view = (AnchorPane) loader.load();
    		Scene scene = new Scene(view);
    		MainStage.getPrimaryStage().setTitle("Login");
    		MainStage.getPrimaryStage().setScene(scene);
    		MainStage.getPrimaryStage().show();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void handleconfirmsignupAction(ActionEvent event) {
		String username = usernameTF.getText();
		String email = emailTF.getText();
		String representativeName = representativeNameTF.getText();
		String zipCode = zipCodeTF.getText();
		String phoneNumber = phoneNumberTF.getText();
		String password = passwordTF.getText();
		String cpassword = passwordTF.getText();
		if (password.equals(cpassword)) {
			ApplicationFacade.getInstance().SignUpEditor(username, email, password, zipCode, phoneNumber,representativeName);
			try {
				FXMLLoader loader = new FXMLLoader();
	    		loader.setLocation(MainStage.class.getResource("userInterface/fxml/LoginUserView.fxml"));
	    		AnchorPane view;
	    		view = (AnchorPane) loader.load();
	    		Scene scene = new Scene(view);
	    		MainStage.getPrimaryStage().setTitle("Login");
	    		MainStage.getPrimaryStage().setScene(scene);
	    		MainStage.getPrimaryStage().show();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
		
		}
	}
}
