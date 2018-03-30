package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Actor;
import application.SuperAdministrator;
import application.User;

public class SuperAdministratorDAOPG extends SuperAdministratorDAO{
	
	public void save(SuperAdministrator admin) {
		String username = admin.getUsername();
		String email = admin.getEmail() ; 
		String password = admin.getPassword() ;
		String query = "INSERT INTO SuperAdmin(username, email, password, isBuyer, isSuperAdmin, isAdministrator, isEditor) VALUES (" + username + "," + email + "," + password + "," + false + "," + false + "," + true + "," + false + ")";
    	int queryResult = PGDAOFactory.getConnector().executeUpdate(query) ;
	}
	
    /**
     * @return an empty ArrayList if there is no admins saved 
     */
    public ArrayList<SuperAdministrator> getAll(){
    	ArrayList<SuperAdministrator> adminsList = new ArrayList<SuperAdministrator>() ;
    	String query = "SELECT * FROM SuperAdmin" ;
    	ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
    	try {
			while (queryResult.next()) {
				String id = queryResult.getString("idActor");
				String username1 = queryResult.getString("username");
				String email = queryResult.getString("email");
				String password = queryResult.getString("password");
				boolean isAdmin = queryResult.getBoolean("isSuperAdmin");
				boolean isEd = queryResult.getBoolean("isEditor");
				boolean isSA = queryResult.getBoolean("isSuperAdmin");
				boolean isB = queryResult.getBoolean("isBuyer");	
					
				SuperAdministrator a = new SuperAdministrator(id, username1, email, password, isAdmin, isSA, isEd, isB); ;
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
    public SuperAdministrator getById(String id) {
		String query = "SELECT * FROM SuperAdmin WHERE idActor = '" + id + "';" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		try {
			queryResult.next();
			String id1 = queryResult.getString("idActor");
			String username1 = queryResult.getString("username");
			String email = queryResult.getString("email");
			String password = queryResult.getString("password");
			boolean isAdmin = queryResult.getBoolean("isSuperAdmin");
			boolean isEd = queryResult.getBoolean("isEditor");
			boolean isSA = queryResult.getBoolean("isSuperAdmin");
			boolean isB = queryResult.getBoolean("isBuyer");	
				
			SuperAdministrator a = new SuperAdministrator(id1, username1, email, password, isAdmin, isSA, isEd, isB); ;
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
    public SuperAdministrator getByUserName(String userName){
    	ArrayList<SuperAdministrator> adminsList = new ArrayList<SuperAdministrator>() ;
    	String query = "SELECT id FROM SuperAdmin WHERE username = '" + userName + "';" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		try {
			queryResult.next();
			String id = queryResult.getString("idActor");
			String username1 = queryResult.getString("username");
			String email = queryResult.getString("email");
			String password = queryResult.getString("password");
			boolean isAdmin = queryResult.getBoolean("isSuperAdmin");
			boolean isEd = queryResult.getBoolean("isEditor");
			boolean isSA = queryResult.getBoolean("isSuperAdmin");
			boolean isB = queryResult.getBoolean("isBuyer");	
				
			SuperAdministrator a = new SuperAdministrator(id, username1, email, password, isAdmin, isSA, isEd, isB); ;
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
    public SuperAdministrator getByUserEmail(String userEmail){
    	String query = "SELECT * FROM SuperAdmin WHERE email = '" + userEmail + "';" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		try {
			queryResult.next();
			String id = queryResult.getString("idActor");
			String username1 = queryResult.getString("username");
			String email = queryResult.getString("email");
			String password = queryResult.getString("password");
			boolean isAdmin = queryResult.getBoolean("isSuperAdministrator");
			boolean isEd = queryResult.getBoolean("isEditor");
			boolean isSA = queryResult.getBoolean("isSuperAdmin");
			boolean isB = queryResult.getBoolean("isBuyer");	
				
			SuperAdministrator a = new SuperAdministrator(id, username1, email, password, isAdmin, isSA, isEd, isB); ;
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
    public void update(SuperAdministrator oldAdmin, SuperAdministrator newAdmin) {
    	
    }
    
    /**
     * @param admin
     */
    public void delete(SuperAdministrator admin) {
    	
    }
		
}
