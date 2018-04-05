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
	 * Constructor
	 */
	public EditorCell() {
		this(null,null,null,null,null,null,null,null,false);
	}
	
	/**
	 * Constructor with parameters
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
	 * Get the id of the editor
	 * @return String
	 */
	public String getIdEd(){
		return idEditor.get();
	}
	
	/**
	 * Get the representative name of the editor
	 * @return representative name
	 */
	public String getRN(){
		return representativeName.get();
	}
	
	/**
	 * Get the status of the editor
	 * @return Boolean
	 */
	public boolean getValidation(){
		return validation.get();
	}
	
	/**
	 * Set the id of the editor in the cell
	 * @param idEditor : id of the editor
	 */
	public void setIdEd(String idEditor) {
		this.idEditor.set(idEditor);
	}
	
	/**
	 * Set the representative name to the cell
	 * @param rn
	 */
	public void setRN(String rn){
		this.representativeName.set(rn);
	}
	
	/**
	 * Set the status of the editor in the cell
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

