package Persistence;

import java.util.*;
import Application.*;

/**
 * 
 */
public class UserDAOPG implements UserDAO {

    /**
     * Default constructor
     */
    public UserDAOPG() {
    }
    
    public User createById(String id) {
    	PGJDBC connector = PGJDBC.getPGJDBC() ;
    	ArrayList<String> r = connector.getRowById("SIMPLEUSER",id);
    	User u = null ;
    	if (r != null) {
    		u = new User(r) ;
    	}
        return u ;
    }

	@Override
	public String getUserId(String username, String pwd) {
		String id = PGJDBC.getPGJDBC().getUserId(username, pwd) ;
		return id ;
	}

}