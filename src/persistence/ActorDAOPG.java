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
			if(queryResult.getMetaData().getColumnCount()>0) {
				queryResult.next();
				String id = queryResult.getString("idActor");
				String username1 = queryResult.getString("username");
				String email = queryResult.getString("email");
				String password = queryResult.getString("password");
				boolean isAdmin = queryResult.getBoolean("isAdministrator");
				boolean isEd = queryResult.getBoolean("isEditor");
				boolean isSA = queryResult.getBoolean("isSuperAdmin");
				boolean isB = queryResult.getBoolean("isBuyer");
				
				Actor a = new Actor(id, username1, email, password, isAdmin, isSA, isEd, isB);
		        return a ;
			}else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	
	@Override
	public void deleteActor(String id) {
		String query = "DELETE FROM Actor WHERE idActor = '" + id +"';" ;
		PGDAOFactory.getConnector().executeUpdate(query) ;
	}

}
