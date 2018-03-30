package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.*;

public class RateDAOPG extends RateDAO{

	public int getUserRate(User user) throws SQLException {
		String query = "SELECT rate FROM Rate WHERE idbuyer = '" + user.getIdSU() + "';" ;
    	ResultSet queryResult = PGDAOFactory.getConnector().executeQuery(query) ;
    	int sum =0;
    	int i=0;
    	while(queryResult.next()){ 
    		sum = sum + queryResult.getInt("rate");
    		i++;
    	}
    	return sum/i;
	}
	
	public void rateAUser(User user, User userToRate, int rate) {
		String query = "INSERT INTO userrate(rate,iduser,idbuyer) VALUES'" + user.getIdActor() + "','" + userToRate.getIdActor() + "'," + rate +";";
    	int queryResult = PGDAOFactory.getConnector().executeUpdate(query) ;
	}
}
