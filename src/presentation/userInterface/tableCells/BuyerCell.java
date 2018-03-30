package presentation.userInterface.tableCells;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BuyerCell extends SimpleUserCell{
	private final StringProperty idBuyer;
	
	/**
	 * Constructor
	 */
	public BuyerCell() {
		this(null,null,null,null, null,null,null);
	}
	
	/**
	 * Constructor with parameters
	 * @param idActor
	 * @param idSimpleUser
	 * @param idBuyer
	 * @param username
	 * @param email
	 * @param zipcode
	 * @param phoneNumber
	 */
	public BuyerCell(String idActor,String idSimpleUser,String idBuyer,String username, String email,String zipcode,String phoneNumber) {
		super(idActor, idSimpleUser, username, email, true, false, false, false, zipcode, phoneNumber);
		this.idBuyer = new SimpleStringProperty(idBuyer);
	}
	
	/**
	 * get Buyer ID
	 * @return
	 */
	public String getIdBuyer() {
		return idBuyer.get();
	}
	
	/**
	 * set Buyer ID
	 * @param idBuyer
	 */
	public void setIdBuyer(String idBuyer) {
		this.idBuyer.set(idBuyer);
	}
	
	/**
	 * 
	 * @return
	 */
	public StringProperty idEditorProperty() {
		return idBuyer;
	}
}
