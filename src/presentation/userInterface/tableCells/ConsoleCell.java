package presentation.userInterface.tableCells;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ConsoleCell extends ItemCell{
	private StringProperty idConsole;
	
	public ConsoleCell() {
		this(null,null,0,null,null,null);
	}
	
	public ConsoleCell(String id,String name, int ratingItem,String idUser, String consoleType, String idC) {
		
		super(id,name,ratingItem,idUser,consoleType);
		this.idConsole = new SimpleStringProperty(idC);
	}
	
	public String getIdGame() {
		return idConsole.get();
	}
	
	public void setIdConsole(String id) {
		this.idConsole.set(id);
	}
	
	public StringProperty idConsoleProperty() {
		return idConsole;
	}
}
