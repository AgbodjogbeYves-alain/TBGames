/**
 * 
 */
package persistence;

/**
 * @author TB Games Team
 *
 */
public class FactoryProducer {
	
	private static FactoryProducer fp = null ;
	
	/**
	 * 
	 */
	private FactoryProducer(){
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static FactoryProducer getInstance() {
		if (fp == null) {
			fp = new FactoryProducer() ;
		}
		return fp ;
	}
	
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	public AbstractDAOFactory getDAOFactory(String type) {
		if (type.equalsIgnoreCase("PG")){
			return new PGDAOFactory() ;
		}
		return null;
	}
}
