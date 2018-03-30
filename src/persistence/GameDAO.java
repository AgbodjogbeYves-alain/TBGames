package persistence;

import java.util.ArrayList;

import application.*;

public abstract class GameDAO {

	/**
	 * @param game
	 */
	public abstract void save(Game game);

	/**
	 * @param oldGame
	 * @param newGame
	 */
	public abstract void update(String idItem, Game newGame);

	/**
	 * @param game
	 */
	public abstract void delete(Game game);

	/**
	 * @return
	 */
	public abstract ArrayList<Game> getAll();

	/**
	 * @param gameId
	 * @return
	 */
	public abstract ArrayList<Game> getById(String gameId);

	/**
	 * @param gameName
	 * @return
	 */
	public abstract ArrayList<Game> getByName(String gameName);

}
