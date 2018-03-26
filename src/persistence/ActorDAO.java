package persistence;

import application.Actor;

public abstract class ActorDAO {

	public abstract Actor getActorById(String username, String pwd) ;

}
