package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;

import application.*;

public class GameDAOPG extends GameDAO {

	private static String fieldsToInsert = "(nameItem,ratingItem, idUser, consoleType, description, gameCategory)";

	/**
	 * Default constructor
	 */
	public GameDAOPG() {

	}

	/**
	 * @param game
	 */
	public void save(Game game) {
		String name = game.getName();
		int rating = game.getRating();
		User user = game.getUser();
		ConsoleType consoleType = game.getConsoleType();
		String description = game.getDescription();
		Category category = game.getCategory();
		String query = "INSERT INTO Game" + fieldsToInsert + " VALUES (" + name + "," + rating + "," + user.getIdActor()
				+ "," + consoleType.getIdConsoleType() + "," + description + "," + category + ");";
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query);
	}

	/**
	 * @param oldGame
	 * @param newGame
	 */
	public void update(Game oldGame, Game newGame) {
		String name = newGame.getName();
		int rating = newGame.getRating();
		User user = newGame.getUser();
		ConsoleType consoleType = newGame.getConsoleType();
		String description = newGame.getDescription();
		Category category = newGame.getCategory();
		String query = "UPDATE TABLE Game SET " + fieldsToInsert + " = (" + name + "," + rating + "," + user.getIdActor()
				+ "," + consoleType.getIdConsoleType() + "," + description + "," + category + ") WHERE idGame = "
				+ oldGame.getIdGame() + ";";
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query);
	}

	/**
	 * @param game
	 */
	public void delete(Game game) {
		String query = "DELETE FROM game WHERE idGame = "+game.getIdGame() ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query);
	}

	/**
	 * @return
	 */
	public ArrayList<Game> getAll() {
		ArrayList<Game> gameList = new ArrayList<Game>() ;
		//TODO Implementation
		return gameList;
	}

	/**
	 * @param gameId
	 * @return
	 */
	public ArrayList<Game> getById(String gameId) {
		//TODO
		return null ;
	}

	/**
	 * @param gameName
	 * @return
	 */
	public ArrayList<Game> getByName(String gameName) {
		//TODO 
		return null;
	}
}
