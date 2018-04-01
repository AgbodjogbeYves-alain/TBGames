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

	public static PGJDBC getConnector() {
		return connector;
	}

	@Override
	public ActorDAO getActorDAO() {
		return new ActorDAOPG();
	}

	@Override
	public AdministratorDAO getAdministratorDAO() {
		return new AdministratorDAOPG();
	}

	@Override
	public SuperAdministratorDAO getSuperAdministratorDAO() {
		return new SuperAdministratorDAOPG();
	}

	@Override
	public PostDAO getPostDAO() {
		return new PostDAOPG();
	}

	public PostTypeDAO getPostTypeDAO() {
		return new PostTypeDAOPG();		
	}

	public GameDAO getGameDAO() {
		return new GameDAOPG();
	}

	@Override
	public CategoryDAO getCategoryDAO() {
		return new CategoryDAOPG();
	}

	@Override
	public ConsoleDAO getConsoleDAO() {
		return new ConsoleDAOPG();
	}





}