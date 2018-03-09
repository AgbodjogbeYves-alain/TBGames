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
    private static PGJDBC PGJDBC() {
		// TODO Auto-generated method stub
		return null;
	}
   
     public static PGJDBC getPGJDBC() {
    	if (ThePGJDBC == null) {
    		ThePGJDBC = new PGJDBC();
    		return ThePGJDBC;
    	}else {
    		return ThePGJDBC;
    	}
    }
    
	public void establishConnection(){
		if (dbms.equals("postgresql")) {
			try {
				dbConnection = DriverManager.getConnection("jdbc:" + dbms +  "://" + host + ":" + port + "/" + dbName, user, password);
				
			} catch (SQLException e) {
				System.out.println("error connecting to the database");
				e.printStackTrace();
			} //Must add the db name, user and password to access the DB
	  	}
	
    }
}