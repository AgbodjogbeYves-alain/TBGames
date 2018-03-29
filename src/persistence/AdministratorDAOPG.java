package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Actor;
import application.Administrator;
import application.User;

public class AdministratorDAOPG extends AdministratorDAO{
	
	public void save(Administrator admin) {
		String username = admin.getUsername();
		String email = admin.getEmail() ; 
		String password = admin.getPassword() ;
		String query = "INSERT INTO Administrator(username, email, password, isBuyer, isSuperAdmin, isAdministrator, isEditor) VALUES (" + username + "," + email + "," + password + "," + false + "," + false + "," + true + "," + false + ")";
    	ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
	}
	
    /**
     * @return an empty ArrayList if there is no admins saved 
     */
    public ArrayList<Administrator> getAll(){
    	ArrayList<Administrator> adminsList = new ArrayList<Administrator>() ;
    	String query = "SELECT * FROM Administrator" ;
    	ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
    	try {
			while (queryResult.next()) {
				String id = queryResult.getString("idActor");
				String username1 = queryResult.getString("username");
				String email = queryResult.getString("email");
				String password = queryResult.getString("password");
				boolean isAdmin = queryResult.getBoolean("isAdministrator");
				boolean isEd = queryResult.getBoolean("isEditor");
				boolean isSA = queryResult.getBoolean("isSuperAdmin");
				boolean isB = queryResult.getBoolean("isBuyer");	
					
				Administrator a = new Administrator(id, username1, email, password, isAdmin, isSA, isEd, isB); ;
		    	adminsList.add(a) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return adminsList ;
    }
    
    /**
     * @param id
     */
    public Administrator getById(String id) {
		String query = "SELECT * FROM ADMINISTRATOR WHERE id = '" + id + "';" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		try {
			queryResult.next();
			String id1 = queryResult.getString("idActor");
			String username1 = queryResult.getString("username");
			String email = queryResult.getString("email");
			String password = queryResult.getString("password");
			boolean isAdmin = queryResult.getBoolean("isAdministrator");
			boolean isEd = queryResult.getBoolean("isEditor");
			boolean isSA = queryResult.getBoolean("isSuperAdmin");
			boolean isB = queryResult.getBoolean("isBuyer");	
				
			Administrator a = new Administrator(id1, username1, email, password, isAdmin, isSA, isEd, isB); ;
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * @param userName
     * @return
     */
    public Administrator getByUserName(String userName){
    	ArrayList<Administrator> adminsList = new ArrayList<Administrator>() ;
    	String query = "SELECT id FROM ADMINISTRATOR WHERE username = '" + userName + "';" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		try {
			queryResult.next();
			String id = queryResult.getString("idActor");
			String username1 = queryResult.getString("username");
			String email = queryResult.getString("email");
			String password = queryResult.getString("password");
			boolean isAdmin = queryResult.getBoolean("isAdministrator");
			boolean isEd = queryResult.getBoolean("isEditor");
			boolean isSA = queryResult.getBoolean("isSuperAdmin");
			boolean isB = queryResult.getBoolean("isBuyer");	
				
			Administrator a = new Administrator(id, username1, email, password, isAdmin, isSA, isEd, isB); ;
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * @param userEmail
     * @return
     */
    public Administrator getByUserEmail(String userEmail){
    	String query = "SELECT * FROM ADMINISTRATOR WHERE email = '" + userEmail + "';" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		try {
			queryResult.next();
			String id = queryResult.getString("idActor");
			String username1 = queryResult.getString("username");
			String email = queryResult.getString("email");
			String password = queryResult.getString("password");
			boolean isAdmin = queryResult.getBoolean("isAdministrator");
			boolean isEd = queryResult.getBoolean("isEditor");
			boolean isSA = queryResult.getBoolean("isSuperAdmin");
			boolean isB = queryResult.getBoolean("isBuyer");	
				
			Administrator a = new Administrator(id, username1, email, password, isAdmin, isSA, isEd, isB); ;
			return a;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
           
    /**
     * @param oldAdmin
     * @param newAdmin
     */
    public void update(Administrator oldAdmin, Administrator newAdmin) {
    	
    }
    
    /**
     * @param admin
     */
    public void delete(Administrator admin) {
    	
    }
		
}
