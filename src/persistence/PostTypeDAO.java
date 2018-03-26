package persistence;

import application.*;

public abstract class PostTypeDAO {
	
	public abstract int getPostTypeId(String label) ;
	/**
     * @param id
     */
    public abstract Post createById(String id);
    
}
