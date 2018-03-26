package presentation.userInterface.viewsHandler;

import java.io.IOException;

import application.ApplicationFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import presentation.MainStage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class LoginViewHandler{
	
    @FXML private TextField usernameTF;

    @FXML private PasswordField passwordTF;
    public Label msg = new Label();
    
	@FXML
	private void handlelogAction(ActionEvent event) {
		if (ApplicationFacade.getInstance().login(usernameTF.getText(),passwordTF.getText())) {
			
    		System.out.println("Accepted");
    		try {
    			FXMLLoader loader = new FXMLLoader();
        		loader.setLocation(MainStage.class.getResource("userInterface/fxml/AddPostView.fxml"));
        		AnchorPane view;
        		view = (AnchorPane) loader.load();
        		Scene scene = new Scene(view);
        		MainStage.getPrimaryStage().setTitle("Administrator view");
        		MainStage.getPrimaryStage().setScene(scene);
        		MainStage.getPrimaryStage().show();
    		}catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    	}
    	else {
    		System.out.println("Refused");
    	}
		
		
	}
	
	@FXML
	private void handlesignupAction(ActionEvent event) throws ClassNotFoundException {
		//showView("Enregistrez-vous!","managePostView.fxml");
		try {
			FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainStage.class.getResource("userInterface/fxml/SignUpView.fxml"));
    		AnchorPane view;
    		view = (AnchorPane) loader.load();
    		Scene scene = new Scene(view);
    		MainStage.getPrimaryStage().setTitle("Sign up");
    		MainStage.getPrimaryStage().setScene(scene);
    		MainStage.getPrimaryStage().show();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}




