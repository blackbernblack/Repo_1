package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.User;

public class TestGeolotto {
  
    @Test
    public void registerUserTest() {
    	WebDriver driver = new FirefoxDriver();
	    driver.get("https://geolotto.co.uk/");
	   // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        User user = User.createValidUser();
        
        
        driver.findElement(By.xpath("//*[@id='id10']/a")).click();
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
        		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstNameText']")));
        
        PageObject.RegistrationPage registrationPage =  new PageObject.RegistrationPage(driver);
        registrationPage.registerUserError(user).checkErrorMessage("errorMessage");
    }
}