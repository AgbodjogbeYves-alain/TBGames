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

	/**
	 * 
	 * @param id
	 * @param userName
	 * @param email
	 * @param password
	 */
	public Administrator(String id, String userName, String email, String password) {
		super(id,userName,email,password);
	}
	
	
	public Administrator(String id, String userName, String email, String password,boolean isAdmin, boolean isSA, boolean isEd, boolean isB) {
		super(id,userName,email,password,isAdmin,isSA,isEd,isB);
	} 
}
