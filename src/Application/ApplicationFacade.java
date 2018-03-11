package Application;


/**
 * 
 */
public class ApplicationFacade {
	
	private static ApplicationFacade AFInstance = null ;
	private User connectedUser ;
    
	/**
     * Default constructor
     */
    private ApplicationFacade() {
    }
    
    public static ApplicationFacade getInstance(){
    	if (AFInstance == null) {
    		AFInstance = new ApplicationFacade() ;
    	}
    	return AFInstance ;
    }

    /**
     * @param name 
     * @param pwd 
     * @return
     */
    public Boolean login(String username, String pwd) {
        connectedUser = User.login(username,pwd) ;
        return connectedUser != null ;
    }

}