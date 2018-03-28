package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Actor;
import application.Administrator;

public class ActorDAOPG extends ActorDAO {

	/**
	 * 
	 */
	@Override
	public Actor getActorById(String username, String pwd) {
		String query = "SELECT * FROM Actor WHERE username = '" + username + "'AND password = '"+ pwd + "';" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		try {
			queryResult.next();
			int i = 0;
			int nbColumns = queryResult.getMetaData().getColumnCount();
			ArrayList<String> r = new ArrayList<String>(nbColumns);
			while (i < nbColumns) {
				r.add(queryResult.getString(i + 1));
				i++;
			}
			Actor a = null ;
	    	if (r != null) {
	    		a = new Actor(r);
				i++;
	    	}
	        return a ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
	}

	/**
	 * 
	 */
	@Override
	public void deleteActor(String id) {
		String query = "DELETE FROM Actor WHERE idActor = '" + id +"';" ;
		PGDAOFactory.getConnector().executeQuery(query) ;
	}

}
