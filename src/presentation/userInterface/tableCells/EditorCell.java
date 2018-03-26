package presentation.userInterface.tableCells;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EditorCell extends SimpleUserCell{

	private final StringProperty idEditor;
	private final BooleanProperty validation;
	private final StringProperty representativeName;


	
	public EditorCell() {
		this(null,null,null,null,null,null,null,null,false);
	}
	
	public EditorCell(String idActor,String idSimpleUser,String idEditor,String username, String email,String zipcode,String phoneNumber,String representativeName, boolean validation) {
		super(idActor,idSimpleUser,username,email,false,false,true,false,zipcode,phoneNumber);
		this.idEditor = new SimpleStringProperty(idEditor);
		this.representativeName = new SimpleStringProperty(representativeName);
		this.validation = new SimpleBooleanProperty(validation);
	}
	
	public String getIdEd(){
		return idEditor.get();
	}
	public String getRN(){
		return representativeName.get();
	}
	public boolean getIValidation(){
		return validation.get();
	}
	
	public void setIdEd(String idEditor) {
		this.idEditor.set(idEditor);
	}
	
	public void setRN(String rn){
		this.representativeName.set(rn);
	}
	public void setValidation(boolean validation){
		this.validation.set(validation);
	}
	
	public StringProperty representativeNameProperty() {
		return representativeName;
	}
	
	public BooleanProperty validationProperty() {
		return validation;
	}
	public StringProperty idEditorProperty() {
		return idEditor;
	}
	
}

