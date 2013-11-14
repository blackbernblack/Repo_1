package test.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import PageObject.User;

public class pagesTest {
	
	@Test
	public void testSomeFails() {
		assertEquals(true, false, "Values are not equal");
	}

	@Test
	public void testRegistration() {
		testWebDriver();
	}

	public void testWebDriver() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://geolotto.co.uk/");
		User user = User.createValidUser();
		user.setPostCode("73321");
		PageObject.HomePage homePage = new PageObject.HomePage(driver);
		homePage.clickRegister();
		PageObject.RegistrationPage registrationPage = new PageObject.RegistrationPage(driver);
		registrationPage.registerUserError(user);
		assertTrue(registrationPage.isPostValidatorPresent(), "Post validator is not found");
		driver.close();
		driver.quit();
	}
}
