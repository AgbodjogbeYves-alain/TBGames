package application;

public class PostType {
	private String idposttype ;
	private String label ;
	
	public PostType(){
		
	}
	
	public PostType(String label) {
		this.label = label;
	}

	public String getIdposttype() {
		return idposttype;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
