package persistence;

import java.util.*;

import application.Editor;

import java.sql.*;

/**
 * Singleton
 */
public class PGJDBC {

	private String dbms ;
	private String dbName ;
	private String host ;
	private String port ;
	private String user ;
	private String password ;

	private Connection dbConnection = null;

	/**
	 * Constructor
	 */
	PGJDBC(String newDbms, String newDbName, String newHost, String newPort, String newUser,
			String newPassword) {
		dbms = newDbms;
		dbName = newDbName; 
		host = newHost;
		port = newPort;
		user = newUser; 
		password = newPassword;
		establishConnection();
	}

	/**
	 * 
	 */
	public void establishConnection() {
		if (dbms.equals("postgresql")) {
			try {
				dbConnection = DriverManager.getConnection("jdbc:" + dbms + "://" + host + ":" + port + "/" + dbName,
						user, password);
				System.out.println("success connecting to the database");
			} catch (SQLException e) {
				System.out.println("error connecting to the database");
				e.printStackTrace();
			} // Must add the db name, user and password to access the DB
		}

	}

	/**
	 * 
	 * @param username
	 * @param pwd
	 * @return
	 */
	public String getUserId(String username, String pwd) {
		PreparedStatement pstmt;
		String result = null;
		try {
			// TODO : do this in the DAO
			pstmt = dbConnection.prepareStatement(
					"SELECT id FROM SIMPLEUSER WHERE username = '" + username + "' AND password = '" + pwd + "';");
			ResultSet pstmtResult = pstmt.executeQuery();

			if (pstmtResult.next()) {
				result = pstmtResult.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 
	 * @param table
	 * @param id
	 * @return
	 */
	public ArrayList<String> getRowById(String table, String id) {
		PreparedStatement pstmt;
		ArrayList<String> result = null;
		try {
			pstmt = dbConnection.prepareStatement("SELECT * FROM " + table + " WHERE id = '" + id + "';");
			ResultSet pstmtResult = pstmt.executeQuery();
			pstmtResult.next();
			int i = 0;
			int nbColumns = pstmtResult.getMetaData().getColumnCount();
			result = new ArrayList<String>(nbColumns);
			while (i < nbColumns) {
				result.add(pstmtResult.getString(i + 1));
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	
//	public ArrayList<Editor> getAll(String table){
//		
//		PreparedStatement pstmt;
//		ArrayList<Editor> result = null;
//		try {
//			pstmt = dbConnection.prepareStatement("SELECT * FROM " + table +" ;");
//			ResultSet pstmtResult = pstmt.executeQuery();
//			pstmtResult.next();
//			int i = 0;
//			int nbColumns = pstmtResult.getMetaData().getColumnCount();
//			int nbRow = pstmtResult.getRow();
//			result = new ArrayList<Editor>(nbColumns);
//			while (i < nbColumns) {
//				result.add(pstmtResult.get);
//				i++;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//		
//	}
}