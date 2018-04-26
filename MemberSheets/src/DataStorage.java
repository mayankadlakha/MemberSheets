

import java.sql.SQLException;

public interface DataStorage {
	void addMember(Member member) throws SQLException, ClassNotFoundException;
	
	void deleteMember(Member member);
	
	Member retrieveMember(String memberId) throws ClassNotFoundException, SQLException;
	
}

