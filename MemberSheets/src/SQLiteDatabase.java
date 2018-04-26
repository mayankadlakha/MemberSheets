
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDatabase implements DataStorage{
	static Connection connector;
	MemberTable memberTable = new MemberTable();
	
	@Override
	public void addMember(Member member) throws ClassNotFoundException, SQLException {
		getConnection();	
		memberTable.insert(connector, member);
	}

	@Override
	public Member retrieveMember(String memberId) throws ClassNotFoundException, SQLException {
		getConnection();
		Member retrievedMember = memberTable.select(connector, memberId);
		return retrievedMember;
	}
	
	@Override
	public void deleteMember(Member member) {
	}
	
	private void getConnection() throws ClassNotFoundException, SQLException {
		if(connector == null) {
			Class.forName("org.sqlite.JDBC");
			connector = DriverManager.getConnection("jdbc:sqlite:SQLiteDatabase.db");
		}
	}
	
	

}

