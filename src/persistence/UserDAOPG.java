package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import application.*;

/**
 * 
 */
public class UserDAOPG extends UserDAO {

    /**
     * Default constructor
     */
    public UserDAOPG() {
    }
    
    /**
     * 
     */
    public User createById(String id) {
    	String query = "SELECT * FROM SimpleUser WHERE idSimpleUser = '" + id + "';" ;
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
			User u = null ;
	    	if (r != null) {
	    		u = new User(r) ;
	    	}
	        return u ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    	return null;
    	
    }

	@Override
	/**
	 * return : null if User is not in the database
	 */
	public String getUserId(String username, String pwd) {
		String id = null ;
		String query = "SELECT idSimpleUser FROM SIMPLEUSER WHERE username = '" + username + "' AND password = '" + pwd + "';" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		try {
			if (queryResult.next()) {
				id = queryResult.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id ;
	}
	
	/**
	 * Method to save a user in the DB
	 * @param user : the user to save in the database
	 */
	public void saveUser(User user) {
		String name = user.getUsername();
		String zipCode = user.getZipCode();
		String email = user.getEmail();
		String password = user.getPassword();
		String phoneNumber = user.getPhoneNumber();
		String query = "INSERT INTO BUYER(username, email, password, isBuyer, isSuperAdmin, isAdministrator, isEditor, zipcode, phonenumber) "
				+ "VALUES (" + name + "," + email + "," + password + "," + true + "," + false + "," + false + "," + false 
				+ "," + zipCode + "," + phoneNumber + ")";
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query);
	}

}