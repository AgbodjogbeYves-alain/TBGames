package presentation.userInterface.viewsHandler;

import java.util.ArrayList;

import application.ApplicationFacade;
import application.Administrator;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ListAdministratorsViewHandler {
	@FXML private TableView tableView;
	private ObservableList<Administrator> admins ;
	
	@FXML
	protected void initialize(){
		admins = ApplicationFacade.loadAdministratorsList() ;
		for (int i = 0 ; i<admins.size() ; i++) {
			// THE RIGHT WAY TO IMPLEMENT : http://code.makery.ch/library/javafx-8-tutorial/part2/
			tableView.setItems(admins);
		}
		
	}

}
