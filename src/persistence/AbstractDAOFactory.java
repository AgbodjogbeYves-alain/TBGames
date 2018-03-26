package persistence;

/**
 * Singleton
 */
public abstract class AbstractDAOFactory {

    /**
     * Default constructor
     */
    public AbstractDAOFactory() {
    }
    
	public static AbstractDAOFactory getFactory(String dbms, String dbName, String host,
			String port, String user, String password) {
		if (dbms.equals("postgresql")) {
			return PGDAOFactory.getFactory(dbName, host, port, user, password) ;
		}
		return null;
	}
    
    /**
     * 
     * @return
     */
    public abstract UserDAO getUserDAO();

	public abstract EditorDAO getEditorDAO();

	public abstract ActorDAO getActorDAO();
	
	public abstract AdministratorDAO getAdministratorDAO() ;



}