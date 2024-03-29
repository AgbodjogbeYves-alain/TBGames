package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Console;

public class ConsoleDAOPG extends ConsoleDAO {

	@Override
	public Console createById(String id) {
		return null;
	}

	@Override
	public ArrayList<Console> getAllConsoles() {
		String query = "SELECT * FROM CONSOLE;" ;
		ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
		ArrayList<Console> cs = new ArrayList<Console>();
		
		try {
				while (queryResult.next()) {
					Console cs1  = new Console(queryResult.getString("idItem"), queryResult.getString("nameItem"),0,queryResult.getString("idUser"),queryResult.getString("consoleType"),queryResult.getString("idConsole"));
					cs.add(cs1);
				}
				
			}catch (SQLException e1) {
			e1.printStackTrace();
		}
		return cs;
	}

	@Override
	public void saveConsole(Console console) {
		
	}

	@Override
	public Console getConsoleById(String id) {
		return null;
	}

}
