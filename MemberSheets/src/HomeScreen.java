import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class HomeScreen extends JPanel{
	GUI gui;
	buttonActionListener buttonOnClickListener = new buttonActionListener();
	JLabel appTitleLabel;
	JButton newMemberButton;
	JButton viewMemberButton;
	JTextField viewMemberTextField;
	JLabel errorReport;
	String appTitle = "MemberSheets";
	String appSubtitle = "Monash Association of Debaters";
	String newMemberButtonText = "New Member";
	String viewMemberButtonText = "Lookup Member";
	String viewMemberLabel = "Student ID: ";
	
	public HomeScreen(GUI guiIn) {	
		this.gui = guiIn;
		
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(boxLayout);
		
		addTitles();
		addViewMemberElements();
		addErrorReportingElements();
		addNewMemberElements();
		
	}
	
	public void showError(String error) {
		errorReport.setText(error);
	}
	
	public void refresh() {
		this.viewMemberTextField.setText("");
		this.errorReport.setText("");
	}
	
	private void addTitles() {
		//Title
		JPanel appTitlePanel = new JPanel();
		add(appTitlePanel);
		this.appTitleLabel = new JLabel(this.appTitle);
		this.appTitleLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		appTitlePanel.add(this.appTitleLabel);
		
		//Subtitle
		JLabel appSubTitle = new JLabel(this.appSubtitle);
		appSubTitle.setFont(new Font("Times New Roman", Font.ITALIC, 20));
			appTitlePanel.add(appSubTitle);
}
	
	private void addViewMemberElements() {
		//ViewMemberPanel
		JPanel viewMemberPanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout();
		viewMemberPanel.setLayout(flowLayout);
		add(viewMemberPanel);
		
		//ViewMemberLabel
		JLabel viewMemberTitleLabel = new JLabel(this.viewMemberLabel);
		viewMemberPanel.add(viewMemberTitleLabel);
		
		//ViewMemberTextField
		viewMemberTextField = new JTextField();
		viewMemberTextField.setPreferredSize(new Dimension(150, 25));
		viewMemberTextField.setMinimumSize(viewMemberTextField.getPreferredSize());
		viewMemberPanel.add(viewMemberTextField);
		
		//ViewMemberButton
		this.viewMemberButton = new JButton(this.viewMemberButtonText);
		this.viewMemberButton.addActionListener(buttonOnClickListener);
		viewMemberPanel.add(this.viewMemberButton);
	}
	
	private void addErrorReportingElements() {
		JPanel errorReportingPanel = new JPanel();
		add(errorReportingPanel);
		errorReport = new JLabel();
		errorReport.setForeground(Color.RED);
		errorReport.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		errorReportingPanel.add(errorReport);
	}
	private void addNewMemberElements() {
		JPanel newMemberPanel = new JPanel();
		add(newMemberPanel);
		this.newMemberButton = new JButton(this.newMemberButtonText);
		this.newMemberButton.addActionListener(buttonOnClickListener);
		newMemberPanel.add(this.newMemberButton);
	}
	
	class buttonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == newMemberButton){
				gui.showNewMemberScreen();	
			}else if(event.getSource() == viewMemberButton){
				String memberId = viewMemberTextField.getText();
				gui.showViewMemberScreen(memberId);	
			}
		}
		
	}
}

