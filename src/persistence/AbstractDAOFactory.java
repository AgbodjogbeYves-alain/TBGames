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
     * @return UserDAO
     */
    public abstract UserDAO getUserDAO();

	/**
	 * @return EditorDAO
	 */
	public abstract EditorDAO getEditorDAO();

	/**
	 * @return ActorDAO
	 */
	public abstract ActorDAO getActorDAO();
	
	/**
	 * @return AdministratorDAO
	 */
	public abstract AdministratorDAO getAdministratorDAO() ;
	
	/**
	 * @return PostDAO
	 */
	public abstract PostDAO getPostDAO();

	/**
	 * @return PostTypeDAO
	 */
	public abstract PostTypeDAO getPostTypeDAO();

	/**
	 * @return CategoryDAO
	 */
	public abstract CategoryDAO getCategoryDAO();

}