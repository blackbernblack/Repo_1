package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.thoughtworks.selenium.Wait;

public class LoginPage {  
    
    private final WebDriver driver;  
  
    public LoginPage(WebDriver driver) {  
        super();  
        this.driver = driver;  
  
        FluentWait wait = new FluentWait(driver)  
           .withTimeout(30, TimeUnit.SECONDS)  
           .pollingEvery(2, TimeUnit.SECONDS);  
  
         wait.until(ExpectedConditions.titleIs("Login"));  
    }  
  
    public HomePage loginAs(String username, String password) {  
  
        executeLogin(username, password);  
        return new HomePage(driver);  
    }  
  
    public void failLoginAs(String username, String password) {  
        executeLogin(username, password);  
    }  
  
    private void executeLogin(String username, String password) {  
  
        driver.findElement(By.name("j_username")).sendKeys(username);  
        driver.findElement(By.name("j_password")).sendKeys(password);  
        driver.findElement(By.name("submit")).submit();  
    }  
  
    public String getErrorMessage() {  
  
        return driver.findElement(By.xpath("/html/body/p/font[@color='red']")).getText();  
    }  
  
}  