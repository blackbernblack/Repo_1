import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;


/**
 * Created with IntelliJ IDEA.
 * User: tkonstantinov
 * Date: 03.10.2013
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 */
public class Test {
	
	public static void main(String[] args) {
		Selenium selenium = new DefaultSelenium ("localhost",4444,"*firefox","https://www.google.com.ua/?hl=ru");
		
		 selenium.start();
	        selenium.setTimeout("90000");
	        selenium.open("https://geolotto.co.uk/?0");
	       // selenium.type("//input[@id='gbqfq']", "asdasdasasdasdasdd");
	        selenium.click("//*[@id='id10']/a");
	    
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //selenium.type("//input[@name='lastNameText']", "value");
	        selenium.click("//div[@class='b-formItemColHolder']/div[last()]//div[@class='b-formItemRow']/div/div[1]");
	      

	}

//	private Selenium selenium;
//	
//	@Before
//	public void setUp() throws Exception {
//		Selenium selenium = new DefaultSelenium ("localhost",4444,"*firefox","https://www.google.com.ua/?hl=ru");
//		selenium.start();
//	}
//
//	@org.junit.Test
//	public void testAdvancedSearch() throws Exception {
//		selenium.open("https://www.google.com.ua/?hl=ru");
//	
//		selenium.waitForPageToLoad("30000");
//	
//		selenium.click("gbqfbb");
////Thread.sleep(2000);
////		selenium.waitForPageToLoad("30000");
//		System.out.println("asda");
//		selenium.focus("//input");
//		System.out.println("asda1");
//		selenium.click("//input");
//		System.out.println("asda2");
//		selenium.type("//input", "selftechy, selenium, eclipse");
//		System.out.println("asda3");
////		selenium.select("num", "label=20 results");
////		selenium.click("//input[@value='Advanced Search']");
//
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		selenium.stop();
//	}
}
