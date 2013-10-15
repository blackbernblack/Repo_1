package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
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
	
    private WebDriver driver;
    
    @FindBy(xpath = createAccountBtnPath)
    public WebElement createAccountBtn;
    
    @FindBy(xpath = userNamePath)
	public WebElement userName;
    
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
	
	@FindBy(xpath = "//div[@class='b-fakeSelect b-form-select b-registerPopup-select-month collapsible']/div[1]/div[2]")
	public WebElement monthBirth;
	
	
    @FindBy(xpath = genderPath)
	public WebElement gender;

    public RegistrationPage(WebDriver driver) {
        // проверить, что вы находитесь на верной странице
//        if (!driver.getCurrentUrl().contains(URL_MATCH)) {
//                    throw new IllegalStateException(
//                        "This is not the page you are expected"
//                        );
//        }
 
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
 
    /**
     * Регистраци пользователя
     * @param user - {@link User}
     */
    private void registerUser(User user) {
    	waitForElementPresent(firstNamePath);
        firstName.sendKeys(user.firstName);
        mideleName.sendKeys(user.mideleName);
        lastName.sendKeys(user.lastName);
        email.sendKeys(user.email);
        confirmMail.sendKeys(user.confirmMail);
        dayBirth.sendKeys(user.dayBirth);
        yearBirth.sendKeys(user.yearBirth);
        password.sendKeys(user.password);
        passwordConfirmation.sendKeys(user.passwordConfirmation);
        postCode.sendKeys(user.postCode);
        userName.sendKeys(user.userName);
        driver.findElement(By.cssSelector("div.b-fakeSelect-current-arrow")).click();
        driver.findElement(By.xpath("//div[text()='Mr']")).click();
        monthBirth.click();
        
        driver.findElement(By.xpath("//div[@class='b-fakeSelect-options collapsible']//div[9]")).click();
        
        gender.click();
        
        gender.sendKeys("F");
        createAccountBtn.click();
    }
    
    public void waitForElementPresent(final String elementPath){
    	while(driver.findElements(By.xpath(elementPath)).size() == 0){
    				try {
    					System.out.println("Sleep");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	    	}
//    		(new WebDriverWait(driver, 1)).until(new ExpectedCondition<WebElement>(){
//    			@Override
//    			public WebElement apply(WebDriver d) {
//    				return d.findElement(By.xpath(elementPath));
//    			}});
    	
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