package persistence;

import java.util.ArrayList;

import application.Editor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class EditorDAO {
	ObservableList<Editor> editorData = FXCollections.observableArrayList();

	public abstract String getEditorId(String username, String pwd);

	public abstract Editor createById(String id);

	public abstract ObservableList<Editor> getAllEditors();
	
	public abstract void saveEditor(Editor editor);

	public abstract Editor getEditorById(String id);
}
