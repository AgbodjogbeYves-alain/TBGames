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
    
    public abstract void saveUser(User user);
    
	public abstract User getUserById(String id);


}