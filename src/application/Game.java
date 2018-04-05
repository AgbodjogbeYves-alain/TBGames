package application;

public class Game extends Item {
	private String idGame;
	private String description;
	private String category;

	/**
	 * @param idItem
	 * @param name
	 * @param rating
	 * @param idUser
	 * @param consoleType
	 * @param idGame
	 * @param description
	 * @param category
	 */
	public Game(String idItem, String name, int rating, String idUser, String consoleType, String idGame,
			String description, String category) {
		super(idItem, name, rating, idUser, consoleType);
		this.idGame = idGame;
		this.description = description;
		this.category = category;
		}
	
	public Game(String name, String description, String consoleType, String category) {
		super(name, consoleType);
		this.description = description;
		this.category = category;
		}
		
		public Game(String name, String description) {
			super(name);
			this.description = description;
	}

	/**
	 * @return idGame
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
	 * @return description
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
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

}
