package presentation.userInterface.viewsHandler;
	
import java.io.IOException;

import application.ApplicationFacade;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;


public class loginViewHandler extends Application {
	
	private Stage primaryStage;
    @FXML private TextField usernameTF;
    @FXML private TextField passwordTF;
    
    public Label msg = new Label();
    
	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException {
		this.primaryStage = primaryStage;
		this.primaryStage.setResizable(false);
        
       
        //initRootLayout(null);
        
        showView("Welcome on TBGames","loginUserView.fxml");
	}
	
    /**
     * Shows the person overview inside the root layout.
     * @throws ClassNotFoundException 
     */
    public void showView(String msg, String fxml) throws ClassNotFoundException {
        try {
        	
        	this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../../images/iconTB.png")));
            this.primaryStage.setTitle(msg);
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            
            loader.setLocation(getClass().getResource("../fxml/"+fxml));
            AnchorPane view = (AnchorPane) loader.load();
            Scene scene = new Scene(view);
            
            primaryStage.setScene(scene);
          	primaryStage.show();
            // Set person overview into the center of root layout.
            //rootLayout.setCenter(loginView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }	
    


	@FXML
	private void handlelogAction(ActionEvent event) {
		if (ApplicationFacade.getInstance().login(usernameTF.getText(),passwordTF.getText())) {
    		msg.setText("Accepted");
    	}
    	else {
    		msg.setText("Refused");
    	}
	}
	
	@FXML
	private void handlesignupAction(ActionEvent event) throws ClassNotFoundException {
		
		showView("Enregistrez-vous!","signUpView.fxml");
	}
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}




