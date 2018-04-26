import javax.swing.JFrame;

public class GUI {
	int screenWidth = 500;
	int screenHeight = 500;
	HomeScreen homeScreen;
	JFrame mainFrame;
	Controller controller;
	NewMemberScreen addMemberScreen;
	ViewMemberScreen viewMemberScreen;
	String memberNotFoundError = "ERROR: Member with this ID not found in Database.";
	
	public GUI(Controller controllerIn) {
		this.controller = controllerIn;
		setupFrame();
	}
	
	public void setupFrame() {
		this.mainFrame = new JFrame();
		this.mainFrame.setSize(screenWidth, screenHeight);;
		this.mainFrame.setLocationRelativeTo(null);
		this.mainFrame.setTitle("Home");
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Adding home screen
		homeScreen = new HomeScreen(this);
		this.mainFrame.add(homeScreen);
		
		this.mainFrame.setVisible(true);
	}
	
	public void showViewMemberScreen(String memberId) {
		//Retrieve member from data storage
		Member member = controller.retrieveMember(memberId);
		
		if(member == null) {
			this.homeScreen.showError(memberNotFoundError);
		}else {
			//setup ViewMemberScreen
			this.homeScreen.setVisible(false);
			viewMemberScreen = new ViewMemberScreen(this, member);
			viewMemberScreen.setVisible(true);
			this.mainFrame.add(viewMemberScreen);
			this.mainFrame.setTitle(member.getFirstName() + " " + member.getLastName());
		}
	}
	
	public void showNewMemberScreen() {
		this.homeScreen.setVisible(false);
		addMemberScreen = new NewMemberScreen(this, new Member(null, null, null));
		this.mainFrame.add(addMemberScreen);
		this.mainFrame.setTitle("New Member");
		addMemberScreen.setVisible(true);
	}
	
	public void addNewMember(Member newMember) {
		if(newMember != null) {
			controller.addNewMember(newMember);
		}
		this.homeScreen.setVisible(true);
		this.homeScreen.refresh();
		this.mainFrame.setTitle("Home");
		this.mainFrame.remove(addMemberScreen);
		
	}

	public void showHomeScreen() {
		this.mainFrame.remove(viewMemberScreen);
		this.homeScreen.setVisible(true);
		this.homeScreen.refresh();
		this.mainFrame.setTitle("Home");
	}
}