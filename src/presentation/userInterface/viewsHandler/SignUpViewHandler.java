package presentation.userInterface.viewsHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import presentation.MainStage;

public class SignUpViewHandler {

	@FXML
	private void handlesignupeditorAction (ActionEvent event) {
		MainStage.showView("SignUpEditorView.fxml", "Sign Up as Editor");
	}
	
	@FXML
	private void handlesignupuserAction (ActionEvent event) {
		MainStage.showView("SignUpUserView.fxml", "Sign Up as User");
	}
}
