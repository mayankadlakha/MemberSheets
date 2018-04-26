import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class MemberScreen extends JPanel{
	String firstName = "First Name";
	String lastName = "Last Name";
	String id = "Student Id";
	String mainActionButtonText = "Add Member";
	String cancelButtonText = "Cancel";
	JLabel firstNameLabel = new JLabel(this.firstName);
	JLabel lastNameLabel = new JLabel(this.lastName);
	JLabel idLabel = new JLabel(this.id);
	JButton cancelButton = new JButton(this.cancelButtonText);
	JButton mainActionButton = new JButton(this.mainActionButtonText);
	int gridRows = 6;
	int gridColumns = 2;
	GUI gui;
	Member member;
	
	
	public MemberScreen(GUI guiIn, Member member) {
		this.gui = guiIn;
		this.member = member;
		
		GridLayout gridLayout = new GridLayout(gridRows, gridColumns);
		setLayout(gridLayout);
		
		addElements();
	}
	
	public abstract void addElements();
}
