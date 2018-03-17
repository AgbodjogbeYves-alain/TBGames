package presentation.userInterface.viewsHandler;
	
import java.io.IOException;

import application.ApplicationFacade;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import presentation.MainStage;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class loginViewHandler extends Application{
	
	private Stage loginStage;
    @FXML private TextField usernameTF;

    @FXML private PasswordField passwordTF;
    public Label msg = new Label();
    


	@FXML
	private void handlelogAction(ActionEvent event) {
		if (ApplicationFacade.getInstance().login(usernameTF.getText(),passwordTF.getText())) {
    		System.out.println("Accepted");
    		FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainStage.class.getResource("userInterface/fxml/loginUserView.fxml"));
			AnchorPane view;
			try {
				view = (AnchorPane) loader.load();
				Scene scene = new Scene(view);
				MainStage.setStageAttribute(scene, "zz");
				MainStage.launcher(null);
				
			} catch (IOException e) {
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
		loginStage.close();
		//showView("Enregistrez-vous!","managePostView.fxml");
		System.out.println("ta mère");
	}
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getloginStage() {
        return loginStage;
    }
	
    public void setStage(Stage stage) {
    	this.loginStage = stage;
    }
	public static void main(String[] args) throws IOException {
			
        
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}




