import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import junit.framework.TestCase;

public class TestSQLiteDatabase extends TestCase{
	SQLiteDatabase database;
	Connection connector;
	Random rand;
	
	protected void setUp() throws ClassNotFoundException, SQLException{
		database = new SQLiteDatabase();
		getConnection();
		rand = new Random();
	}
	
	private void getConnection() throws SQLException, ClassNotFoundException {
		if(connector == null) {
			Class.forName("org.sqlite.JDBC");
			connector = DriverManager.getConnection("jdbc:sqlite:SQLiteDatabase.db");
		}
	}
	
	public void testAddMember() throws SQLException, ClassNotFoundException {
		//Setup
		int memberIdInt = rand.nextInt(5000);
		String memberId = Integer.toString(memberIdInt);
		Member member = new Member(memberId, "Manuel", "Lopez");
		database.addMember(member);
		
		//Expected Value
		Statement statement = connector.createStatement();
		ResultSet result = statement.executeQuery("SELECT firstname, lastname FROM member WHERE id = "+memberId+";");
		result.next();
		
		//Result
		assertEquals(result.getString("firstname"), "Manuel");
	}
	
//	public void testRetrieveMember() throws SQLException, ClassNotFoundException {
//		//Setup
//		int memberIdInt = rand.nextInt(5000);
//		String memberId = Integer.toString(memberIdInt);
//		PreparedStatement prepStatement = connector.prepareStatement("INSERT INTO member VALUES(?, ?, ?);");
//		prepStatement.setString(1, memberId);
//		prepStatement.setString(2, "Ravi");
//		prepStatement.setString(3, "Shankar");
//		prepStatement.execute();
//		
//		//Expected Value
//		Member retrievedMember = database.retrieveMember(memberId);
//		String expectedResult = (retrievedMember.getFirstName());
//		
//		//Result
//		assertEquals(expectedResult, "Ravi");
//	}
}
