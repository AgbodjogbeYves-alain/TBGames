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
	
	public Actor() {
		// TODO Auto-generated constructor stub
	}
	
	public Actor(String id, String username, String email, String password) {
		super();
		this.id = id;
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

	public String getId() {
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

}
