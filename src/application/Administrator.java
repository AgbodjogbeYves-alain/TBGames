package application;

import java.util.ArrayList;

/**
 * 
 */
public class Administrator extends Actor {

    /**
     * Default constructor
     */
	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrator(String id, String userName, String email, String password) {
		super(id,userName,email,password);
	}
	
	/**
	 * Creates an Administrator from a query result
	 * @param queryResult : 
	 */
	public Administrator(ArrayList<String> queryResult) {
		super(queryResult);
    }
}
