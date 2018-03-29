package application;

public abstract class Item {
	private String idItem;
	private String name;
	private int rating;
	private User user;
	private ConsoleType consoleType;

	/**
	 * @param idItem
	 * @param name
	 * @param rating
	 * @param user
	 * @param consoleType
	 */
	public Item(String idItem, String name, int rating, User user, ConsoleType consoleType) {
		super();
		this.setIdItem(idItem);
		this.name = name;
		this.rating = rating;
		this.setUser(user);
		this.setConsoleType(consoleType);
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
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return
	 */
	public ConsoleType getConsoleType() {
		return consoleType;
	}

	/**
	 * @param consoleType
	 */
	public void setConsoleType(ConsoleType consoleType) {
		this.consoleType = consoleType;
	}
}
