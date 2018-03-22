package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Editor;
import application.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EditorDAOPG implements EditorDAO {
	
	
	/**
     * Default constructor
     */
    public EditorDAOPG() {
    	
    }
	

	@Override
	public ObservableList<Editor> getAllEditors() {
		String query = "SELECT * FROM EDITOR ;" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		ObservableList<Editor> ed = FXCollections.observableArrayList();
		try {
				
				while (queryResult.next()) {
					Editor e  = new Editor();
					e.setEmail(queryResult.getString("email"));
					e.setPhoneNumber(queryResult.getString("phonenumber"));
					e.setUsername(queryResult.getString("username"));
					e.setRepresentativeName(queryResult.getString("representativeName"));
					e.setValidate(queryResult.getBoolean("validate"));
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
}
