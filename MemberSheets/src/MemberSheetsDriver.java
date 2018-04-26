
public class MemberSheetsDriver {

	public static void main(String[] args) {
		SQLiteDatabase database = new SQLiteDatabase();
		Controller controller = new Controller(database);
		GUI gui = new GUI(controller);
	}

}

