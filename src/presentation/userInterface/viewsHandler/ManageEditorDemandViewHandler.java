package presentation.userInterface.viewsHandler;

import java.io.IOException;

import application.ApplicationFacade;
import application.Editor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import presentation.MainStage;
import presentation.userInterface.helper.AlertBox;
import presentation.userInterface.tableCells.ActorCell;
import presentation.userInterface.tableCells.EditorCell;

public class ManageEditorDemandViewHandler {

	@FXML private TableView<EditorCell> tableViewEditorsNV;
	@FXML private TableColumn<EditorCell,String> representativeNameColumnEditor ;
	@FXML private TableColumn<EditorCell,String> nameColumnEditor ;
	@FXML private Label phoneNumberLabelEditor ;
	@FXML private Label emailLabelEditor ;
	@FXML private Label userNameLabelEditor;
	@FXML private Label representativeNameLabelEditor;
	@FXML private Label zipCodeLabelEditor;
	@FXML private Button deleteBTN;
	@FXML private Button validateBTN;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML public void initialize() {
		// Initialize the person table with the two columns.
		representativeNameColumnEditor.setCellValueFactory(cellData -> cellData.getValue().representativeNameProperty());
		nameColumnEditor.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());

		tableViewEditorsNV.setItems(ApplicationFacade.getInstance().getEditorsToValidList());
		// Clear person details.
		showEditorDetails(null);

		// Listen for selection changes and show the person details when changed.
		tableViewEditorsNV.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showEditorDetails(newValue));
	}

	/**
	 * Fills all text fields to show details about the Editor.
	 * If the specified person is null, all text fields are cleared.
	 *
	 * @param editor the editor or null
	 */
	private void showEditorDetails(EditorCell editor) {
		if (editor != null) {
			// Fill the labels with info from the person object.
			phoneNumberLabelEditor.setText(editor.getPhoneNumber());
			emailLabelEditor.setText(editor.getEmail());
			userNameLabelEditor.setText(editor.getUN());
			representativeNameLabelEditor.setText(editor.getRN());
			zipCodeLabelEditor.setText(editor.getZipCode());

		} else {
			// Person is null, remove all the text.
			phoneNumberLabelEditor.setText("");
			emailLabelEditor.setText("");
			userNameLabelEditor.setText("");
			representativeNameLabelEditor.setText("");
			zipCodeLabelEditor.setText("");
		}
	}


	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeleteEditor() {
		int selectedIndex = tableViewEditorsNV.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			String idActor = ApplicationFacade.getInstance().getEditorsToValidList().get(selectedIndex).getId();
			ApplicationFacade.getInstance().getEditorsToValidList().remove(selectedIndex);
			ApplicationFacade.getInstance().deleteActor(idActor);
			tableViewEditorsNV.getItems().remove(selectedIndex);
			AlertBox.showAlert("Delete succeed", "", "Editor deletion");

		} else {
			AlertBox.showAlert("", "", "");
		}
	}

	/**
	 * Called when the user clicks on the validate button.
	 */
	@FXML
	private void handleValidateEditor() {
		int selectedIndex = tableViewEditorsNV.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {

			String idActor = ApplicationFacade.getInstance().getEditorsToValidList().get(selectedIndex).getId();
			System.out.println(idActor);
			ApplicationFacade.getInstance().validateEditor(idActor);
			tableViewEditorsNV.getItems().remove(selectedIndex);
			AlertBox.showAlert("Validate succeed", "", "Editor validation");

		} else {
			AlertBox.showAlert("", "", "");
		}
	}

}

