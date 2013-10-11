package test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.thoughtworks.selenium.Wait;

public class HomePage {  
    
    private final WebDriver driver;  
  
    //private final static Logger logger = LoggerFactory.getLogger(HomePage.class);  
  
    public HomePage(WebDriver driver) {  
        super();  
        this.driver = driver;  
  
        FluentWait wait = new FluentWait(driver)  
           .withTimeout(30, TimeUnit.SECONDS)  
           .pollingEvery(2, TimeUnit.SECONDS);  
  
         wait.until(ExpectedConditions.titleIs("Your Contacts"));  
  
    }  
  
    public String getHomePageWelcomeMessage() throws Exception{  
  
        return driver.findElement(By.xpath("/html/body/h1")).getText();  
  
    }  
  
}  