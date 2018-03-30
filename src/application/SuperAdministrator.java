package application;

public class SuperAdministrator extends Administrator{

	/**
	 * 
	 */
	public SuperAdministrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param userName
	 * @param email
	 * @param password
	 * @param isAdmin
	 * @param isSA
	 * @param isEd
	 * @param isB
	 */
	public SuperAdministrator(String id, String userName, String email, String password, boolean isAdmin, boolean isSA,
			boolean isEd, boolean isB) {
		super(id, userName, email, password, isAdmin, isSA, isEd, isB);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param userName
	 * @param email
	 * @param password
	 */
	public SuperAdministrator(String id, String userName, String email, String password) {
		super(id, userName, email, password);
		// TODO Auto-generated constructor stub
	}
	
	
}
