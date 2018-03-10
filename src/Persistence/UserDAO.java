package Persistence;

import java.util.*;
import Application.*;

/**
 * 
 */
public abstract class UserDAO {

    /**
     * Default constructor
     */
    public UserDAO() {
    }

    /**
     * @param id
     */
    public abstract User createById(String id);

}