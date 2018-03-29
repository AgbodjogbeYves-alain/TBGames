package application;

public class Game extends Item {
	private String idGame;
	private String description;
	private Category category;

	/**
	 * @param idItem
	 * @param name
	 * @param rating
	 * @param user
	 * @param consoleType
	 * @param idGame
	 * @param description
	 * @param category
	 */
	public Game(String idItem, String name, int rating, User user, ConsoleType consoleType, String idGame,
			String description, Category category) {
		super(idItem, name, rating, user, consoleType);
		this.idGame = idGame;
		this.description = description;
		this.category = category;
		}
		
		public Game(String name, String description) {
			super(name);
			this.description = description;
	}

	/**
	 * @return
	 */
	public String getIdGame() {
		return idGame;
	}

	/**
	 * @param idGame
	 */
	public void setIdGame(String idGame) {
		this.idGame = idGame;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

}
