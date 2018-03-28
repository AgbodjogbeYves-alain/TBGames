/**
 * 
 */
package application;

import java.util.ArrayList;

/**
 * @author
 *
 */
public class Actor {
	
	private String id ;
	private String username ;
	private String email ; 
	private String password ;
	private boolean isBuyer = false;
	private boolean isAdministrator = false;
	private boolean isEditor = false;
	private boolean isSuperAdmin = false;
	
	public Actor() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Contructor with id
	 * @param id : id of the actor
	 * @param username : username of the actor
	 * @param email : actor's email
	 * @param password : actor's password
	 */
	
	public Actor(String id, String username, String email, String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	/**
	 * Contructor without id
	 * @param username : actor's username
	 * @param email : actor's email
	 * @param password : actor's password
	 */
	public Actor(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	/**
     * Creates new Actor from a query result
     */
	public Actor(ArrayList<String> queryResult) {
		this.id = queryResult.get(0);
		this.username = queryResult.get(1);
		this.email = queryResult.get(2) ;
		this.password = queryResult.get(3) ;
	}

	public String getIdActor() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getIsBuyer() {
		return isBuyer;
	}

	public boolean getIsAdministrator() {
		return isAdministrator;
	}
	
	public boolean getIsEditor() {
		return isEditor;
	}
	
	public boolean getIsSuperAdmin() {
		return isSuperAdmin;
	}

}
