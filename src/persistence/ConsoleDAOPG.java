package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Console;

public class ConsoleDAOPG extends ConsoleDAO {

	@Override
	public Console createById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Console> getAllConsoles(String idUser) {
		String query = "SELECT * FROM CONSOLE WHERE idUser = '"+idUser+"';" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		ArrayList<Console> cs = new ArrayList<Console>();
		
		try {
				while (queryResult.next()) {
					Console cs1  = new Console(queryResult.getString("idItem"), queryResult.getString("nameItem"),Integer.parseInt(queryResult.getString("ratingItem")),queryResult.getString("idUser"),queryResult.getString("consoleType"),queryResult.getString("idConsole"));
					cs.add(cs1);
				}
				
			}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return cs;
	}

	@Override
	public void saveConsole(Console console) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Console getConsoleById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Console> getAllConsoles() {
		// TODO Auto-generated method stub
		return null;
	}

}
