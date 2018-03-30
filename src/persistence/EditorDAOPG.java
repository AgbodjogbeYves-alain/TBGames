<<<<<<< HEAD
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
	/**
	 * return : null if editor is not in the database
	 */
	public Editor getEditorById(String id) {
		String query = "SELECT  * FROM Editor WHERE idActor = '" + id + "';" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		try {
			if (queryResult.next()) {
				String id1 = queryResult.getString("idActor");
				String username1 = queryResult.getString("username");
				String email = queryResult.getString("email");
				String password = queryResult.getString("password");
				String zipCode = queryResult.getString("zipCode");
				String phoneNumber = queryResult.getString("phoneNumber");
				boolean isAdmin = queryResult.getBoolean("isAdministrator");
				boolean isEd = queryResult.getBoolean("isEditor");
				boolean isSA = queryResult.getBoolean("isSuperAdmin");
				boolean isB = queryResult.getBoolean("isBuyer");
				boolean validate = queryResult.getBoolean("validation");
				String rn = queryResult.getString("representativeName");
				
				Editor e = new Editor(id1,username1, email, password, zipCode, phoneNumber,rn,validate,isAdmin, isSA, isEd, isB);
				return e;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Editor> getAllEditors() {
		String query = "SELECT * FROM EDITOR ;" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		ArrayList<Editor> ed = new ArrayList<Editor>();
		
		try {
				while (queryResult.next()) {
					Editor e  = new Editor();
					e.setId(queryResult.getString("idActor"));
					e.setIdSU(queryResult.getString("idSimpleUser"));
					e.setIdEditor(queryResult.getString("idEditor"));
					e.setEmail(queryResult.getString("email"));
					e.setPhoneNumber(queryResult.getString("phonenumber"));
					e.setUsername(queryResult.getString("username"));
					e.setRepresentativeName(queryResult.getString("representativeName"));
					e.setValidate(queryResult.getBoolean("validation"));
					e.setZipCode(queryResult.getString("zipcode"));
					ed.add(e);
				
				}
				
			}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Taille ed : "+ed.size());
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
				+ "VALUES ('" + name + "','" + email + "','" + password + "'," + false + "," + false + "," + false + "," + true 
				+ ",'" + zipCode + "','" + phoneNumber + "','" + representativeName +"')";
		int queryResult = PGDAOFactory.getConnector().executeUpdate(query);
	}

	@Override
	public void updateEditor(String idActor, String usernameEditor, String emailEditor, String passwordEditor,
		String zipCodeEditor, String phoneNumberEditor, String representativeNameEditor) {
		String query = "UPDATE Editor SET (username, email, password,zipcode,phonenumber,representativename) = ('"+usernameEditor+"', '"+emailEditor+"', '"+passwordEditor+"','"+zipCodeEditor+"','"+phoneNumberEditor+"','"+representativeNameEditor+"') WHERE idActor = '"+idActor+"';" ;
		PGDAOFactory.getConnector().executeUpdate(query) ;
	}
}
=======
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
	/**
	 * return : null if editor is not in the database
	 */
	public Editor getEditorById(String id) {
		String query = "SELECT  * FROM Editor WHERE idActor = '" + id + "';" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		try {
			if (queryResult.next()) {
				String id1 = queryResult.getString("idActor");
				String username1 = queryResult.getString("username");
				String email = queryResult.getString("email");
				String password = queryResult.getString("password");
				String zipCode = queryResult.getString("zipCode");
				String phoneNumber = queryResult.getString("phoneNumber");
				boolean isAdmin = queryResult.getBoolean("isAdministrator");
				boolean isEd = queryResult.getBoolean("isEditor");
				boolean isSA = queryResult.getBoolean("isSuperAdmin");
				boolean isB = queryResult.getBoolean("isBuyer");
				boolean validate = queryResult.getBoolean("validation");
				String rn = queryResult.getString("representativeName");
				
				Editor e = new Editor(id1,username1, email, password, zipCode, phoneNumber,rn,validate,isAdmin, isSA, isEd, isB);
				return e;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Editor> getAllEditors() {
		String query = "SELECT * FROM EDITOR ;" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		ArrayList<Editor> ed = new ArrayList<Editor>();
		
		try {
				while (queryResult.next()) {
					Editor e  = new Editor();
					e.setId(queryResult.getString("idActor"));
					e.setIdSU(queryResult.getString("idSimpleUser"));
					e.setIdEditor(queryResult.getString("idEditor"));
					e.setEmail(queryResult.getString("email"));
					e.setPhoneNumber(queryResult.getString("phonenumber"));
					e.setUsername(queryResult.getString("username"));
					e.setRepresentativeName(queryResult.getString("representativeName"));
					e.setValidate(queryResult.getBoolean("validation"));
					e.setZipCode(queryResult.getString("zipcode"));
					ed.add(e);
				
				}
				
			}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Taille ed : "+ed.size());
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
				+ "VALUES ('" + name + "','" + email + "','" + password + "'," + false + "," + false + "," + false + "," + true 
				+ ",'" + zipCode + "','" + phoneNumber + "','" + representativeName +"')";
		int queryResult = PGDAOFactory.getConnector().executeUpdate(query);
	}

	@Override
	public void updateEditor(String idActor, String usernameEditor, String emailEditor, String passwordEditor,
		String zipCodeEditor, String phoneNumberEditor, String representativeNameEditor) {
		String query = "UPDATE Editor SET (username, email, password,zipcode,phonenumber,representativename) = ('"+usernameEditor+"', '"+emailEditor+"', '"+passwordEditor+"','"+zipCodeEditor+"','"+phoneNumberEditor+"','"+representativeNameEditor+"') WHERE idActor = '"+idActor+"';" ;
		int queryResult = PGDAOFactory.getConnector().executeUpdate(query) ;
	}
}
>>>>>>> b36e04c50a87dfc26cbd95ebb642c7dbc29b0cd9
