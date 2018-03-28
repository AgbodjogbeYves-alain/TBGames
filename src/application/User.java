package application;

import java.util.*;

/**
 * 
 */
public class User extends Actor {
	private String idSimpleUser;
	private String zipCode ;
	private String phoneNumber ;

    /**
     * Default constructor
     */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param id
	 * @param idSU
	 * @param username
	 * @param email
	 * @param password
	 * @param zipCode
	 * @param phoneNumber
	 */
	public User(String id,String idSU, String username, String email, String password, String zipCode, String phoneNumber) {
		super(id,username,email,password);
		this.idSimpleUser = idSU;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * 
	 * @param username
	 * @param email
	 * @param password
	 * @param zipCode
	 * @param phoneNumber
	 */
	public User(String username, String email, String password, String zipCode, String phoneNumber){
		super(username,email,password);
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * 
	 * @param queryResult
	 */
	public User(ArrayList<String> queryResult) {
		super(queryResult);
    	this.zipCode = queryResult.get(4);
		this.phoneNumber = queryResult.get(5);
    }
    
	/**
	 * 
	 * @return
	 */
	public String getIdSU() {
		return this.idSimpleUser;
	}
	
	/**
	 * 
	 * @param idSU
	 */
	public void setIdSU(String idSU) {
		this.idSimpleUser = idSU;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * 
	 * @param zipCode
	 */
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