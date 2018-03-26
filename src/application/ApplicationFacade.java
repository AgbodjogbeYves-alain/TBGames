package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import persistence.AbstractDAOFactory;
import presentation.userInterface.tableCells.EditorCell;
import persistence.* ;
import persistence.EditorDAO;
import persistence.UserDAO;
import presentation.userInterface.helper.*;

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
    	System.out.println(user) ;//TEST
    	connectedUser = user;
    	setEditorsList();
        if(connectedUser != null) {
        	this.setEditorsList();
        }
        return connectedUser != null;
    }
    

    public void setEditorsList(){
    	AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
    	EditorDAO editorDAO =  daoFactory.getEditorDAO() ;
    	ArrayList<Editor> ed = editorDAO.getAllEditors();
    	for(int i=0;i<ed.size();i++) {
    		
    		EditorCell cellEd = new EditorCell();
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
    
    public void CreatePostDemand(String title, String descr, int price, String posttype) {
    	AbstractDAOFactory DAOFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
    	PostDAO postDAO = DAOFactory.getPostDAO();
    	String user = ((Actor)connectedUser).getId() ;
    	PostTypeDAO posttypeDAO = DAOFactory.getPostTypeDAO();
    	int posttypeId = posttypeDAO.getPostTypeId(posttype);
    	Post postToSave = new Post(title,descr,price,posttypeId,user);
    	postDAO.savePost(postToSave);
    }
    
    public void AddItemToPost(Post post, String item) {
    	AbstractDAOFactory DAOFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
    	PostDAO postDAO = DAOFactory.getPostDAO();
    	post.setItem(item);
    	postDAO.savePost(post);
    }

    public ObservableList<EditorCell> getEditorsList(){
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
     * Methods to LogOff a user
     */
    public void LogOff(){
    	connectedUser = null;
    }

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
	 * Methods to get the type of the actor
	 * @param actor
	 * @return: a string corresponding to the actor's type
	 */
	public String getActorType(Actor actor) {
		try {
			if (actor.getIsAdministrator()) {
				return ("Administrator");
			}
			else if (actor.getIsBuyer()) {
				return ("Buyer");
			}
			else if (actor.getIsEditor()) {
				return ("Editor");
			}
			else if (actor.getIsSuperAdmin()) {
				return ("SuperAdmin");
			}
		}catch (Error e){
			AlertBox.showAlert("No type found for this user","No typ found","Erreur");
		}
		return null;
	}
	
	/**
	 * Methods to get the Buyer corresponding to the id
	 * @param idActor
	 * @return: return the Buyer who has idActor as id
	 */
	public User getBuyer(String idActor) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql", "tbgames", "localhost", "5432",
				"postgres", "admin");
		UserDAO buyerDAO = daoFactory.getUserDAO();
		User user = buyerDAO.createById(idActor); //To check
		return (user);
	}

	/**
	 * Methods to get the Editor corresponding to the id
	 * @param idActor
	 * @return: return the Editor who has idActor as id
	 */
	public Editor getEditor(String idActor) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
    	EditorDAO editorDAO = daoFactory.getEditorDAO();
    	Editor editor = editorDAO.getEditorById(idActor);
    	return (editor);
	}
	
	/**
	 * Methods to get the Administrator corresponding to the id
	 * @param idActor
	 * @return: return the Administrator who has idActor as id
	 */
	public Administrator getAdministrator(String idActor) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
    	AdministratorDAO AdministratorDAO = daoFactory.getAdministratorDAO();
    	Administrator admin = AdministratorDAO.getById(idActor);
    	return (admin);
	}
}