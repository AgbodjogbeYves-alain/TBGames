package Persistence;

import java.util.*;
import java.sql.*;

/**
 * 
 */
public class PGJDBC {
	
	private static String dbms = "postgresql" ;
	private static String dbName = "tbgames" ;
	private static String host = "localhost" ;
	private static String port = "5432" ;
	private static String user = "postgres" ;
	private static String password = "admin" ;
	
	private static Connection dbConnection = null ;
	
	private static PGJDBC ThePGJDBC = null;
    
	/**
     * Constructor
     */
    private PGJDBC() {
	}
   
     public static PGJDBC getPGJDBC() {
    	if (ThePGJDBC == null) {
    		ThePGJDBC = new PGJDBC();
    	}
    	if (dbConnection == null) {
    		establishConnection() ;
    	}
    	return ThePGJDBC;
    }
    
	public static void establishConnection(){
		if (dbms.equals("postgresql")) {
			try {
				dbConnection = DriverManager.getConnection("jdbc:" + dbms +  "://" + host + ":" + port + "/" + dbName, user, password);
				System.out.println("success connecting to the database");
			} catch (SQLException e) {
				System.out.println("error connecting to the database");
				e.printStackTrace();
			} //Must add the db name, user and password to access the DB
	  	}
	
    }
	
	public String getUserId(String username, String pwd) {
		PreparedStatement pstmt;
		String result = null ;
		try {
			//TODO : do this in the DAO
			pstmt = dbConnection.prepareStatement("SELECT id FROM SIMPLEUSER WHERE username = '"+username+"' AND password = '"+pwd+"';");
			ResultSet pstmtResult = pstmt.executeQuery();
			
			if (pstmtResult.next()){
				result = pstmtResult.getString(1) ;
			}
			else {
				System.out.println("No such user with the username '"+username+"' and password '"+pwd+"' in the database");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<String> getRowById(String table, String id) {
		PreparedStatement pstmt;
		ArrayList<String> result = null;
		try {
			pstmt = dbConnection.prepareStatement("SELECT * FROM "+table+" WHERE id = '"+id+"';");
			ResultSet pstmtResult = pstmt.executeQuery();
			pstmtResult.next();
			int i = 0 ;
			int nbColumns = pstmtResult.getMetaData().getColumnCount() ;
			result = new ArrayList<String>(nbColumns);
			while(i < nbColumns) {
				result.add(pstmtResult.getString(i+1)) ;
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
}