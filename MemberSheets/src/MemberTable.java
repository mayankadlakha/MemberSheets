
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberTable {
	String tableName;
	boolean tableExists = false;


	public void insert(Connection connector, Member member) throws SQLException {
		initialise(connector);
		
		PreparedStatement prepStatement = connector.prepareStatement("INSERT INTO member VALUES(?, ?, ?);");
		prepStatement.setString(1, member.getId());
		prepStatement.setString(2, member.getFirstName());
		prepStatement.setString(3, member.getLastName());
		prepStatement.execute();
		
	}


	public Member select(Connection connector, String memberId) throws SQLException {
		initialise(connector);
		
		Statement statement = connector.createStatement();
		ResultSet result = statement.executeQuery("SELECT firstname, lastname FROM member WHERE id = " + memberId + ";");
		
		Member retrievedMember = null;
		if(result.next()) {
			retrievedMember = new Member(memberId, result.getString("firstname"), result.getString("lastname"));
		}
		
		return retrievedMember;
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	private void initialise(Connection connector) throws SQLException {
		if(!tableExists) {
			tableExists = true;
			Statement statement = connector.createStatement();
			ResultSet result = statement.executeQuery("SELECT name FROM sqlite_master WHERE type = 'table' AND name = 'member'");
			
			if(!result.next()) {
				Statement statement2 = connector.createStatement();
				statement2.execute("CREATE TABLE member(id varchar(60),"
						+ "firstname varchar(60)," + "lastname varchar(60),"
						+ "primary key(id));");
			}
		}
	}

}
