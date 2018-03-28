package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import persistence.AbstractDAOFactory;
import presentation.userInterface.tableCells.EditorCell;
import persistence.* ;
import persistence.EditorDAO;
import persistence.UserDAO;

/**
 * 
 */
public class ApplicationFacade {
	
	private static ApplicationFacade afInstance = null ;
	private Object connectedUser = null ;
	private ObservableList<EditorCell> editors = FXCollections.observableArrayList();
    
	/**
     * Default constructor
     */
    private ApplicationFacade() {
    }
    
    /**
     * 
     * @return
     */
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
    	ActorDAO actorDAO =  daoFactory.getActorDAO() ;
    	Object user = actorDAO.getActorById(username, pwd) ;
    	connectedUser = user;
        if(connectedUser != null) {
        	this.setEditorsList();
        }
        return connectedUser != null;
    }
    
/**
 * 
 */
    public void setEditorsList(){
    	AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
    	EditorDAO editorDAO =  daoFactory.getEditorDAO() ;
    	ArrayList<Editor> ed = editorDAO.getAllEditors();

    	for(int i=0;i<ed.size();i++) {
    		String idActor = ed.get(i).getIdActor();
    		String idSimpleUser = ed.get(i).getIdSU();
    		String idEditor = ed.get(i).getIdEditor();
    		String username = ed.get(i).getUsername();
    		String email = ed.get(i).getEmail();
    		String zipcode = ed.get(i).getZipCode();
    		String phoneNumber = ed.get(i).getPhoneNumber();
    		String representativeName = ed.get(i).getRepresentativeName();
    		boolean validation = ed.get(i).getValidation();
    		EditorCell cellEd = new EditorCell(idActor,idSimpleUser,idEditor,username, email,zipcode,phoneNumber,representativeName, validation);
    		editors.add(cellEd);
    	}
    }
    
    /**
     * Method to signUp as a User
     * @param username : user's username
     * @param email : user's email
     * @param password : user's password
     * @param zipCode : user's zipcode
     * @param phoneNumber : user's phone number
     */
    public void SignUpUser(String username, String email, String password, String zipCode, String phoneNumber) {
    	AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
    	UserDAO userDAO =  daoFactory.getUserDAO() ;
    	User userToSave = new User(username, email, password, zipCode, phoneNumber);
    	userDAO.saveUser(userToSave);
    }

    public ObservableList<EditorCell> getEditorsList(){
    	System.out.print(editors);
    	return this.editors;
    }

    /**
     * Method to signUp as an Editor
     * @param username : editor's username
     * @param email : editor's email
     * @param password : editor's password
     * @param zipCode : editor's zipcode
     * @param phoneNumber : editor's phone number
     * @param representativeName : editor's representative name
     */
    public void SignUpEditor(String username, String email, String password, String zipCode, String phoneNumber, String representativeName) {
    	AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
    	EditorDAO editorDAO =  daoFactory.getEditorDAO() ;
    	Editor editorToSave = new Editor(username, email, password, zipCode, phoneNumber, representativeName);
    	editorDAO.saveEditor(editorToSave);
    }
    
    /**
     * 
     */
    public void LogOff(){
    	connectedUser = null;
    }

    /**
     * 
     * @return
     */
	public static ObservableList<Administrator> loadAdministratorsList() {
		ObservableList<Administrator> admins = FXCollections.observableArrayList() ;
		
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
    	AdministratorDAO adminDAO =  daoFactory.getAdministratorDAO() ;
    	
    	ArrayList<Administrator> adminsList = adminDAO.getAll() ;
    	for (int i=0 ; i< adminsList.size() ; i++) {
    		admins.add(adminsList.get(i)) ;
    	}
    	return admins;
	}

	/**
	 * 
	 * @param id
	 */
	public void deleteActor(String id) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
    	ActorDAO actorDAO =  daoFactory.getActorDAO() ;
    	
    	actorDAO.deleteActor(id);
    	
		
	}
}