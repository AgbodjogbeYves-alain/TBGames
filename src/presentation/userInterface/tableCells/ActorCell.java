package presentation.userInterface.tableCells;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ActorCell {
	
	private StringProperty idActor ;
	private StringProperty username ;
	private StringProperty email ; 
	private StringProperty password ;
	private BooleanProperty isBuyer;
	private BooleanProperty isAdministrator;
	private BooleanProperty isEditor;
	private BooleanProperty isSuperAdmin;
	
	public ActorCell() {
		this(null,null,null,false,false,false,false);
	}
	
	public ActorCell(String id,String username, String email,boolean isBuyer, boolean isAdministrator, boolean isEditor,
			boolean isSuperAdmin) {
		
		this.username = new SimpleStringProperty(username);
		this.idActor = new SimpleStringProperty(id);
		this.email = new SimpleStringProperty(email);
		this.isBuyer = new SimpleBooleanProperty(isBuyer);
		this.isAdministrator = new SimpleBooleanProperty(isAdministrator);
		this.isEditor = new SimpleBooleanProperty(isEditor);
		this.isSuperAdmin = new SimpleBooleanProperty(isSuperAdmin);
		
	}
	
	public String getId() {
		return idActor.get();
	}
	public String getUN() {
		return username.get();
	}
	
	public String getEmail() {
		return email.get();
	}
	public boolean getIsBuyer() {
		return isBuyer.get();
	}
	
	public boolean getIsEditor() {
		return isEditor.get();
	}
	public boolean getIsSuperAdmin() {
		return isSuperAdmin.get();
	}
	
	
	public void setUsername(String name) {
		this.username.set(name);
	}
	public void setEmail(String email) {
		this.email.set(email);
	}
	
	
	
	public StringProperty usernameProperty() {
		return username;
	}
	public StringProperty emailProperty() {
		return email;
	}

}
