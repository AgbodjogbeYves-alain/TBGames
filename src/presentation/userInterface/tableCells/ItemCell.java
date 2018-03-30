package presentation.userInterface.tableCells;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

public class ItemCell {
	private StringProperty name;
	private IntegerProperty rating;
	private StringProperty consoleType;

	/**
	 * @param idItem
	 * @param name
	 * @param rating
	 * @param consoleType
	 */
	public ItemCell(String name, int rating, String consoleType) {
		super();
		this.name = new SimpleStringProperty(name);
		this.rating = new SimpleIntegerProperty(rating);
		this.consoleType = new SimpleStringProperty(consoleType);
	}

	/**
	 * @return
	 */
	public StringProperty getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(StringProperty name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public IntegerProperty getRating() {
		return rating;
	}

	/**
	 * @param rating
	 */
	public void setRating(IntegerProperty rating) {
		this.rating = rating;
	}

	/**
	 * @return
	 */
	public StringProperty getConsoleType() {
		return consoleType;
	}

	/**
	 * @param consoleType
	 */
	public void setConsoleType(StringProperty consoleType) {
		this.consoleType = consoleType;
	}

}
