package presentation.userInterface.viewsHandler;

import application.ApplicationFacade;
import application.Editor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class ManageEditorViewHandler {

	 private TableView<Editor> table = new TableView<Editor>();
	 private ObservableList<Editor> data = ApplicationFacade.getInstance().getAllEditors();
    /**
     * Constructor
     */
    public ManageEditorViewHandler() {
       
    }

//    /**
//     * Returns the data as an observable list of Persons. 
//     * @return
//     */
//    public ObservableList<Person> getPersonData() {
//        return personData;
//    }

}
