package application;

import java.util.*;

public class Buyer extends User{
	private String idBuyer;
	
	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Buyer(String id,String idSU, String idBuyer, String username, String email, String password, String zipCode, String phoneNumber) {
		super(id,idSU, username,email,password, zipCode, phoneNumber);
		this.idBuyer = idBuyer;
	}
	
	public Buyer(String username, String email, String password, String zipCode, String phoneNumber){
		super(username, email, password,zipCode, phoneNumber);
	}
	
	public String getIdBuyer() {
		return this.idBuyer;
	}
	
	public void setIdBuyer(String idBuyer) {
		this.idBuyer = idBuyer;
	}
}
