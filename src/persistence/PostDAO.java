package persistence;

import java.util.ArrayList;

import application.*;

public abstract class PostDAO {

	/**
	 * Return the id of a post
	 * @param title
	 * @param description
	 */
	public abstract String getPostId(String title, String description) ;

	/**
	 * Return a Post by his id
	 * @param id
	 */
	public abstract Post createById(String id);
	
	public abstract ArrayList<Post> getAllPosts();

	/**
	 * Save a post into the data base
	 * @param post
	 */
	public abstract void savePost(Post post);

	/**
	 * Save a post from the data base
	 * @param post
	 */
	public abstract void deletePost(Post post);
}
