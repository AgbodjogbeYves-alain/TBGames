package persistence;

import application.*;

/**
 * 
 */
public abstract class UserDAO {
	
	public abstract String getUserId(String username, String pwd) ;
	/**
     * @param id
     */
    public abstract User createById(String id);
    
    /**
     * 
     * @param id
     * @return
     */
	public abstract User getUserById(String id);
	
	public abstract void saveUser(User user);
    

}