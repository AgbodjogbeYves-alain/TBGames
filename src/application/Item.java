package application;

public abstract class Item {
	private String idItem;
	private String name;
	private int rating;
	private String user;
	private String consoleType;

	/**
	 * @param idItem
	 * @param name
	 * @param rating
	 * @param string
	 * @param idConsoleType
	 */
	public Item(String idItem, String name, int rating, String string, String idConsoleType) {
		super();
		this.setIdItem(idItem);
		this.name = name;
		this.rating = rating;
		this.setUser(string);
		this.setConsoleType(idConsoleType);
	}
	
	public Item(String name, String idConsoleType) {
		super();
		this.name = name;
		this.setConsoleType(idConsoleType);
	}
	
	public Item(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return
	 */
	public String getIdItem() {
		return idItem;
	}

	/**
	 * @param idItem
	 */
	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}

	/**
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param string
	 */
	public void setUser(String string) {
		this.user = string;
	}

	/**
	 * @return
	 */
	public String getConsoleType() {
		return consoleType;
	}

	/**
	 * @param idConsoleType
	 */
	public void setConsoleType(String idConsoleType) {
		this.consoleType = idConsoleType;
	}
}
