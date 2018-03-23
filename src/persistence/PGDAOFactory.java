package persistence;

/**
 * Singleton
 */
public class PGDAOFactory extends AbstractDAOFactory {

	private static PGDAOFactory thePGDAOFactory ;
	private static PGJDBC connector ;
	
    /**
     * Default constructor
     */
    private PGDAOFactory() {
    }
    
    /*
     * This should be improved
     */
    public static AbstractDAOFactory getFactory(String dbName, String host, String port, String user,
			String password) {
		if (thePGDAOFactory == null) {
			thePGDAOFactory = new PGDAOFactory() ;
			connector = new PGJDBC(dbName, host, port, user, password) ;
		}
		return thePGDAOFactory;
	}

    /**
     * @return
     */
    public UserDAO getUserDAO() {
        return new UserDAOPG();
    }
    
    public EditorDAO getEditorDAO() {
    	return new EditorDAOPG();
    }
    
    public PostDAO getPostDAO() {
    	return new PostDAOPG();
    }
    
    public static PGJDBC getConnector() {
    	return connector;
    }

	
    
}