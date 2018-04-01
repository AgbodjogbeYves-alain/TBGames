package persistence;

import java.sql.SQLException;

import application.*;

public abstract class RateDAO {

	/**
	 * Return the rate of a user
	 * @param user
	 */
	public abstract int getUserRate(User user) throws SQLException ;

	/**
	 * Rate a user
	 * @param user
	 * @param userToRate
	 * @param rate
	 */
	public abstract void rateAUser(User user, User userToRate, int rate) ;
}
