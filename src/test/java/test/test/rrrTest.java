package test.test;

import org.testng.annotations.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class rrrTest {

	@Test
	public void main() {
	    System.out.println("HELLLLLLLLLooooo");
	    System.out.println("2туч€евшращдвырадр");
	    try {
	    	Thread.sleep(10000);
			//testGoogle();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testGoogle() {
			
		Selenium mSelenium = new DefaultSelenium ("localhost",4444,"*firefox","http://www.nngroup.com/articles/checkboxes-vs-radio-buttons");
		mSelenium.start();
		mSelenium.setTimeout("90000");
		mSelenium.open("http://www.nngroup.com/articles/checkboxes-vs-radio-buttons/");
		
		mSelenium.click("permission");
		System.out.println(mSelenium.isTextPresent("May we send you updates using e-mail?"));
	}
}
