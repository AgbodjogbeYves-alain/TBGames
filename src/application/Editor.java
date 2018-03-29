package application;

import java.util.ArrayList;

public class Editor extends User {
	private String idEditor;
	private String representativeName ;
	private boolean validation;
	
	
	/**
	 * 
	 */
	public Editor() {
		super();
	}
	
	/**
	 * 
	 * @param idActor
	 * @param idSU
	 * @param idEditor
	 * @param username
	 * @param email
	 * @param password
	 * @param zipCode
	 * @param phoneNumber
	 * @param representativeName
	 * @param validation
	 */
	public Editor(String idActor,String idSU,String idEditor, String username, String email, String password, String zipCode, String phoneNumber, String representativeName,boolean validation) {
		super(idActor,idSU,username,email,password,zipCode,phoneNumber);
		this.idEditor = idEditor;
		this.representativeName = representativeName;
		this.validation = validation;
	}
	
	/**
	 * 
	 * @param username
	 * @param email
	 * @param password
	 * @param zipCode
	 * @param phoneNumber
	 * @param representativeName
	 */
	public Editor(String username, String email, String password, String zipCode, String phoneNumber,String representativeName) {
		super(username,email,password,zipCode,phoneNumber);
		this.representativeName = representativeName;
		this.validation = false;
	}
	
	
	/**
	 * 
	 * @param id
	 * @param username
	 * @param email
	 * @param password
	 * @param zipCode
	 * @param phoneNumber
	 * @param representativeName
	 * @param isAdmin
	 * @param isSA
	 * @param isEd
	 * @param isB
	 */
	public Editor(String id,String username, String email, String password, String zipCode, String phoneNumber,String representativeName,boolean validation,boolean isAdmin, boolean isSA, boolean isEd, boolean isB) {
		super(id,username,email,password,zipCode,phoneNumber,isAdmin,isSA,isEd,isB);
		this.representativeName = representativeName;
		this.validation = validation;
	}
	/**
	 * 
	 */
	public void changeValidate() {
		this.validation= !validation;
	}
	
	/**
	 * 
	 * @param rn
	 */
	public void setRepresentativeName(String rn) {
		this.representativeName = rn;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getIdEditor() {
		return this.idEditor;
	}
	

	/**
	 * 
	 * @return
	 */
	public String getRepresentativeName() {
		return this.representativeName;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getValidation() {
		return this.validation;
	}
	
	/**
	 * 
	 * @param bool
	 */
	public void setValidate(boolean bool) {
		this.validation = bool;
	}

	/**
	 * 
	 * @param id
	 */
	public void setIdEditor(String id) {
		this.idEditor = id;
	}

}
