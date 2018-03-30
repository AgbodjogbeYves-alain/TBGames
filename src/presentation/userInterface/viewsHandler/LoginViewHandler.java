package presentation.userInterface.viewsHandler;

import java.io.IOException;

import application.Actor;
import application.ApplicationFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import presentation.MainStage;
import presentation.userInterface.helper.AlertBox;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class LoginViewHandler{

	/**
	 * 
	 */
	@FXML private TextField usernameTF;


	/**
	 * 
	 */
	@FXML private PasswordField passwordTF;
	public Label msg = new Label();

	/**
	 * 
	 * @param event
	 */
	@FXML
	private void handlelogAction(ActionEvent event) {
		//Faire les tests editor, buyer,administrator ici. Pour chaque if faire la redirection ad�quate
		

		if (ApplicationFacade.getInstance().login(usernameTF.getText(),passwordTF.getText())) {
			FXMLLoader loader = new FXMLLoader();
    		AnchorPane view;
    		
    		String userType = ApplicationFacade.getInstance().getActorType(((Actor)ApplicationFacade.getInstance().getConnectedUser()));
    		switch (userType) {
			case "Administrator" : 
				loader.setLocation(MainStage.class.getResource("userInterface/fxml/HomeViewAdministrators.fxml"));
				MainStage.getPrimaryStage().setTitle("May the wisdom shine through you "+ userType );
				break;

			case "Editor" : 
				loader.setLocation(MainStage.class.getResource("userInterface/fxml/HomeViewEditor.fxml"));
				MainStage.getPrimaryStage().setTitle("May the odds be in your favor "+ userType);
				break;

			case "Buyer" : 
				loader.setLocation(MainStage.class.getResource("userInterface/fxml/HomeViewBuyer.fxml"));
				MainStage.getPrimaryStage().setTitle("Let's be brave "+ userType);
				break;

			case "SuperAdmin":
				loader.setLocation(MainStage.class.getResource("userInterface/fxml/HomeViewSAdmin.fxml"));
				MainStage.getPrimaryStage().setTitle("May the force be with you " + userType );
				break;
		}    		
			try {
				view = (AnchorPane) loader.load();
				Scene scene = new Scene(view);
				MainStage.getPrimaryStage().setScene(scene);
				MainStage.getPrimaryStage().show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else {
			AlertBox.showAlert("Votre mot de passe ou login est invalide", "", "Echec de la connexion");
		}


	}

	/**
	 * 
	 * @param event
	 * @throws ClassNotFoundException
	 */
	@FXML
	private void handlesignupAction(ActionEvent event) throws ClassNotFoundException {
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
	
	/**
	 * 
	 * @param event
	 */
	@FXML
	private void handleLogout(ActionEvent event){
		ApplicationFacade.getInstance().logOff();
		MainStage.showView();
	}
}




