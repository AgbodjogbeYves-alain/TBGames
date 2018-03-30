package presentation.userInterface.tableCells;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GameCell extends ItemCell{
	private StringProperty description;
	private StringProperty category;
	
	public GameCell(String name, Integer rating, String consoleType) {
		super(name, rating, consoleType);
		// TODO Auto-generated constructor stub
	}

	public GameCell(String name, Integer rating, String consoleType, String description, String category) {
		super(name, rating, consoleType);
		this.description = new SimpleStringProperty(description);
		this.category = new SimpleStringProperty(category);
	}

	/**
	 * @return
	 */
	public StringProperty getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(StringProperty description) {
		this.description = description;
	}

	/**
	 * @return
	 */
	public StringProperty getCategory() {
		return category;
	}

	/**
	 * @param category
	 */
	public void setCategory(StringProperty category) {
		this.category = category;
	}
	
	
}
