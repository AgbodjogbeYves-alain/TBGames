package persistence;

/**
 * 
 */
public abstract class AbstractDAOFactory {

    /**
     * Default constructor
     */
    public AbstractDAOFactory() {
    }
    
    
    /**
     * 
     * @return
     */
    public abstract UserDAO getUserDAO();

}