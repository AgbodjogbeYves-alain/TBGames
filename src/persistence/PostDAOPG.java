package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Post;

public class PostDAOPG extends PostDAO{

    /**
     * Default constructor
     */
    public PostDAOPG() {
    }
    
    /**
     * 
     */
    public Post createById(String id) {
    	String query = "SELECT * FROM Post WHERE Post = '" + id + "';" ;
    	ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
    	
    	try {
			queryResult.next();
			int i = 0;
			int nbColumns = queryResult.getMetaData().getColumnCount();
			ArrayList<String> r = new ArrayList<String>(nbColumns);
			while (i < nbColumns) {
				r.add(queryResult.getString(i + 1));
				i++;
			}
			Post u = null ;
	    	if (r != null) {
	    		u = new Post(r) ;
	    	}
	        return u ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    	return null;
    	
    }

	@Override
	/**
	 * return : null if Post is not in the database
	 */
	public String getPostId(String title, String description) {
		String id = null ;
		String query = "SELECT idpost FROM Post WHERE title = '" + title + "' AND description = '" + description + "';" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		try {
			if (queryResult.next()) {
				id = queryResult.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id ;
	}
	
	/**
	 * Function to save a post in the DB
	 */
	public void savePost(Post post) {
		String title1 = post.getTitle();
		String description1 = post.getDescription();
		int price1 = post.getPrice();
		String posttype1 = post.getPosttype();
		int iduser1 = Integer.parseInt(post.getIduser());
		String query = "INSERT INTO Post(title, descriptionpost, price, posttype,idsimpleuser) "
				+ "VALUES ('" + title1 + "','" + description1 + "'," + price1 + ",'" + posttype1 + "'," + iduser1 + ")";
		System.out.println(query);
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query);

	}
}
