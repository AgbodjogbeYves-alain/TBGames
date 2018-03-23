package persistence;

import application.*;

public abstract class PostDAO {
	
	public abstract String getPostId(String title, String description) ;
	/**
     * @param id
     */
    public abstract Post createById(String id);
    
    public abstract void savePost(Post post);
}
