package persistence;

import application.Actor;

public abstract class ActorDAO {

	/**
	 * 
	 * @param username
	 * @param pwd
	 * @return
	 */
	public abstract Actor getActorById(String username, String pwd) ;

	/**
	 * 
	 * @param id
	 */
	public abstract void deleteActor(String id);

}
