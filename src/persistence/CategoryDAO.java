package persistence;

import java.util.ArrayList;

import application.Category;

public abstract class CategoryDAO {
	/**
	 * @param category
	 */
	public abstract void save(Category category);

	/**
	 * @param oldCategory
	 * @param newCategory
	 */
	public abstract void update(Category oldCategory, Category newCategory);

	/**
	 * @param category
	 */
	public abstract void delete(Category category);

	/**
	 * @return
	 */
	public abstract ArrayList<Category> getAll();

	/**
	 * @param categoryId
	 * @return
	 */
	public abstract ArrayList<Category> getById(String categoryId);

	/**
	 * @param categoryName
	 * @return
	 */
	public abstract ArrayList<Category> getByName(String categoryName);
}
