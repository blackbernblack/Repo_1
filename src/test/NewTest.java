package test;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class NewTest {
	private Selenium mSelenium;
	
	
	public void testExample() {
		  WebDriver driver = new FirefoxDriver();

	        // And now use this to visit Google
		  driver.get("http://www.google.com");

		// Now set the cookie. This one's valid for the entire domain
		Cookie cookie = new Cookie("key", "value");
		driver.manage().addCookie(cookie);

		// And now output all the available cookies for the current URL
		Set<Cookie> allCookies = driver.manage().getCookies();
		for (Cookie loadedCookie : allCookies) {
		    System.out.println(String.format("%s -> %s", loadedCookie.getName(), loadedCookie.getValue()));
		}
		driver.manage().deleteAllCookies();
	}
	
	
	public void testWDGoogle() {
		String siteName = "https://www.google.com.ua/";
		WebDriver webdriver = new FirefoxDriver();
		webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		webdriver.get(siteName);
		WebElement edit = webdriver.findElement(By.id("gbqfq"));
		edit.sendKeys("TestNg");
		
		webdriver.findElement(By.id("gbqfb")).click();
		webdriver.findElement(By.xpath("//ol[@id='rso']/li[2]/div/h3/a")).click();
	}
	
	public static String[] getAllCheckboxIds (Selenium selenium) {
        String script = "var inputId  = new Array();";// Create array in java script.
        script += "var cnt = 0;"; // Counter for check box ids.
        script += "var inputFields  = new Array();"; // Create array in java script.
        script += "inputFields = window.document.getElementsByTagName('input');"; // Collect input elements.
        script += "for(var i=0; i<inputFields.length; i++) {"; // Loop through the collected elements.
        script += "if( inputFields[i].getAttribute('type') == 'checkbox') {"; // If input field is of type check box and input id is not null.
        script += "inputId[cnt]=inputFields[i].value ;" + // Save check box id to inputId array.
        "cnt++;" + // increment the counter.
        "}" + // end of if.
        "}"; // end of for.
        script += "inputId.toString();" ;// Convert array in to string.
        String[] checkboxIds = selenium.getEval(script).split(","); // Split the string.
        return checkboxIds;
}

	@Test
	public void testGoogle() {
			
		mSelenium = new DefaultSelenium ("localhost",4444,"*firefox","http://www.nngroup.com/articles/checkboxes-vs-radio-buttons");
		mSelenium.start();
		mSelenium.setTimeout("90000");
		mSelenium.open("http://www.nngroup.com/articles/checkboxes-vs-radio-buttons/");
		
		mSelenium.click("permission");
		System.out.println(Arrays.toString(getAllCheckboxIds(mSelenium)));
		System.out.println(mSelenium.isTextPresent("May we send you updates using e-mail?"));
		
		//mSelenium.type("//input[@id='gbqfq']", "testNg");
		
		
		
		
//		mSelenium.click("//button[@id='gbqfb']");
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(mSelenium.getText("//ol[@id='rso']/li[2]/div/h3/a"));
//		
//	    mSelenium.click("//ol[@id='rso']/li[2]/div/h3/a");
//	    
//		mSelenium.setTimeout("30000");
		
		//mSelenium.stop();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@AfterTest
	
	public void afterTest() {
		System.out.println("afterTest");
		
	}
	
	

}
