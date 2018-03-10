package Persistence;

import java.util.*;

import Application.*;
import Persistence.*;

/**
 * 
 */
public class UserDAOPG extends UserDAO {

    /**
     * Default constructor
     */
    public UserDAOPG() {
    }
    
    public User createById(String id) {
    	PGJDBC connector = PGJDBC.getPGJDBC() ;
    	ArrayList<String> r = connector.getRowById("SimpleUser",id);
    	User u = null ;
    	if (r != null) {
    		u = new User(r) ;
    	}
        return u ;
    }

}