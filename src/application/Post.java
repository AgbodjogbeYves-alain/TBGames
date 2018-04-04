package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class Post {

	private String idpost ;
	private String title ;
	private String description ;
	private int price ;
	private String posttype ;
	private String iduser ;
	private Optional<String> item ;
	private String status;
	private Date date;


	/**
	 * Default constructor
	 */
	public Post() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Default constructor without item
	 * @param title
	 * @param description
	 * @param price
	 * @param posttype
	 * @param iduser 
	 */
	public Post(String title, String description, int price, String posttype, String iduser) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.posttype = posttype;
		this.iduser = iduser;
		this.item = null ;
	}

	/**
	 * Default constructor with item as an optional string
	 * @param title
	 * @param description
	 * @param price
	 * @param posttype
	 * @param iduser 
	 * @param result
	 */
	public Post(String title, String description, int price, String posttype, String iduser, Optional<String> result) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.posttype = posttype;
		this.iduser = iduser;
		this.item = result ;
	}
	
	public Post(String title, String posttype, String status, Date date) {
		this.title = title;
		this.posttype = posttype;
		this.status = status;
		this.date = date ;
	}
	
	public Post(String idpost, String title, String posttype, String status, Date date) {
		this.idpost = idpost;
		this.title = title;
		this.posttype = posttype;
		this.status = status;
		this.date = date ;
	}



	/**
	 * Default constructor with an array
	 * @param r
	 */
	public Post(ArrayList<String> r) {
		this.idpost = r.get(0);
		this.title = r.get(1);
		this.description = r.get(2);
		this.price = Integer.parseInt(r.get(3));
		this.posttype = r.get(4);
		this.iduser = r.get(5);
	}

	// GETTERS AND SETTERS

	public String getIdpost() {
		return idpost;
	}

	public void setIdpost(String idpost) {
		this.idpost = idpost;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPosttype() {
		return posttype;
	}

	public void setPosttype(String posttype) {
		this.posttype = posttype;
	}

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public Optional<String> getItem() {
		return item;
	}

	public void setItem(Optional<String> item) {
		this.item = item;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

}
