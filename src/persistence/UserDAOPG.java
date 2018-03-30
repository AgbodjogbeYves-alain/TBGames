<<<<<<< HEAD
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
    	String query = "SELECT * FROM Editor,Buyer,Administrator,SuperAdmin WHERE idactor = '" + id + "';" ;
    	ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
    	
    	try {
    		queryResult.next();
			String id1 = queryResult.getString("idActor");
			String username1 = queryResult.getString("username");
			String email = queryResult.getString("email");
			String password = queryResult.getString("password");
			String zipCode = queryResult.getString("zipCode");
			String phoneNumber = queryResult.getString("phoneNumber");

			boolean isAdmin = queryResult.getBoolean("isAdministrator");
			boolean isEd = queryResult.getBoolean("isEditor");
			boolean isSA = queryResult.getBoolean("isSuperAdmin");
			boolean isB = queryResult.getBoolean("isBuyer");
			
			User a = new User(id1,username1,email,password,zipCode,phoneNumber,isAdmin,isSA,isEd,isB);
	        return a ;
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

	@Override
	public User getUserById(String id) {
		String query = "SELECT  * FROM SimpleUser WHERE idActor = '" + id + "';" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		try {
			if (queryResult.next()) {
				String id1 = queryResult.getString("idActor");
				String username1 = queryResult.getString("username");
				String email = queryResult.getString("email");
				String password = queryResult.getString("password");
				String zipCode = queryResult.getString("zipCode");
				String phoneNumber = queryResult.getString("phoneNumber");
				boolean isAdmin = queryResult.getBoolean("isAdministrator");
				boolean isEd = queryResult.getBoolean("isEditor");
				boolean isSA = queryResult.getBoolean("isSuperAdmin");
				boolean isB = queryResult.getBoolean("isBuyer");
				
				User e = new User(id1,username1, email, password, zipCode, phoneNumber,isAdmin, isSA, isEd, isB);
				return e;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

=======
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
    	String query = "SELECT * FROM Editor,Buyer,Administrator,SuperAdmin WHERE idactor = '" + id + "';" ;
    	ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
    	
    	try {
    		queryResult.next();
			String id1 = queryResult.getString("idActor");
			String username1 = queryResult.getString("username");
			String email = queryResult.getString("email");
			String password = queryResult.getString("password");
			String zipCode = queryResult.getString("zipCode");
			String phoneNumber = queryResult.getString("phoneNumber");

			boolean isAdmin = queryResult.getBoolean("isAdministrator");
			boolean isEd = queryResult.getBoolean("isEditor");
			boolean isSA = queryResult.getBoolean("isSuperAdmin");
			boolean isB = queryResult.getBoolean("isBuyer");
			
			User a = new User(id1,username1,email,password,zipCode,phoneNumber,isAdmin,isSA,isEd,isB);
	        return a ;
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
		int queryResult = PGDAOFactory.getConnector().executeUpdate(query);
	}
	
    public void updateUser(String idActor, String username, String email, String password, String zipCode, String phoneNumber) {
    	String query = "UPDATE User SET (username, email, password,zipcode,phonenumber) = ('"+username+"', '"+email+"', '"+password+"','"+zipCode+"','"+phoneNumber+"') WHERE idActor = '"+idActor+"';" ;
		int queryResult = PGDAOFactory.getConnector().executeUpdate(query) ;
    }


>>>>>>> b36e04c50a87dfc26cbd95ebb642c7dbc29b0cd9
}