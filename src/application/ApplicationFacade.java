
package application;

import java.util.ArrayList;
import java.util.Optional;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import persistence.AbstractDAOFactory;
import presentation.MainStage;

import presentation.userInterface.helper.AlertBox;
import presentation.userInterface.tableCells.ConsoleCell;
import presentation.userInterface.tableCells.AdministratorCell;
import presentation.userInterface.tableCells.EditorCell;
import presentation.userInterface.tableCells.GameCell;
import persistence.* ;

/**
 * 
 */
public class ApplicationFacade {

	private static ApplicationFacade afInstance = null ;
	private static Object connectedUser = null ;
	private ObservableList<EditorCell> editors = FXCollections.observableArrayList();
	private ObservableList<ConsoleCell> consoles = FXCollections.observableArrayList();
	private ObservableList<AdministratorCell> administrators = FXCollections.observableArrayList();
	private ObservableList<GameCell> games = FXCollections.observableArrayList();
	
	/**
	 * Get the current user of the application
	 * @return Object : which will represent Editor, Administrator and so on
	 */
	public static Object getConnectedUser() {
		return connectedUser;
	}

	/**
	 * Modify the connected user and keep the current user for treatment
	 * @param connectedUser
	 */
	public void setConnectedUser(Object connectedUser) {
		this.connectedUser = connectedUser;
	}
	
	
	/**
     * Default constructor of the application fa�ade
     */
    private ApplicationFacade() {
    }
    
    
    
    /**
     * Get the application fa�ade instance
     * @return
     */
    public static ApplicationFacade getInstance(){
    	if (afInstance == null) {
    		afInstance = new ApplicationFacade() ;
    	}
    	return afInstance ;
    }
    
    

    /**
     * Allows the user to login
     * @param name : Username
     * @param pwd : Password of the user
     * @return True : If the user exist in database and username and password match and False : if a problem occur with the database
     */
    public Boolean login(String username, String pwd) {
    	AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
    	ActorDAO actorDAO =  daoFactory.getActorDAO() ;
    	Object user = actorDAO.getActorById(username, pwd) ;
    	String userType = this.getActorType((Actor)user);
    	if(userType!=null) {
    		switch (userType) {
    		case "Administrator" : 
    			AdministratorDAO adminDAO =  daoFactory.getAdministratorDAO();
    			Administrator admin = adminDAO.getById(((Actor) user).getIdActor());
    			connectedUser = admin;
    			break;
    			
    		case "Editor" : 
    			EditorDAO editorDAO = daoFactory.getEditorDAO() ;
    			Editor editor = editorDAO.getEditorById(((Actor) user).getIdActor()) ;
    			connectedUser = editor;
    			break;
    			
    		case "Buyer" : 
    			UserDAO buyerDAO =  daoFactory.getUserDAO();
    			User buyer = buyerDAO.getUserById(((Actor) user).getIdActor());
    			connectedUser = buyer;
    			break;
    			
    		case "SuperAdministrator":
    			
    			break;
        	}
    		
    			
            if(connectedUser != null && (userType.equals("Administrator") || userType.equals("SuperAdministrator"))){
            	this.setEditorsList();
            }
            this.setConsolesList();
    	}
    	
        return connectedUser != null;
    }
    
    
    
