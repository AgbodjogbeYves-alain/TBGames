package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Category;

public class CategoryDAOPG extends CategoryDAO {
	
	private static String fieldsToInsert = "(nameCategory)";

	@Override
	public void save(Category category) {
		String nameCategory = category.getNameCategory();
		String query = "INSERT INTO Category" + fieldsToInsert + " VALUES (" + nameCategory + ");";
		PGDAOFactory.getConnector().executeUpdate(query);
	}

	@Override
	public void update(Category oldCategory, Category newCategory) {
		String nameCategory = newCategory.getNameCategory();
		String query = "UPDATE TABLE Category SET " + fieldsToInsert + " = (" + nameCategory + ") WHERE idCategory = "
				+ oldCategory.getIdCategory() + ";";
		PGDAOFactory.getConnector().executeUpdate(query);
	}

	@Override
	public void delete(Category category) {
		String query = "DELETE FROM category WHERE idCategory = "+category.getIdCategory() ;
		PGDAOFactory.getConnector().executeUpdate(query);
	}

	@Override
	public ArrayList<Category> getAll() {
		ArrayList<Category> result = new ArrayList<Category>();
		int i ;
    	int nbColumns ;
    	String query = "SELECT * FROM Category" ;
    	ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
    	try {
			while (queryResult.next()) {
				i = 0;
				nbColumns = queryResult.getMetaData().getColumnCount();
				ArrayList<String> r = new ArrayList<String>(nbColumns);
				while (i < nbColumns) {
					r.add(queryResult.getString(i + 1));
					i++;
				}
				Category a = new Category(r) ;
		    	result.add(a) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<Category> getById(String categoryId) {
		ArrayList<Category> result = new ArrayList<Category>();
		int i ;
    	int nbColumns ;
    	String query = "SELECT * FROM Category WHERE idCategory = " + categoryId + ";";
    	ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
    	try {
			while (queryResult.next()) {
				i = 0;
				nbColumns = queryResult.getMetaData().getColumnCount();
				ArrayList<String> r = new ArrayList<String>(nbColumns);
				while (i < nbColumns) {
					r.add(queryResult.getString(i + 1));
					i++;
				}
				Category a = new Category(r) ;
		    	result.add(a) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<Category> getByName(String categoryName) {
		ArrayList<Category> result = new ArrayList<Category>();
		int i ;
    	int nbColumns ;
    	String query = "SELECT * FROM Category WHERE nameCategory = " + categoryName + ";";
    	ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
    	try {
			while (queryResult.next()) {
				i = 0;
				nbColumns = queryResult.getMetaData().getColumnCount();
				ArrayList<String> r = new ArrayList<String>(nbColumns);
				while (i < nbColumns) {
					r.add(queryResult.getString(i + 1));
					i++;
				}
				Category a = new Category(r) ;
		    	result.add(a) ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
