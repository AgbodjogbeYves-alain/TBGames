package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    	int i ;
    	int nbColumns ;
    	String query = "SELECT * FROM Administrator" ;
    	ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
    	try {
			while (queryResult.next()) {
				i = 0;
				nbColumns = queryResult.getMetaData().getColumnCount();
				ArrayList<String> r = new ArrayList<String>(nbColumns);
				while (i < nbColumns) {
					r.add(queryResult.getString(i + 1));
					i++;
				}
				Administrator a = new Administrator(r) ;
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
		String query = "SELECT id FROM ADMINISTRATOR WHERE id = '" + id + "';" ;
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
			Administrator a = null ;
	    	if (r != null) {
	    		a = new Administrator(r) ;
	    	}
	        return a ;
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
    public ArrayList<Administrator> getByUserName(String userName){
    	ArrayList<Administrator> adminsList = new ArrayList<Administrator>() ;
    	String query = "SELECT id FROM ADMINISTRATOR WHERE username = '" + userName + "';" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		try {
			while (queryResult.next()) {
				int i = 0;
				int nbColumns = queryResult.getMetaData().getColumnCount();
				ArrayList<String> r = new ArrayList<String>(nbColumns);
				while (i < nbColumns) {
					r.add(queryResult.getString(i + 1));
					i++;
				}
				Administrator a = null ;
		    	if (r != null) {
		    		a = new Administrator(r) ;
		    	}
		    	adminsList.add(a) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return adminsList;
    }
    
    /**
     * @param userEmail
     * @return
     */
    public ArrayList<Administrator> getByUserEmail(String userEmail){
    	ArrayList<Administrator> adminsList = new ArrayList<Administrator>() ;
    	String query = "SELECT id FROM ADMINISTRATOR WHERE email = '" + userEmail + "';" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		try {
			while (queryResult.next()) {
				int i = 0;
				int nbColumns = queryResult.getMetaData().getColumnCount();
				ArrayList<String> r = new ArrayList<String>(nbColumns);
				while (i < nbColumns) {
					r.add(queryResult.getString(i + 1));
					i++;
				}
				Administrator a = null ;
		    	if (r != null) {
		    		a = new Administrator(r) ;
		    	}
		    	adminsList.add(a) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return adminsList;
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
