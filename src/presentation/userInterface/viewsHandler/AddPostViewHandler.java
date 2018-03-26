package presentation.userInterface.viewsHandler;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import presentation.MainStage;

public class AddPostViewHandler {
	@FXML private TextField descriptionTF;
	@FXML private TextField priceTF;
	@FXML private TextField posttitleTF;
	@FXML private Button cancelBTN;
	@FXML private Button validateBTN;
	@FXML private CheckBox offerCB;
	@FXML private CheckBox demandCB;
	
	public void handlecancelAction(ActionEvent event) {
		System.out.println("ok");
		try {
			FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainStage.class.getResource("userInterface/fxml/LoginUserView.fxml"));
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
	
	public void handlevalidateAction(ActionEvent event) {
//		//String title = posttitleTF.getText();
//		System.out.println("ok");
//		System.out.println(posttitleTF.getText());
//		String description = descriptionTF.getText();
//		System.out.println(description);
//		String price = priceTF.getText();
//		System.out.println(price);
//		boolean demand = demandCB.isSelected();
		if(demandCB.isSelected()) {
			
			try {
				FXMLLoader loader = new FXMLLoader();
	    		loader.setLocation(MainStage.class.getResource("userInterface/fxml/AddDemandBuyerView.fxml"));
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
	}
}
