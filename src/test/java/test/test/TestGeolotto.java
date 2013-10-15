package test.test;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import PageObject.User;


public class TestGeolotto  implements Runnable{

	private PageObject.HomePage homePage;
   
	@Test
  (groups="fff")
    public void registerUserTest() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://geolotto.co.uk/");

		User user = User.createValidUser();
		user.setPostCode("73321");
		homePage = new PageObject.HomePage(driver);
		ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
		worker.schedule(this, 1, TimeUnit.MILLISECONDS);
		worker.shutdown();		
		// homePage.clickRegister();
		// (new WebDriverWait(driver, 10))
		// .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstNameText']")));

		PageObject.RegistrationPage registrationPage = new PageObject.RegistrationPage(driver);
		registrationPage.registerUserError(user);
		
    }

	public void run() {
		homePage.clickRegister();
	}



	
}