package presentation.userInterface.viewsHandler;

import java.io.IOException;
import java.util.Optional;

import application.Actor;
import application.ApplicationFacade;
import application.Post;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import presentation.MainStage;

public class PostViewHandler {
	private static Post post = null;
	@FXML private Label labelPost;
	@FXML private Label labelDescription;
	@FXML private Label labelItemType;
	@FXML private Label labelItemName;
	@FXML private Label labelPrice;
	@FXML private Button updateBTN;
	@FXML private Button cancelBTN;
	@FXML private Button deleteBTN;
	@FXML private CheckBox offerCB;
	@FXML private CheckBox demandCB;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	public void initialize() {
		labelPost.setText(post.getTitle());;
		labelDescription.setText(post.getDescription());
		labelItemType.setText("Not Mentioned");
		labelItemName.setText(post.getItem().get());
		labelPrice.setText(Integer.toString(post.getPrice()));
	}

	/**
	 * When the user fill the form on the dialogBox for the administrator, if he clicks on cancel the dialogBox close
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
     * Called when the user clicks on the delete button.
     */
	public void handledeleteAction() {
		ApplicationFacade.getInstance().DeletePostDemand(post);
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainStage.class.getResource("userInterface/fxml/LogInUserView.fxml"));
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
	 * When the user click on validate on the dialogBox for the edit
	 * 
	 */
	public void handleupdateAction() {
	}

	/**
	 * 
	 * @param title
	 * @param description
	 * @param price
	 * @param typePost
	 * @param item
	 */
	static void setPost(String title, String description, int price, String typePost,Optional<String> item) {
		String user = ((Actor) ApplicationFacade.getConnectedUser()).getIdActor();
		post = new Post(title,description,price,typePost,user,item);
	}
}
