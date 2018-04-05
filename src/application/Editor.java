package application;

import java.util.ArrayList;

public class Editor extends User {
	private String idEditor;
	private String representativeName ;
	private boolean validation;
	
	
	/**
	 * Constructor of editor
	 */
	public Editor() {
		super();
	}
	
	/**
	 * Constructor of editor with parameters
	 * @param idActor : id of the actor
	 * @param idSU : id simple user
	 * @param idEditor : id editor
	 * @param username : username of the editor
	 * @param email : email of the editor
	 * @param password : password of the editor
	 * @param zipCode : zipCode of the editor
	 * @param phoneNumber : phoneNumber of the editor
	 * @param representativeName : representative name of the editor
	 * @param validation : the status of the editor
	 */
	public Editor(String idActor,String idSU,String idEditor, String username, String email, String password, String zipCode, String phoneNumber, String representativeName,boolean validation) {
		super(idActor,idSU,username,email,password,zipCode,phoneNumber);
		this.idEditor = idEditor;
		this.representativeName = representativeName;
		this.validation = validation;
	}
	
	/**
	 * Constructor of the editor without ids
	  * @param username : username of the editor
	 * @param email : email of the editor
	 * @param password : password of the editor
	 * @param zipCode : zipCode of the editor
	 * @param phoneNumber : phoneNumber of the editor
	 * @param representativeName : representative name of the editor
	 */
	public Editor(String username, String email, String password, String zipCode, String phoneNumber,String representativeName) {
		super(username,email,password,zipCode,phoneNumber);
		this.representativeName = representativeName;
		this.validation = false;
	}
	
	
	/**
	 * Constructor with all roles
	 * @param id :of the Editor
	  * @param username : username of the editor
	 * @param email : email of the editor
	 * @param password : password of the editor
	 * @param zipCode : zipCode of the editor
	 * @param phoneNumber : phoneNumber of the editor
	 * @param representativeName : representative name of the editor
	 * @param isAdmin : boolean put false
	 * @param isSA : boolean put false
	 * @param isEd : boolean put true
	 * @param isB : boolean put false
	 */
	public Editor(String id,String username, String email, String password, String zipCode, String phoneNumber,String representativeName,boolean validation,boolean isAdmin, boolean isSA, boolean isEd, boolean isB) {
		super(id,username,email,password,zipCode,phoneNumber,isAdmin,isSA,isEd,isB);
		this.representativeName = representativeName;
		this.validation = validation;
	}
	/**
	 * Change status of the editor
	 */
	public void changeValidate() {
		this.validation= !validation;
	}
	
	/**
	 * Change the representative name of the editor
	 * @param rn
	 */
	public void setRepresentativeName(String rn) {
		this.representativeName = rn;
	}
	
	/**
	 * Get the id of the editor
	 * @return String : id of the editor
	 */
	public String getIdEditor() {
		return this.idEditor;
	}
	

	/**
	 * Get the represenative name of the editor
	 * @return String  : the representative name of the editor
	 */
	public String getRepresentativeName() {
		return this.representativeName;
	}
	
	/**
	 * Get editor status
	 * @return boolean : status
	 */
	public boolean getValidation() {
		return this.validation;
	}
	
	/**
	 * Change status of the editor
	 * @param bool : the status to put
	 */
	public void setValidate(boolean bool) {
		this.validation = bool;
	}

	/**
	 * Change the id of the created editor
	 * @param id : to put
	 */
	public void setIdEditor(String id) {
		this.idEditor = id;
	}

}
