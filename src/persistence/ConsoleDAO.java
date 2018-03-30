package persistence;

import java.util.ArrayList;

import application.Console;
import application.Editor;

public abstract class ConsoleDAO {
		
	public abstract Console createById(String id);

	public abstract ArrayList<Console> getAllConsoles();
	
	public abstract void saveConsole(Console console);

	public abstract Console getConsoleById(String id);

}
