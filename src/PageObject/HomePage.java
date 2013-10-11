package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class HomePage {
 
    private WebDriver driver;
 
    /**
     * Имя пользователя
     */
    @FindBy(id = "profilename")
    private WebElement userName;
 
    /**
     * Выход
     */
    @FindBy(linkText = "Выход")
    private WebElement exit;
 
    /**
     * Элементы меню
     */
    @FindBy(className = "menu_item")
    private List<WebElement> menuItems;
 
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}