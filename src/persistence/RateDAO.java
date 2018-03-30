package persistence;

import java.sql.SQLException;

import application.*;

public abstract class RateDAO {

	public abstract int getUserRate(User user) throws SQLException ;
	
	public abstract void rateAUser(User user, User userToRate, int rate) ;
}
