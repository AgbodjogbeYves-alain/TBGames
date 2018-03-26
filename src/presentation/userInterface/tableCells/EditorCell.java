package presentation.userInterface.tableCells;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EditorCell {

	private final StringProperty username;
	private final StringProperty representativeName;
	private final StringProperty phoneNumber;

	
	public EditorCell() {
		this(null,null);
	}
	
	public EditorCell(String username, String representativeName) {
		this.username = new SimpleStringProperty(username);
		this.representativeName = new SimpleStringProperty(representativeName);
	}
	
	public String getEditorUN() {
		return username.get();
	}
	public String getEditorRN() {
		return representativeName.get();
	}
	
	
	public void setEditorUN(String name) {
		this.username.set(name);
	}
	public void setEditorRN(String name) {
		this.representativeName.set(name);
	}
	
	
	public StringProperty usernameProperty() {
		return username;
	}
	public StringProperty representativenameProperty() {
		return representativeName;
	}

	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return null;
	}
}

