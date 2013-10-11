package test;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.Arrays;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class NewTestNg {
	private Selenium mSelenium;

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
		Assert.assertTrue(mSelenium.isTextPresent("May we send you updates using e-mail?"));
	}
  
}
