package presentation.userInterface.tableCells;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemCell {
	private StringProperty idItem;
	private StringProperty nameItem ;
	private IntegerProperty ratingItem ; 
	private StringProperty idUser ;
	private StringProperty consoleType;
	
	public ItemCell() {
		this(null,null,0,null,null);
	}
	
	public ItemCell(String id,String name, int ratingItem,String idUser, String consoleType) {
		
		this.idItem = new SimpleStringProperty(id);
		this.nameItem = new SimpleStringProperty(name);
		this.ratingItem = new SimpleIntegerProperty(ratingItem);
		this.idUser = new SimpleStringProperty(idUser);
		this.consoleType = new SimpleStringProperty(consoleType);
		
	}
	
	public String getId() {
		return idItem.get();
	}
	public String getName() {
		return nameItem.get();
	}
	
	public int getRate() {
		return ratingItem.get();
	}
	
	public String getIdUser() {
		return idUser.get();
	}
	
	public String getConsoleType() {
		return consoleType.get();
	}
	
	
	public void setId(String id) {
		this.idItem.set(id);
	}
	
	public void setName(String name) {
		this.nameItem.set(name);
	}
	
	public void setRating(int rate) {
		this.ratingItem.set(rate);
	}
	
	public void setIdUser(String id) {
		this.nameItem.set(id);
	}
	
	public void setConsoleType(String ct) {
		this.nameItem.set(ct);
	}
	
	
	public StringProperty idProperty() {
		return this.idItem;
	}
	
	
	public StringProperty itemNameProperty() {
		return this.nameItem;
	}
	
	public IntegerProperty ratingProperty() {
		return this.ratingItem;
	}
	
	public StringProperty consoleTypeProperty() {
		return this.consoleType;
	}

	public StringProperty idUserProperty() {
		return this.idUser;
	}
	
}
