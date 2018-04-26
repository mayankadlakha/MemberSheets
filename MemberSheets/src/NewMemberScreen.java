import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewMemberScreen extends MemberScreen{
	JTextField firstNameTextField;
	JTextField lastNameTextField;
	JTextField idTextField;

	buttonActionListener buttonOnClickListener = new buttonActionListener();
	
	public NewMemberScreen(GUI guiIn, Member memberIn) {
		super(guiIn, memberIn);
		
		//Add Member Button
		mainActionButton = new JButton(this.mainActionButtonText);
		mainActionButton.setOpaque(true);
		mainActionButton.setBackground(Color.GREEN);
		mainActionButton.addActionListener(buttonOnClickListener);
		add(mainActionButton);
		
		//Cancel Button
		cancelButton = new JButton(this.cancelButtonText);
		cancelButton.addActionListener(buttonOnClickListener);
		add(cancelButton);
	}
	
	public void addElements() {
		//First Name
		add(firstNameLabel);
		firstNameTextField = new JTextField();
		add(firstNameTextField);
		
		//Last name
		add(lastNameLabel);
		lastNameTextField = new JTextField();
		add(lastNameTextField);
		
		//ID
		add(idLabel);
		idTextField = new JTextField();
		add(idTextField);
	}
	
	class buttonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == mainActionButton){
				String memberFirstName = firstNameTextField.getText();
				String memberLastName = lastNameTextField.getText();
				String memberId = idTextField.getText();
				member = new Member( memberId, memberFirstName, memberLastName);
				
			}
			gui.addNewMember(member);
		}
		
	}
}