	/**
	 * Allows the administrator to get the Editors in the app
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
     * Allows the user to get all console in database
     */
    public void setConsolesList(){
    	AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
    	ConsoleDAO consoleDAO =  daoFactory.getConsoleDAO() ;
    	ArrayList<Console> cs = consoleDAO.getAllConsoles(((Actor) connectedUser).getIdActor());

    	for(int i=0;i<cs.size();i++) {
    		String idItem = cs.get(i).getIdItem();
    		String idConsole = cs.get(i).getIdConsole();
    		String consoleType = cs.get(i).getConsoleType();
    		String nameGame = cs.get(i).getName();
    		String idUser = cs.get(i).getUser();
    		int rating = cs.get(i).getRating();
    		ConsoleCell cellCS = new ConsoleCell(idItem,nameGame, rating,idUser, consoleType, idConsole);
    		consoles.add(cellCS);
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

    /**
     * Allows Administrator to use the list of editors in the app fa�ade
     * @return Observable<EditorCell> editors : all editors of the app
     */
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
     * Allows the user to logoff
     */
    public void logOff(){
    	connectedUser = null;
    }

    /**
     * Allows the SuperAdmin have administrator  list
     * @return All admins of the app
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
	 * Allows the administrators to delete actors or Actor to delete his account
	 * @param id : the Id of the user to delete
	 */
	public void deleteActor(String id) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;

		ActorDAO actorDAO =  daoFactory.getActorDAO() ;
		actorDAO.deleteActor(id);
	}




	/**
	 * Create a post demand with title description price and item, item as a String for the moment
	 * @param title : title of the post
	 * @param descr : description of the post
	 * @param price : price of the item
	 * @param posttype : type of post : Demand or Offer or Trial
	 */
	public void CreatePostDemand(String title, String descr, int price, String posttype, Optional<String> result) {
		AbstractDAOFactory DAOFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		PostDAO postDAO = DAOFactory.getPostDAO();
		String user = ((Actor)connectedUser).getIdActor() ;
		PostTypeDAO posttypeDAO = DAOFactory.getPostTypeDAO();
		String posttypeId = posttypeDAO.getPostTypeId(posttype);
		Post postToSave = new Post(title,descr,price,posttypeId,user,result);
		postDAO.savePost(postToSave);
	}

	
	/**
	 * Delete a post
	 * @param post : Teh post to delete
	 */
	public void DeletePostDemand(Post post) {
		AbstractDAOFactory DAOFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		PostDAO postDAO =  DAOFactory.getPostDAO();
		postDAO.deletePost(post);
	}


	/**
	 * Methods to get the type of the actor
	 * @param actor
	 * @return: a string corresponding to the actor's type
	 */
	public String getActorType(Actor actor) {
		String type = null;
		try {

			if(actor!=null) {
				if (actor.getIsAdministrator()) {
					type = "Administrator";
				}
				else if (actor.getIsBuyer()) {
					type = "Buyer";
				}
				else if (actor.getIsEditor()) {
					type = "Editor";
				}
				else if (actor.getIsSuperAdmin()) {
					type = "SuperAdmin";
				}else {
					type = null;
				}
			}
		}catch (Error e){
			AlertBox.showAlert("No type found for this user","No type found","Erreur");
		}
		return type;
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
	 * Method to set the administrator list in application fa�ade for the super Administrator
	 */
	public void setAdminsList(){
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		AdministratorDAO adminDAO =  daoFactory.getAdministratorDAO();
		ArrayList<Administrator> admins = adminDAO.getAll();
		
		for(int i=0;i<admins.size();i++) {
			AdministratorCell cellAdmin = new AdministratorCell(admins.get(i).getIdActor(), admins.get(i).getUsername(), admins.get(i).getEmail());
			this.administrators.add(cellAdmin);
		}
	}
	
	

	/**
	 * Return the administrator list which is registered in Application fa�ade 
	 * @return Administrators
	 */
	public ObservableList<AdministratorCell> getAdministratorsList(){
		if (this.administrators.size() == 0) {
			setAdminsList() ;
		}
		return this.administrators;
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




	/**
	 * Method to update the editors informations
	 * @param userNameEditor : Editor username
	 * @param emailEditor : Editor email
	 * @param passwordEditor : Editor password
	 * @param zipCodeEditor : Editor zipCode
	 * @param phoneNumberEditor : Editor phone number
	 * @param representativeNameEditor : Editor representative name
	 */
	public void updateEditor(String userNameEditor, String emailEditor, String passwordEditor, String zipCodeEditor,
			String phoneNumberEditor, String representativeNameEditor) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		EditorDAO editorDAO = daoFactory.getEditorDAO();
		editorDAO.updateEditor(((Actor) connectedUser).getIdActor(),userNameEditor, emailEditor, passwordEditor, zipCodeEditor,
				phoneNumberEditor, representativeNameEditor);
		((Editor) connectedUser).setUsername(userNameEditor);
		((Editor) connectedUser).setEmail(emailEditor);
		((Editor) connectedUser).setPhoneNumber(phoneNumberEditor);
		((Editor) connectedUser).setPassword(passwordEditor);
		((Editor) connectedUser).setZipCode(zipCodeEditor);
		((Editor) connectedUser).setRepresentativeName(representativeNameEditor);
	}
	
	/**
	 * Method to add an administrator on the platform
	 * @param email : New admin email
	 * @param username : New admin username
	 * @param pwd : New admin password
	 */
	public void addAdministrator(String email, String username, String pwd) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		AdministratorDAO AdministratorDAO = daoFactory.getAdministratorDAO();
		Administrator admin = new Administrator(null,username,email,pwd) ;
		AdministratorDAO.save(admin);
	}

	/**
	 * Method to delete an administrator
	 * @param admin : Administrator to delete
	 */
	public void deleteAdministrator(Administrator admin) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		AdministratorDAO AdministratorDAO = daoFactory.getAdministratorDAO();
		AdministratorDAO.delete(admin);
	}

