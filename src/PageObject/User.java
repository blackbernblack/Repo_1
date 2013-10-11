package PageObject;

public class User {
	public String title = "Mr";
	public String gender = "M";
	public String firstName = "Vin";
	public String mideleName = "Mak";
	public String lastName = "Diesel";
	public String email = "wmmpoken@sharklasers.com";
	public String confirmMail = "wmmpoken@sharklasers.com";
	public String dayBirth = "12";
	public String monthBirth = "Ju";
	public String yearBirth = "2000";
	public String postCode = "73000";
	public String password = "123456789";
	public String passwordConfirmation = "123456789";
	
	public static User createValidUser() {
		
		return new User();
	}
}
