package persistence;

import java.util.ArrayList;

import application.Editor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import presentation.userInterface.tableCells.EditorCell;

public abstract class EditorDAO {
	/**
	 * Get an editor by is username and pwd in DB
	 * @param username : the username of the editor
	 * @param pwd : the password of the editor
	 * @return the id of the editor
	 */
	public abstract String getEditorId(String username, String pwd);

	/**
	 * Create an editor from the database
	 * @param id : of the editor
	 * @return the created editor
	 */
	public abstract Editor createById(String id);

	/**
	 * Get all editors
	 * @return ArrayList of editors
	 */
	public abstract ArrayList<Editor> getAllEditors();
	
	/**
	 * Get non validated editors
	 * @return ArrayList of editors
	 */
	public abstract ArrayList<Editor> getAllEditorsNV();
	
	/**
	 * Save an editor
	 * @param editor : the editor to save
	 */
	public abstract void saveEditor(Editor editor);

	/**
	 * Get an editor by his id
	 * @param id : the id of the editor
	 * @return the editor
	 */
	public abstract Editor getEditorById(String id);

	/**
	 * Update editor info
	 * @param idActor : id of the Actor
	 * @param userNameEditor : username of the editor
	 * @param emailEditor : email of the editor
	 * @param passwordEditor : password of the editor
	 * @param zipCodeEditor : zipCode of the editor
	 * @param phoneNumberEditor : phoneNumber of the editor
	 * @param representativeNameEditor : representative of the editor
	 */
	public abstract void updateEditor(String idActor, String userNameEditor, String emailEditor, String passwordEditor,
			String zipCodeEditor, String phoneNumberEditor, String representativeNameEditor);
	
	/**
	 * Validate an editor
	 * @param id : Id of the editor to validate
	 */
	public abstract void validateEditor(String id);
}
