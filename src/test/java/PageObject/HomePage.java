package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class HomePage {
 
	private static final String registerBtnPath = "//*[@id='id10']/a";
	 
    private WebDriver driver;
    
    @FindBy(xpath = registerBtnPath)
    public WebElement registerBtn;
   
    @FindBy(id = "profilename")
    private WebElement userName;
    
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
    public void clickRegister(){
    	registerBtn.click();
    }
}