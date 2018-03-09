package Application;


import java.util.*;
import Persistence.* ;

/**
 * 
 */
public class ApplicationFacade {
	
	private PGJDBC dbConnector ;
    
	/**
     * Default constructor
     */
    public ApplicationFacade() {
    }
    
    public void establishConnection() {
    	dbConnector = PGJDBC.getPGJDBC() ;
    	dbConnector.establishConnection();
    }

    /**
     * @param name 
     * @param pwd 
     * @return
     */
    public User login(String name, String pwd) {
        // TODO implement here
        return null;
    }

}