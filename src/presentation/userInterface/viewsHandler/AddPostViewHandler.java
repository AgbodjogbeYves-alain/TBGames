package presentation.userInterface.viewsHandler;

import java.io.IOException;
import java.util.Optional;

import application.ApplicationFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
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
	Optional<String> item = null;

	/**
	 * Handle action on cancel button : return to previous page
     */
	public void handlecancelAction() {
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

	/**
	 * Return a post from the DB by his idHandle action on validation button : If item null, add an item, if not, create the post.
     * @param event
     */
	public void handlevalidateAction(ActionEvent event) {
		String title = posttitleTF.getText();
		String description = descriptionTF.getText();
		int price = Integer.parseInt(priceTF.getText());
		boolean demand = demandCB.isSelected();
		if(demand && item==null) {
			TextInputDialog dialog = new TextInputDialog("Video Game");
			dialog.setTitle("Item Choice");
			dialog.setHeaderText("Please enter the item.");
			dialog.setContentText("Item name:");

			Optional<String> result = dialog.showAndWait();
			this.item = result;

		} else if (demand && ApplicationFacade.getInstance().isBuyer()) {
			ApplicationFacade.getInstance().CreatePostDemand(title, description, price, "Demand",item);
			PostViewHandler.setPost(title, description, price, "Demand",item);
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainStage.class.getResource("userInterface/fxml/PostView.fxml"));
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
	}

}
