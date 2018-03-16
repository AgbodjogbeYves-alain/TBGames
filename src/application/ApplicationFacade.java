package application;

import persistence.AbstractDAOFactory;
import persistence.UserDAO;

/**
 * 
 */
public class ApplicationFacade {
	
	private static ApplicationFacade afInstance = null ;
	private User connectedUser = null ;
    
	/**
     * Default constructor
     */
    private ApplicationFacade() {
    }
    
    public static ApplicationFacade getInstance(){
    	if (afInstance == null) {
    		afInstance = new ApplicationFacade() ;
    	}
    	return afInstance ;
    }

    /**
     * @param name 
     * @param pwd 
     * @return
     */
    public Boolean login(String username, String pwd) {
    	AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("PG","postgresql","tbgames","localhost","5432","postgres","admin") ;
    	UserDAO userDAO =  daoFactory.getUserDAO() ;
    	String userId = userDAO.getUserId(username, pwd) ;
    	System.out.println(userId) ;//TEST
    	if (userId != null) {
    		connectedUser = userDAO.createById(userId) ;
    	}
        return connectedUser != null ;
    }

}