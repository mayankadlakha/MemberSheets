import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewMemberScreen  extends MemberScreen {
	JTextField firstNameTextField;
	JTextField lastNameTextField;
	JTextField idTextField;
	String backToHomeButtonText = "Back to Home";
	buttonActionListener buttonOnClickListener = new buttonActionListener();
	
	public ViewMemberScreen(GUI guiIn, Member memberIn){
		super(guiIn, memberIn);	
		
		//Cancel Button
		cancelButton = new JButton(this.backToHomeButtonText);
		cancelButton.addActionListener(buttonOnClickListener);
		add(cancelButton);
	}
	
	@Override
	public void addElements() {
		//First Name
		add(firstNameLabel);
		JLabel firstNameResult = new JLabel(member.getFirstName());
		add(firstNameResult);
		
		//Last Name
		add(lastNameLabel);
		JLabel lastNameResult = new JLabel(member.getLastName());
		add(lastNameResult);
		
		//ID
		add(idLabel);
		JLabel idResult = new JLabel(member.getId());
		add(idResult);
	}
	
	class buttonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			gui.showHomeScreen();
		}
		
	}
}
