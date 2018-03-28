package presentation.userInterface.tableCells;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EditorCell extends SimpleUserCell{

	private final StringProperty idEditor;
	private final BooleanProperty validation;
	private final StringProperty representativeName;


	/**
	 * 
	 */
	public EditorCell() {
		this(null,null,null,null,null,null,null,null,false);
	}
	
	/**
	 * 
	 * @param idActor
	 * @param idSimpleUser
	 * @param idEditor
	 * @param username
	 * @param email
	 * @param zipcode
	 * @param phoneNumber
	 * @param representativeName
	 * @param validation
	 */
	public EditorCell(String idActor,String idSimpleUser,String idEditor,String username, String email,String zipcode,String phoneNumber,String representativeName, boolean validation) {
		super(idActor,idSimpleUser,username,email,false,false,true,false,zipcode,phoneNumber);
		this.idEditor = new SimpleStringProperty(idEditor);
		this.representativeName = new SimpleStringProperty(representativeName);
		this.validation = new SimpleBooleanProperty(validation);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getIdEd(){
		return idEditor.get();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRN(){
		return representativeName.get();
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getValidation(){
		return validation.get();
	}
	
	/**
	 * 
	 * @param idEditor
	 */
	public void setIdEd(String idEditor) {
		this.idEditor.set(idEditor);
	}
	
	/**
	 * 
	 * @param rn
	 */
	public void setRN(String rn){
		this.representativeName.set(rn);
	}
	
	/**
	 * 
	 * @param validation
	 */
	public void setValidation(boolean validation){
		this.validation.set(validation);
	}
	
	/**
	 * 
	 * @return
	 */
	public StringProperty representativeNameProperty() {
		return representativeName;
	}
	
	/**
	 * 
	 * @return
	 */
	public BooleanProperty validationProperty() {
		return validation;
	}
	
	/**
	 * 
	 * @return
	 */
	public StringProperty idEditorProperty() {
		return idEditor;
	}
	
}

