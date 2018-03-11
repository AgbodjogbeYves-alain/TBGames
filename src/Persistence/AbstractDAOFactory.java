package Persistence;

/**
 * 
 */
public abstract class AbstractDAOFactory {

    /**
     * Default constructor
     */
    public AbstractDAOFactory() {
    }
    
    public abstract UserDAO getUserDAO();

}