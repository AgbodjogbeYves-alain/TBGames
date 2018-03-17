package application;

import java.util.*;

/**
 * 
 */
public class User extends Actor {
	
	private String zipCode ;
	private String phoneNumber ;

    /**
     * Default constructor
     */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String id, String username, String email, String password, String zipCode, String phoneNumber) {
		super(id,username,email,password);
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
	}

	public User(ArrayList<String> queryResult) {
		super(queryResult);
    	this.zipCode = queryResult.get(4);
		this.phoneNumber = queryResult.get(5);
    }
    
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    
}