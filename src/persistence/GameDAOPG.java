package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
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
		String user = game.getUser();
		String consoleType = game.getConsoleType();
		String description = game.getDescription();
		String category = game.getCategory();
		String query = "INSERT INTO Game" + fieldsToInsert + " VALUES (" + name + "," + rating + "," + user
				+ "," + consoleType + "," + description + "," + category + ");";
		int queryResult = PGDAOFactory.getConnector().executeUpdate(query);
	}

	/**
	 * @param oldGame
	 * @param newGame
	 */
	public void update(String idItem, Game newGame) {
		String name = newGame.getName();
		int rating = newGame.getRating();
		String user = newGame.getUser();
		String consoleType = newGame.getConsoleType();
		String description = newGame.getDescription();
		String category = newGame.getCategory();
		String query = "UPDATE TABLE Game SET " + fieldsToInsert + " = (" + name + "," + rating + "," + user
				+ "," + consoleType + "," + description + "," + category + ") WHERE idItem = "
				+ idItem + ";";
		int queryResult = PGDAOFactory.getConnector().executeUpdate(query);
	}

	/**
	 * @param game
	 */
	public void delete(Game game) {
		String query = "DELETE FROM game WHERE idGame = "+game.getIdGame() ;
		int queryResult = PGDAOFactory.getConnector().executeUpdate(query);
	}

	/**
	 * @return
	 */
	public ArrayList<Game> getAll() {
		ArrayList<Game> gameList = new ArrayList<Game>() ;
		//TODO Implementation
		String query = "SELECT * FROM game" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query);
		return gameList;
	}

	/**
	 * @param gameId
	 * @return
	 */
	public ArrayList<Game> getById(String gameId) {
		//TODO
		ArrayList<Game> gameList = new ArrayList<Game>() ;
		String query = "SELECT FROM game WHERE idGame = "+ gameId ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query);
		return gameList ;
	}

	/**
	 * @param gameName
	 * @return
	 */
	public ArrayList<Game> getByName(String gameName) {
		//TODO 
		ArrayList<Game> gameList = new ArrayList<Game>() ;
		String query = "SELECT FROM game WHERE name = "+ gameName ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query);
		return gameList;
	}
	
	/**
	 * @param gameName
	 * @return
	 */
	public ArrayList<Game> getByUserId(String userId) {
		//TODO 
		ArrayList<Game> gameList = new ArrayList<Game>() ;
		String query = "SELECT FROM game WHERE idUser = "+ userId ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query);
		try {
			while (queryResult.next()) {
				String idItem = queryResult.getString("idItem");
				String name = queryResult.getString("name");
				int rating = queryResult.getInt("rating");
				//UserDAO userdao = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin").getUserDAO();
				//User user = userdao.createById(queryResult.getString("idUser"));
				String idUser = queryResult.getString("idUser");
				String consoleType = queryResult.getString("consoleType");
				String idGame = queryResult.getString("idGame");
				String description = queryResult.getString("description");
				String category = queryResult.getString("category");
					
				Game g = new Game(idItem, name, rating, idUser, consoleType, idGame, description, category);
		    	gameList.add(g) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gameList;
	}


}
