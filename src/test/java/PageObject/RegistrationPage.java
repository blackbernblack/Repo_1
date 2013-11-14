package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class RegistrationPage {
 
    private static final String firstNamePath = "//input[@name='firstNameText']";
	private static final String midleNamePath = "//input[@name='middleNameText']";
	private static final String lastNamePath = "//input[@name='lastNameText']";
	private static final String emailTextPath = "//input[@name='emailText']";
	private static final String confirmEmailTextPath = "//input[@name='confirmEmailText']";
	private static final String dateTextPath = "//input[@name='dateText']";
	private static final String yearTextPath = "//input[@name='yearText']";
	private static final String passwordTextPath = "//input[@name='passwordText']";
	private static final String confirmPasswordTextPath = "//input[@name='confirmPasswordText']";
	private static final String createAccountBtnPath = "//input[@value='Create Account']";
	private static final String postCodePath = "//input[@name='addressPanel:postcodeSearchPanel:postcodeSearchText']";
	private static final String genderPath = "//div[@class='b-formItemColHolder']/div[last()]//div[@class='b-formItemRow']/div";
	private static final String userNamePath = "//input[@name='usernameText']";
	private static final String postValidatorPath = "//p[@class='b-formErrorText']";
	private static final String monthPath = "//div[@class='b-fakeSelect b-form-select b-registerPopup-select-month collapsible']/div[1]/div[2]";
	private static final String titleMrPath = "//div[text()='Mr']";
	private static final String monthSeptemberPath = "//div[@class='b-fakeSelect-options collapsible']//div[9]";
	
    private WebDriver driver;
    
    @FindBy(xpath = createAccountBtnPath)
    public WebElement createAccountBtn;
    
    @FindBy(xpath = userNamePath)
	public WebElement userName;
    
    @FindBy(xpath = postValidatorPath)
  	public WebElement postValidator;
    
	@FindBy(xpath = firstNamePath)
	public WebElement firstName;
	
	@FindBy(xpath = midleNamePath)
	public WebElement mideleName;
	
	@FindBy(xpath = lastNamePath)
	public WebElement lastName;
	
	@FindBy(xpath = emailTextPath)
	public WebElement email;
	
	@FindBy(xpath = confirmEmailTextPath)
	public WebElement confirmMail;
	
	@FindBy(xpath = dateTextPath)
	public WebElement dayBirth;
	
	@FindBy(xpath = passwordTextPath)
	public WebElement password;
	
	@FindBy(xpath = confirmPasswordTextPath)
	public WebElement passwordConfirmation;
	
	@FindBy(xpath = yearTextPath)
	public WebElement yearBirth;
	
	@FindBy(xpath = postCodePath)
	public WebElement postCode;
	
	@FindBy(xpath = monthPath)
	public WebElement monthBirth;
	
    @FindBy(xpath = genderPath)
	public WebElement gender;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
 
    /**
     * Регистраци пользователя
     * @param user - {@link User}
     */
    private void registerUser(User user) {
    	waitForElementPresent(firstNamePath);
        firstName.sendKeys(user.getFirstName());
        mideleName.sendKeys(user.getMideleName());
        lastName.sendKeys(user.getLastName());
        email.sendKeys(user.getEmail());
        confirmMail.sendKeys(user.getConfirmMail());
        dayBirth.sendKeys(user.getDayBirth());
        yearBirth.sendKeys(user.getYearBirth());
        password.sendKeys(user.getPassword());
        passwordConfirmation.sendKeys(user.getPassword());
        postCode.sendKeys(user.getPostCode());
        userName.sendKeys(user.getUserName());
        driver.findElement(By.cssSelector("div.b-fakeSelect-current-arrow")).click();
        driver.findElement(By.xpath(titleMrPath)).click();
        monthBirth.click();
        driver.findElement(By.xpath(monthSeptemberPath)).click();
        gender.click();
        gender.sendKeys("F");
        createAccountBtn.click();
    }
    
    public boolean isPostValidatorPresent() {
    	waitForElementPresent(postValidatorPath);
    	return driver.findElements(By.xpath(postValidatorPath)).size() != 0;
    }
    
    public void waitForElementPresent(final String xpath){
    	  WebDriverWait wait = new WebDriverWait(driver, 10);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//		while (driver.findElements(By.xpath(xpath)).size() == 0) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
 
	public HomePage registerUserSuccess(User user) {
		registerUser(user);
		return new HomePage(driver);
	}

	public RegistrationPage registerUserError(User user) {
		registerUser(user);
		return new RegistrationPage(driver);
	}
}