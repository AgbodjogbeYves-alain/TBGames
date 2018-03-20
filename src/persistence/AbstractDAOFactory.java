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
    
	public static AbstractDAOFactory getFactory(String type, String dbms, String dbName, String host,
			String port, String user, String password) {
		if (type.equals("PG")) {
			return PGDAOFactory.getFactory(dbms, dbName, host, port, user, password) ;
		}
		return null;
	}
    
    /**
     * 
     * @return
     */
    public abstract UserDAO getUserDAO();

	public abstract EditorDAO getEditorDAO();




}