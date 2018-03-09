package Persistence;

import java.util.*;
import java.sql.*;

/**
 * 
 */
public class PGJDBC {

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
    
	public Connection CreateConnection() {
    	Connection db = DriverManager.getConnection("jdbc:postgresql:", user, password); //Must add the db name, user and password to access the DB
    	return db;
    }
    
}