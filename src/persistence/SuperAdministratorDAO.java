package persistence;

import java.util.ArrayList;

import application.SuperAdministrator ;

/**
 * @author TB Games
 *
 */
public abstract class SuperAdministratorDAO {
	
	/**
     * @param admin
     */
    public abstract void save(SuperAdministrator admin);
		            
    /**
     * @return
     */
    public abstract ArrayList<SuperAdministrator> getAll();
    
    /**
     * @param id
     */
    public abstract SuperAdministrator getById(String id);
    
    /**
     * @param userName
     * @return
     */
    public abstract SuperAdministrator getByUserName(String userName);
    
    /**
     * @param userEmail
     * @return
     */
    public abstract SuperAdministrator getByUserEmail(String userEmail);
           
    /**
     * @param oldAdmin
     * @param newAdmin
     */
    public abstract void update(SuperAdministrator oldAdmin, SuperAdministrator newAdmin);
    
    /**
     * @param admin
     */
    public abstract void delete(SuperAdministrator admin);
}