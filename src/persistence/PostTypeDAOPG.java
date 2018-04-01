package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Post;
import application.PostType;

public class PostTypeDAOPG extends PostTypeDAO {
    /**
     * Default constructor
     */
    public PostTypeDAOPG() {
    }
    
    /**
     * 
     */
    public PostType createById(String id) {
    	String query = "SELECT * FROM PostType WHERE idposttype = '" + id + "';" ;
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
			PostType u = null ;
	    	if (r != null) {
	    		u = new PostType() ;
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
	public String getPostTypeId(String label)  {
		String id = null ;
		String query = "SELECT idposttype FROM PostType WHERE label = '" + label + "';" ;
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
}
