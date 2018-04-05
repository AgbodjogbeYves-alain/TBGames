package application;

public class ConsoleType {
	private String idConsoleType;
	private String brand;

	/**
	 * @param idConsoleType
	 * @param brand
	 */
	public ConsoleType(String idConsoleType, String brand) {
		super();
		this.idConsoleType = idConsoleType;
		this.brand = brand;
	}

	/**
	 * @return idConsoleType
	 */
	public String getIdConsoleType() {
		return idConsoleType;
	}

	/**
	 * @param idConsoleType
	 */
	public void setIdConsoleType(String idConsoleType) {
		this.idConsoleType = idConsoleType;
	}

	/**
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

}
