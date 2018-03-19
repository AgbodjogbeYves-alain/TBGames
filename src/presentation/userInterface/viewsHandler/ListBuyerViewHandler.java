package presentation.userInterface.viewsHandler;

import application.ApplicationFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import presentation.MainStage;

public class ListBuyerViewHandler {

	@FXML 
	private void handleaddbuyerAction (ActionEvent event) {
		MainStage.showView("AddBuyerView.fxml","Add Buyer");
	}
}
