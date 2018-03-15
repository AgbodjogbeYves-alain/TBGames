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
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setResizable(false);
        this.primaryStage.setTitle("Welcome on TBGames app!!");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../../images/iconTB.png")));
        //initRootLayout(null);
        
        showView();
	}
	
    /**
     * Shows the person overview inside the root layout.
     */
    public void showView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(loginViewHandler.class.getResource("../fxml/loginUserView.fxml"));
            AnchorPane loginView = (AnchorPane) loader.load();
            Scene scene = new Scene(loginView);
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
	
	/**
     * @return
     */
    public String login() {
        // TODO implement here
        return "";
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




