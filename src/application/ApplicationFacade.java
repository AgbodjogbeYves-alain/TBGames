package application;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import persistence.AbstractDAOFactory;
import persistence.EditorDAO;
import persistence.UserDAO;

/**
 * 
 */
public class ApplicationFacade {
	
	private static ApplicationFacade afInstance = null ;
	private User connectedUser = null ;
	private ObservableList<Editor> editors = null;
    
	/**
     * Default constructor
     */
    private ApplicationFacade() {
    }
    
    public static ApplicationFacade getInstance(){
    	if (afInstance == null) {
    		afInstance = new ApplicationFacade() ;
    	}
    	return afInstance ;
    }

    /**
     * @param name 
     * @param pwd 
     * @return
     */
    public Boolean login(String username, String pwd) {
    	AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
    	UserDAO userDAO =  daoFactory.getUserDAO() ;
    	String userId = userDAO.getUserId(username, pwd) ;
    	System.out.println(userId) ;//TEST
    	if (userId != null) {
    		connectedUser = userDAO.createById(userId) ;
    	}
        return connectedUser != null ;
    }
    

    public void setEditorsList(){
    	AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
    	EditorDAO editorDAO =  daoFactory.getEditorDAO() ;
    	editors = editorDAO.getAllEditors() ;
    }
    
    public ObservableList<Editor> getEditorsList(){
    	return this.editors;
    }
    
//    public SignUp () {
//    	
//    }

}