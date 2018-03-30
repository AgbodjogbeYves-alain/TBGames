package presentation.userInterface.tableCells;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GameCell extends ItemCell{

	private StringProperty idGame;
	private StringProperty description;
	private StringProperty gameCategory;
	
	public GameCell() {
		this(null,null,0,null,null,null,null);
	}
	
	public GameCell(String id,String name, int ratingItem,String idUser, String consoleType, String description, String gameCategory) {
		
		super(id,name,ratingItem,idUser,consoleType);
		this.description = new SimpleStringProperty(description);
		this.gameCategory = new SimpleStringProperty(gameCategory);
	}
	
	public String getIdGame() {
		return idGame.get();
	}
	public String getDescription() {
		return description.get();
	}
	
	public String getGameCategory(){
		return gameCategory.get();
	}
	
	public void setIdGame(String id) {
		this.idGame.set(id);
	}
	public void setDescription(String desc) {
		this.description.set(desc);
	}
	
	public StringProperty gameCategoryProperty() {
		return gameCategory;
	}
	
	public StringProperty idGameProperty() {
		return idGame;
	}
	
	public StringProperty descriptionProperty() {
		return description;
	}

}
