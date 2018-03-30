package persistence;

import java.util.ArrayList;

import application.Editor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import presentation.userInterface.tableCells.EditorCell;

public abstract class EditorDAO {
	public abstract String getEditorId(String username, String pwd);

	public abstract Editor createById(String id);

	public abstract ArrayList<Editor> getAllEditors();
	
	public abstract void saveEditor(Editor editor);

	public abstract Editor getEditorById(String id);

	public abstract void updateEditor(String idActor, String userNameEditor, String emailEditor, String passwordEditor,
			String zipCodeEditor, String phoneNumberEditor, String representativeNameEditor);
}
