package presentation.userInterface.tableCells;

public class AdministratorCell extends ActorCell{

	public AdministratorCell() {
		super();
	}

	public AdministratorCell(String id, String username, String email) {
		super(id, username, email, false, true, false, false);
	}

}
