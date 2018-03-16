package persistence;

import application.*;

/**
 * 
 */
public interface UserDAO {

	public String getUserId(String username, String pwd) ;
	/**
     * @param id
     */
    public User createById(String id);

}