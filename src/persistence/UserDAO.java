<<<<<<< HEAD
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


=======
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
    
    public abstract void updateUser(String idActor, String username, String email, String password, String zipCode, String phoneNumber);

>>>>>>> b36e04c50a87dfc26cbd95ebb642c7dbc29b0cd9
}