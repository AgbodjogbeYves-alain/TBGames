 
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
import presentation.userInterface.tableCells.BuyerCell;
import presentation.userInterface.tableCells.EditorCell;
import presentation.userInterface.tableCells.GameCell;
import persistence.* ;

/**
 * 
 */
public class ApplicationFacade {

	private static ApplicationFacade afInstance = null ;
	private static Object connectedUser = null ;
	public static Object getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(Object connectedUser) {
		this.connectedUser = connectedUser;
	}

	private ObservableList<EditorCell> editorsToValid = FXCollections.observableArrayList();
	private ObservableList<EditorCell> editors = FXCollections.observableArrayList();
	private ObservableList<ConsoleCell> consoles = FXCollections.observableArrayList();
	private ObservableList<AdministratorCell> administrators = FXCollections.observableArrayList();
	private ObservableList<GameCell> games = FXCollections.observableArrayList();
	private ObservableList<BuyerCell> buyers = FXCollections.observableArrayList();

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
		String userType = this.getActorType((Actor)user);
		if(userType!=null) {
			switch (userType) {
			case "Administrator" : 
				AdministratorDAO adminDAO =  daoFactory.getAdministratorDAO();
				Administrator admin = adminDAO.getById(((Actor) user).getIdActor());
				this.setEditorsList();
				this.setEditorNotValidate();
				this.setBuyerList();
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
	 * 
	 */
	public void setBuyerList() {
    	AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
    	UserDAO buyerDAO =  daoFactory.getUserDAO() ;
    	ArrayList<Buyer> buyer = buyerDAO.getAllBuyers();
    	
    	for(int i=0; i<buyer.size();i++) {
    		String idActor = buyer.get(i).getIdActor();
    		String idSimpleUser = buyer.get(i).getIdSU();
    		String idBuyer = buyer.get(i).getIdBuyer();
    		String username = buyer.get(i).getUsername();
    		String email = buyer.get(i).getEmail();
    		String zipcode = buyer.get(i).getZipCode();
    		String phoneNumber = buyer.get(i).getPhoneNumber();
    		BuyerCell cellBuyer = new BuyerCell(idActor,idSimpleUser,idBuyer,username, email,zipcode,phoneNumber);
    		buyers.add(cellBuyer);
    	}
    }
	
	/**
	 * 
	 */
	public void setEditorNotValidate(){
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		EditorDAO editorDAO =  daoFactory.getEditorDAO() ;
		ArrayList<Editor> ed = editorDAO.getAllEditorsNV();

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
			editorsToValid.add(cellEd);
		}
	}

	/**
	 * 
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
	 * 
	 * @return
	 */
	public ObservableList<EditorCell> getEditorsList(){
		return this.editors;
	}
	
	public ObservableList<BuyerCell> getBuyersList(){
		return this.buyers;
	}
	
	/**
	 * 
	 * @return
	 */
	public ObservableList<EditorCell> getEditorsToValidList(){
		return this.editorsToValid;
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
	public void logOff(){
		connectedUser = null;
		this.editors = null;
		this.administrators = null;
		this.buyers = null;
		this.consoles = null;
		this.editorsToValid = null;
		this.games = null;
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




	/**
	 * Create a post demand with title description price and item, item as a String for the moment
	 * @param title
	 * @param descr
	 * @param price
	 * @param posttype
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
	 * @param post
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
	 * 
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
	 * @return
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
	 * @param email
	 * @param username
	 * @param pwd
	 */
	public void addAdministrator(String email, String username, String pwd) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		AdministratorDAO AdministratorDAO = daoFactory.getAdministratorDAO();
		Administrator admin = new Administrator(null,username,email,pwd) ;
		AdministratorDAO.save(admin);
	}

	/**
	 * @param admin
	 */
	public void deleteAdministrator(Administrator admin) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		AdministratorDAO AdministratorDAO = daoFactory.getAdministratorDAO();
		AdministratorDAO.delete(admin);
	}

	/**
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
	 * @param nameCategory
	 */
	public void addCategory(String nameCategory) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		CategoryDAO CategoryDAO = daoFactory.getCategoryDAO();
		Category newCategory = new Category(null,nameCategory) ;
		CategoryDAO.save(newCategory);
	}

	/**
	 * @param category
	 */
	public void deleteCategory(Category category) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		CategoryDAO CategoryDAO = daoFactory.getCategoryDAO();
		CategoryDAO.delete(category);
	}

	/**
	 * 
	 * @param oldCategory
	 * @param nameCategory
	 */
	public void updateCategory(Category oldCategory, String nameCategory) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		CategoryDAO CategoryDAO = daoFactory.getCategoryDAO();
		Category newCategory = new Category(null, nameCategory);
		CategoryDAO.update(oldCategory,newCategory);

	}

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
	 * @return
	 */
	public ObservableList<GameCell> getGamesList(){
		if (this.games.size() == 0) {
			setGamesList() ;
		}
		return this.games;
	}



	/**
	 * 
	 * @param title
	 * @param descr
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

	public void deleteConsole(String idItem) {
		// TODO Auto-generated method stub

	}


	public void deleteGame(Game game) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		GameDAO gameDAO = daoFactory.getGameDAO();
		gameDAO.delete(game);
	}

	public boolean isBuyer() {
		String userType = this.getActorType((Actor)ApplicationFacade.getConnectedUser());
		return  userType == "Buyer";
	}

	public void validateEditor(String editor) {
		AbstractDAOFactory daoFactory = AbstractDAOFactory.getFactory("postgresql","tbgames","localhost","5432","postgres","admin") ;
		EditorDAO editorDAO =  daoFactory.getEditorDAO();
		editorDAO.validateEditor(editor);
	}
}