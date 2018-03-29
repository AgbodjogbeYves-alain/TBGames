package application;

import java.util.ArrayList;

public class Category {
	private String idCategory;
	private String nameCategory;
	
	/**
	 * @param idCategory
	 * @param nameCategory
	 */
	public Category(String idCategory, String nameCategory) {
		super();
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
	}

	public Category(ArrayList<String> queryResult) {
    	this.idCategory = queryResult.get(0);
    	this.nameCategory = queryResult.get(1);
	}

	/**
	 * @return
	 */
	public String getIdCategory() {
		return idCategory;
	}

	/**
	 * @param idCategory
	 */
	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	/**
	 * @return
	 */
	public String getNameCategory() {
		return nameCategory;
	}

	/**
	 * @param nameCategory
	 */
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
	
}
