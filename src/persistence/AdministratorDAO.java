package persistence;

import java.util.ArrayList;

import application.Administrator ;

/**
 * @author TB Games
 *
 */
public abstract class AdministratorDAO {
	
	/**
     * @param admin
     */
    public abstract void save(Administrator admin);
		            
    /**
     * @return
     */
    public abstract ArrayList<Administrator> getAll();
    
    /**
     * @param id
     */
    public abstract Administrator getById(String id);
    
    /**
     * @param userName
     * @return
     */
    public abstract ArrayList<Administrator> getByUserName(String userName);
    
    /**
     * @param userEmail
     * @return
     */
    public abstract ArrayList<Administrator> getByUserEmail(String userEmail);
           
    /**
     * @param oldAdmin
     * @param newAdmin
     */
    public abstract void update(Administrator oldAdmin, Administrator newAdmin);
    
    /**
     * @param admin
     */
    public abstract void delete(Administrator admin);
}
