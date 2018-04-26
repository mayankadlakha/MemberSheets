
public class Member {
	private String firstName;
	private String lastName;
	private String id;
	private String membershipStartDate;
	private String membershipExpiryDate;
	
	public Member( String idIn, String firstNameIn, String lastNameIn) {
		this.firstName = firstNameIn;
		this.lastName = lastNameIn;
		this.id = idIn;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getId() {
		return this.id;
	}
}
