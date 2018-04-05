package persistence;

import java.util.ArrayList;

import application.*;

public abstract class GameDAO {

	/**
	 * Save a game
	 * @param game to save
	 */
	public abstract void save(Game game);

	/**
	 * Update a game
	 * @param idItem the game that we want to modify
	 * @param newGame the new values of the game
	 */
	public abstract void update(String idItem, Game newGame);

	/**
	 * Method to delete a game
	 * @param game to delete
	 */
	public abstract void delete(Game game);

	/**
	 * Get all the game that are in the dataBase
	 * @return ArrayList the games
	 */
	public abstract ArrayList<Game> getAll();

	/**
	 * Get a game by his id
	 * @param gameId : the id of the game
	 * @return ArrayList list of games
	 */
	public abstract ArrayList<Game> getById(String gameId);

	/**
	 * Get a game by his name
	 * @param gameName : the name of the game
	 * @return the game
	 */
	public abstract ArrayList<Game> getByName(String gameName);
	
	/**
	 * Get all the users games
	 * @param userId : id of the user
	 * @return ArrayList of games
	 */
	public abstract ArrayList<Game> getByUserId(String userId); 
}
