package persistence;

import java.util.ArrayList;

import application.Editor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public interface EditorDAO {
	ObservableList<Editor> editorData = FXCollections.observableArrayList();

	public String getEditorId(String username, String pwd);

	public Editor createById(String id);

	public ObservableList<Editor> getAllEditors();
}
