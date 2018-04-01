package persistence;

import application.*;

public abstract class PostTypeDAO {
	
	/**
	 * Return the id of a post
     * @param label
     */
	public abstract String getPostTypeId(String label) ;
	
	/**
	 * Return a post from the DB by his id
     * @param id
     */
    public abstract PostType createById(String id);
    
}
