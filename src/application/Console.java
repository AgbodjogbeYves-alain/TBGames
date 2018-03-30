package application;

public class Console extends Item{

	private String idConsole;
	
	/**
	 * 
	 * @param idItem
	 * @param name
	 * @param rating
	 * @param string
	 * @param consoleType
	 * @param idConsole
	 */
	public Console(String idItem, String name, int rating, String string, String idConsoleType, String idConsole) {
		super(idItem, name, rating, string, idConsoleType);
		this.idConsole = idConsole;
	}

	/**
	 * 
	 * @param id
	 */
	public void setIdConsole(String id) {
		this.idConsole = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getIdConsole() {
		return idConsole;
	}
	
}
