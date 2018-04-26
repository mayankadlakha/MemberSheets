import java.sql.SQLException;

public class Controller {
	SQLiteDatabase database;
	

	public Controller() {
		database = new SQLiteDatabase();
		
	}

	public void addNewMember(Member newMember) {
		try {
			database.addMember(newMember);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public Member retrieveMember(String memberId) {
		try {
			Member retrievedMember = database.retrieveMember(memberId);
			return retrievedMember;	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
}
