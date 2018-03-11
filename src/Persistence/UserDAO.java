package Persistence;

import Application.*;

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