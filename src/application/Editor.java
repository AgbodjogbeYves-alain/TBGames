package application;

import java.util.ArrayList;

public class Editor extends User {
	String idEditor;
	String representativeName ;
	boolean validate;
	
	
	
	public Editor() {
		super();
	}
	
	public Editor(String idActor,String idSU,String idEditor, String username, String email, String password, String zipCode, String phoneNumber, String representativeName) {
		super(idActor,idSU,username,email,password,zipCode,phoneNumber);
		this.idEditor = idEditor;
		this.representativeName = representativeName;
		this.validate = false;
	}
	
	public Editor(String username, String email, String password, String zipCode, String phoneNumber,String representativeName) {
		super(username,email,password,zipCode,phoneNumber);
		this.representativeName = representativeName;
		this.validate = false;
	}
	
	public void changeValidate() {
		this.validate = !validate;
	}
	
	public Editor(ArrayList queryResult) {
		super(queryResult);
    	this.representativeName = (String) queryResult.get(7);
		this.validate = (boolean) queryResult.get(8);
    }
	
	public void setRepresentativeName(String rn) {
		this.representativeName = rn;
	}
	
	public String getRepresentativeName() {
		return this.representativeName;
	}
	
	public void setValidate(boolean bool) {
		this.validate = bool;
	}

	public void setIdEditor(String id) {
		this.idEditor = id;
	}

	public void setIdActor(String idActor) {
		// TODO Auto-generated method stub
		
	}
}
