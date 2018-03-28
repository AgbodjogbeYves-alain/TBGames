package persistence;

import application.*;

public abstract class PostTypeDAO {
	
	public abstract String getPostTypeId(String label) ;
	/**
     * @param id
     */
    public abstract Post createById(String id);
    
}
