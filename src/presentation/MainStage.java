package presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class MainStage extends Application {
	
	public static Stage mainStage = null;
	public String fxml = "";
	public static Stage dialogStage;
	
	@Override
	public void start(Stage stage) {
		mainStage = stage;
		mainStage.setResizable(false);
		mainStage.getIcons().add(new Image(MainStage.class.getResourceAsStream("images/iconTB.png")));
		showView();
	}
	
    
    /**
     * Shows the person overview inside the root layout. 
     */
    public static void showView() {
    		mainStage.setTitle("Welcome on TBGames!!");
    		// Load person overview.
    		
			try {
				FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainStage.class.getResource("userInterface/fxml/LoginUserView.fxml"));
	            AnchorPane view = (AnchorPane) loader.load();
				Scene scene1 = new Scene(view);
		        mainStage.setScene(scene1);
		        mainStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
		// Set person overview into the center of root layout.
		//rootLayout.setCenter(loginView);
    
       
    /**
     * Returns the main stage.
     * @return
     */
    public static Stage getPrimaryStage() {
        return mainStage;
    }
    
    
   

    public static void launcher(String[] args) {
    	launch(args);
    }

	public static void main(String[] args) {
		
		launcher(args);
	}
}

