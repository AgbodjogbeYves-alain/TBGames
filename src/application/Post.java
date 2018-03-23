package application;

import java.util.ArrayList;

public class Post {

	private String idpost ;
	private String title ;
	private String description ;
	private int price ;
	private int posttype ;
	private int iduser ;
	

    /**
     * Default constructor
     */
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(String id, String title, String description, int price, int posttype, int iduser) {
		this.idpost = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.posttype = posttype;
		this.iduser = iduser;
	}

	public Post(ArrayList<String> r) {
		this.idpost = r.get(0);
		this.title = r.get(1);
		this.description = r.get(2);
		this.price = Integer.parseInt(r.get(3));
		this.posttype = Integer.parseInt(r.get(4));
		this.iduser = Integer.parseInt(r.get(5));
	}

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

	public int getPosttype() {
		return posttype;
	}

	public void setPosttype(int posttype) {
		this.posttype = posttype;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	
}
