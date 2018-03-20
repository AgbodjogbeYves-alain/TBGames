package presentation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class MainStage extends Application {
	
	public static Stage mainStage = null;
	public String fxml = "";
	
	

	
	@Override
	public void start(Stage stage) {
		mainStage = stage;
		mainStage.setResizable(false);
        showView("","");
	}
	
    /**
     * Shows the person overview inside the root layout.
     * @param string 
     * @param title 
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    public static void showView(String fxml, String title) {
    	if(title != "") {
    		FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainStage.class.getResource("userInterface/fxml/"+fxml));
    		AnchorPane view;
			try {
				view = (AnchorPane) loader.load();
				Scene scene = new Scene(view);
	    		mainStage.setTitle(title);
	    		mainStage.setScene(scene);
	    		mainStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    	}else if(title == ""){
    		mainStage.getIcons().add(new Image(MainStage.class.getResourceAsStream("images/iconTB.png")));
    		mainStage.setTitle("Welcome on TBGames!!");
    		// Load person overview.
			try {
				FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainStage.class.getResource("userInterface/fxml/LoginUserView.fxml"));
	            AnchorPane view = (AnchorPane) loader.load();
				Scene scene = new Scene(view);
		        mainStage.setScene(scene);
		        mainStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
            
            
    	}
		// Set person overview into the center of root layout.
		//rootLayout.setCenter(loginView);
    }
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return mainStage;
    }
    
    public void closeMainStage() {
    	mainStage.close();
    }

    public static void launcher(String[] args) {
    	launch(args);
    }

	public static void main(String[] args) {
		
		launcher(args);
	}
}
