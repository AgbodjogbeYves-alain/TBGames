package presentation.userInterface.tableCells;

import application.Actor;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SimpleUserCell extends ActorCell{
	private StringProperty idSimpleUser;
	private StringProperty zipcode;
	private StringProperty phoneNumber;
	
	public SimpleUserCell() {
		this(null,null,null,null,false,false,false,false,null,null);
	}
	
	public SimpleUserCell(String idActor,String idSimpleUser,String username, String email,boolean isBuyer, boolean isAdministrator, boolean isEditor,
			boolean isSuperAdmin,String zipcode,String phoneNumber) {
		
		super(idActor,username,email,isBuyer,isAdministrator,isEditor,isSuperAdmin);
		this.zipcode = new SimpleStringProperty(zipcode);
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
		this.idSimpleUser = new SimpleStringProperty(idSimpleUser);
	}
	
	public String getZipCode() {
		return zipcode.get();
	}
	public String getPhoneNumber() {
		return phoneNumber.get();
	}
	
	public String getIdSU(){
		return idSimpleUser.get();
	}
	
	public void setZipCode(String zip) {
		this.zipcode.set(zip);
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.set(phoneNumber);
	}
	
	public StringProperty zipCProperty() {
		return zipcode;
	}
	
	public StringProperty phoneNumberProperty() {
		return phoneNumber;
	}
}
