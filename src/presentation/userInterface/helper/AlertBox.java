package presentation.userInterface.helper;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import presentation.MainStage;

public class AlertBox{

	public static void showAlert(String msg, String header,String title) {
		Alert alert = new Alert(AlertType.WARNING);
	    alert.initOwner(MainStage.getPrimaryStage());
	    alert.setTitle(title);
	    alert.setHeaderText(header);
	    alert.setContentText(msg);
	    alert.showAndWait();
	}
    
	
}
