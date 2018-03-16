package persistence;

/**
 * 
 */
public class PGDAOFactory extends AbstractDAOFactory {

    /**
     * Default constructor
     */
    public PGDAOFactory() {
    }

    /**
     * @return
     */
    public UserDAO getUserDAO() {
        return new UserDAOPG();
    }
    
}