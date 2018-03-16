package persistence;

import java.util.*;
import application.*;

/**
 * 
 */
public class UserDAOPG implements UserDAO {

    /**
     * Default constructor
     */
    public UserDAOPG() {
    }
    
    /**
     * 
     */
    public User createById(String id) {
    	ArrayList<String> r = PGDAOFactory.getConnector().getRowById("SIMPLEUSER",id);
    	User u = null ;
    	if (r != null) {
    		u = new User(r) ;
    	}
        return u ;
    }

	@Override
	/**
	 * 
	 */
	public String getUserId(String username, String pwd) {
		String id = PGDAOFactory.getConnector().getUserId(username, pwd) ;
		return id ;
	}

}