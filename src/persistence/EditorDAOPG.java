package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Editor;
import application.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EditorDAOPG extends EditorDAO {
	
	
	/**
     * Default constructor
     */
    public EditorDAOPG() {
    	
    }
	

	@Override
	public ArrayList<Editor> getAllEditors() {
		String query = "SELECT * FROM EDITOR ;" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		ArrayList<Editor> ed = new ArrayList<Editor>();
		try {
				
				while (queryResult.next()) {
					Editor e  = new Editor();
					e.setEmail(queryResult.getString("email"));
					e.setPhoneNumber(queryResult.getString("phonenumber"));
					e.setUsername(queryResult.getString("username"));
					e.setRepresentativeName(queryResult.getString("representativeName"));
					e.setValidate(queryResult.getBoolean("validation"));
					e.setZipCode(queryResult.getString("zipcode"));
					ed.add(e);
				}
				
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ed;
		
	}


	@Override
	public String getEditorId(String username, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Editor createById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Method to save a editor into DB
	 * @param editor : the editor to save in the database
	 */
	public void saveEditor(Editor editor) {
		String name = editor.getUsername();
		String zipCode = editor.getZipCode();
		String email = editor.getEmail();
		String password = editor.getPassword();
		String phoneNumber = editor.getPhoneNumber();
		String representativeName = editor.getRepresentativeName();
		String query = "INSERT INTO EDITOR(username, email, password, isBuyer, isSuperAdmin, isAdministrator, isEditor, zipcode, phonenumber, representativeName) "
				+ "VALUES (" + name + "," + email + "," + password + "," + true + "," + false + "," + false + "," + false 
				+ "," + zipCode + "," + phoneNumber + "," + representativeName +")";
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query);
	}
}
