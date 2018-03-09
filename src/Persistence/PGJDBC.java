package Persistence;

import java.util.*;
import java.sql.*;

/**
 * 
 */
public class PGJDBC {

    /**
     * Default constructor
     */
    public PGJDBC() {
    	
    }
    public Connection CreateConnection() {
    	Connection db = DriverManager.getConnection("jdbc:postgresql:", user, password); //Must add the db name, user and password to access the DB
    	return db;
    }
    
}