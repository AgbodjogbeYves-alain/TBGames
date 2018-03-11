/**
 * 
 */
package Persistence;

/**
 * @author TB Games Team
 *
 */
public class FactoryProducer {
	
	private static FactoryProducer FP = null ;
	
	private FactoryProducer(){
		
	}
	
	public static FactoryProducer getInstance() {
		if (FP == null) {
			FP = new FactoryProducer() ;
		}
		return FP ;
	}
	
	public AbstractDAOFactory getDAOFactory(String type) {
		if (type.equalsIgnoreCase("PG")){
			return new PGDAOFactory() ;
		}
		return null;
	}
}
