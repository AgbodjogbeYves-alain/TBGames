package presentation.userInterface.tableCells;

import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PostCell {
private StringProperty idPost;
private StringProperty title;
private StringProperty description;
private StringProperty type;
private StringProperty status;
private Date date;
	
	public PostCell() {
		this(null,null,null,null,null,null);
	}
	
	public PostCell(String id,String title, String description, String type, String status, Date date) {
		this.idPost = new SimpleStringProperty(id);
		this.title = new SimpleStringProperty(title);
		this.description = new SimpleStringProperty(description);
		this.type = new SimpleStringProperty(type);
		this.status = new SimpleStringProperty(status);
		this.date = date;
	}
	
	public String getTitlePost() {
		return title.get();
	}
	
	public String getDescriptionPost() {
		return description.get();
	}
	
	public String getTypePost() {
		return type.get();
	}
	
	public String getStatusPost() {
		return status.get();
	}
	
	public Date DatePostProperty() {
		return date;
	}
	
	
	public String getIdPost() {
		return idPost.get();
	}
	
	public void setIdPost(String id) {
		this.idPost.set(id);
	}
	
	public StringProperty idPostProperty() {
		return idPost;
	}
}