	/**
	 * Method to modify admministrator information
	 * @param oldAdmin 
	 * @param newAdmin
	 */
	public void updateAdministrator(Administrator oldAdmin, String email, String username, String pwd) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		AdministratorDAO AdministratorDAO = daoFactory.getAdministratorDAO();
		Administrator newAdmin = new Administrator(null,username,email,pwd) ;
		AdministratorDAO.update(oldAdmin, newAdmin);
	}

	/**
	 * Add a new category on the platform
	 * @param nameCategory
	 */
	public void addCategory(String nameCategory) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		CategoryDAO CategoryDAO = daoFactory.getCategoryDAO();
		Category newCategory = new Category(null,nameCategory) ;
		CategoryDAO.save(newCategory);
	}

	/**
	 * Method to delete a category on the platform
	 * @param category
	 */
	public void deleteCategory(Category category) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		CategoryDAO CategoryDAO = daoFactory.getCategoryDAO();
		CategoryDAO.delete(category);
	}
	
	/**
	 * Method to modfy a category
	 * @param oldCategory
	 * @param nameCategory
	 */
	public void updateCategory(Category oldCategory, String nameCategory) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		CategoryDAO CategoryDAO = daoFactory.getCategoryDAO();
		Category newCategory = new Category(null, nameCategory);
		CategoryDAO.update(oldCategory,newCategory);

	}
	
	/**
	 * Set the game list for the application fa�ade
	 */
	public void setGamesList() {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		GameDAO gameDAO =  daoFactory.getGameDAO();
		ArrayList<Game> games = gameDAO.getAll();
		
		String id;
		String name ;
		int rating = 0 ;
		String consoleType ;
		String description ;
		String category ;
		String idUser;

		for(int i=0;i<games.size();i++) {
			id = games.get(i).getIdItem();
			name = games.get(i).getName() ;
			consoleType = games.get(i).getConsoleType() ;
			description = games.get(i).getDescription() ;
			category = games.get(i).getCategory().getNameCategory() ;
			idUser = games.get(i).getUser();
			GameCell gameCell = new GameCell(id,name, rating, idUser,consoleType, description, category);
			this.games.add(gameCell);
		}
	}
	
	/**
	 * Method to get the gamelist from the application fa�ade
	 * @return game list
	 */
	public ObservableList<GameCell> getGamesList(){
		if (this.games.size() == 0) {
			setGamesList() ;
		}
		return this.games;
	}



	/**
	 * Method to  add a new game in the platform
	 * @param title : title of the game
	 * @param descr : descritption of the gameS
	 */
	 public void CreateGame(String title, String descr) {
	    	AbstractDAOFactory DAOFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
	    	GameDAO gameDAO = DAOFactory.getGameDAO();
	    	String user = ((Actor)connectedUser).getIdActor();
	    	Game gameToSave = new Game(title,descr);
	    	gameDAO.save(gameToSave);
	    }

	/**
	 * 
	 * @return
	 */
	public ObservableList<ConsoleCell> getConsolesList() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param idItem
	 */
	public void deleteConsole(String idItem) {
		// TODO Auto-generated method stub
		
	}
	    
	/**
	 * Method to delete a game
	 * @param game : The game to delete
	 */
	public void deleteGame(Game game) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		GameDAO gameDAO = daoFactory.getGameDAO();
		gameDAO.delete(game);
	}
	
	

	/**
	 * Allow to know the type of the user
	 * @return Boolean : bool
	 */
	public boolean isBuyer() {
		String userType = this.getActorType((Actor)ApplicationFacade.getConnectedUser());
		return  userType == "Buyer";
	}
}