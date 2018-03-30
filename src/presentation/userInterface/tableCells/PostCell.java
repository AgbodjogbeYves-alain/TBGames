package presentation.userInterface.tableCells;

import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PostCell {
private StringProperty idPost;
private StringProperty title;
private StringProperty consoleType;
private StringProperty type;
private StringProperty status;
private Date date;
	
	public PostCell() {
		this(null,null,null,null,null,null);
	}
	
	public PostCell(String id,String title, String consoleType, String type, String status, Date date) {
		this.idPost = new SimpleStringProperty(id);
		this.title = new SimpleStringProperty(title);
		this.consoleType = new SimpleStringProperty(consoleType);
		this.type = new SimpleStringProperty(type);
		this.status = new SimpleStringProperty(status);
		this.date = date;
	}
	
	public String getTitlePost() {
		return title.get();
	}
	
	public StringProperty getTitlePostProperty() {
		return title;
	}
	
	public StringProperty getConsoleTypeProperty() {
		return consoleType;
	}
	
	public String getConsoleType() {
		return consoleType.get();
	}
	
	public StringProperty getPostTypeProperty() {
		return type;
	}
	
	public String getPostType() {
		return type.get();
	}
	
	public StringProperty getStatusPostProperty() {
		return status;
	}
	
	public String getStatusPost() {
		return status.get();
	}
	
	public StringProperty DatePostProperty() {
		return null;
	}
	
	public StringProperty getIdPostProperty() {
		return idPost;
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


