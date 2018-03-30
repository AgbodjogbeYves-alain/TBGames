package presentation.userInterface.helper;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
    
	public static String showAlertYesNo(String msg, String header,String title) {
		String result = null;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.initOwner(MainStage.getPrimaryStage());
	    alert.setTitle(title);
	    alert.setHeaderText(header);
	    alert.setContentText(msg);
	    // option != null.
	    Optional<ButtonType> option = alert.showAndWait();
	 System.out.println(option);
		if (option.get() == ButtonType.OK) {
	       result = "yes";
	    } else if (option.get() == ButtonType.NO) {
	    	result = "no";
	        alert.close();
	    }
		
		return result;
	}
	
}
