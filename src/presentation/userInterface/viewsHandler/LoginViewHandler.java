package presentation.userInterface.viewsHandler;

import application.ApplicationFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import presentation.MainStage;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginViewHandler{
	
    @FXML private TextField usernameTF;

    @FXML private PasswordField passwordTF;
    public Label msg = new Label();
    


	@FXML
	private void handlelogAction(ActionEvent event) {
		if (ApplicationFacade.getInstance().login(usernameTF.getText(),passwordTF.getText())) {
    		System.out.println("Accepted");
			MainStage.showView("ManagePostView.fxml","ManagePost");
			
    	}
    	else {
    		System.out.println("Refused");
    	}
		
		
	}
	
	@FXML
	private void handlesignupAction(ActionEvent event) throws ClassNotFoundException {
		//showView("Enregistrez-vous!","managePostView.fxml");
		MainStage.showView("SignUpView.fxml","Sign Up");
	}
}




