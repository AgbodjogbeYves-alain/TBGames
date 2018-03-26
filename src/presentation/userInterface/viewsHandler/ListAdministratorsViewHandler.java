package presentation.userInterface.viewsHandler;


import application.ApplicationFacade;
import application.Administrator;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListAdministratorsViewHandler {
	
	@FXML TableView<Administrator> tableView ;
	@FXML TableColumn<Administrator, String> usernameCol;
	@FXML TableColumn<Administrator, String> emailCol;

	@FXML
	protected void initialize(){
		//admins = ApplicationFacade.loadAdministratorsList() ;
		// THE RIGHT WAY TO IMPLEMENT : http://code.makery.ch/library/javafx-8-tutorial/part2/
		usernameCol.setCellValueFactory(new PropertyValueFactory<Administrator, String>("username"));
		emailCol.setCellValueFactory(new PropertyValueFactory<Administrator, String>("email"));
		tableView. setItems(ApplicationFacade.loadAdministratorsList()) ;
	}
}
