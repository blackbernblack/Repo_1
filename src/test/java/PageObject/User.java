package PageObject;

public class User {
	public String title = "Mr";
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMideleName() {
		return mideleName;
	}

	public void setMideleName(String mideleName) {
		this.mideleName = mideleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmMail() {
		return confirmMail;
	}

	public void setConfirmMail(String confirmMail) {
		this.confirmMail = confirmMail;
	}

	public String getDayBirth() {
		return dayBirth;
	}

	public void setDayBirth(String dayBirth) {
		this.dayBirth = dayBirth;
	}

	public String getMonthBirth() {
		return monthBirth;
	}

	public void setMonthBirth(String monthBirth) {
		this.monthBirth = monthBirth;
	}

	public String getYearBirth() {
		return yearBirth;
	}

	public void setYearBirth(String yearBirth) {
		this.yearBirth = yearBirth;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String gender = "M";
	public String userName = "userName";
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

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
