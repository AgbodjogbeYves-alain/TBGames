package application;

public class PostType {
	private String idposttype ;
	private String label ;

	/**
	 * Default constructor
	 */
	public PostType(){

	}

	/**
	 * Default constructor
	 * @param label
	 */
	public PostType(String label) {
		this.label = label;
	}

	// GETTERS AND SETTERS

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
