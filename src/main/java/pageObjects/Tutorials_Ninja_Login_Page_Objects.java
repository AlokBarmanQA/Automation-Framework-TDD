package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.Base;

public class Tutorials_Ninja_Login_Page_Objects extends Base{
	
	public WebDriver driver;
	public Tutorials_Ninja_Login_Page_Objects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	private WebElement BTN_CONTINUE_NEW_CUSTOMER;
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement TXT_BOX_EMAIL_ADDRESS;
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement RETURNING_CUSTOMER_PASSWORD;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement BTN_LOGIN;
	@FindBy(xpath = "//*[@id='account-login']/ul/li[3]/a")
	private WebElement VERIFY_TEXT_LOGIN;
	@FindBy(xpath = "//a[contains(text(),'Your Store')]")
	private WebElement VERIFY_TEXT_YOUR_STORE;
	@FindBy(xpath = "//h2[contains(text(),'My Account')]")
	private WebElement MY_ACCOUNT;
	
	String actualSuccessText = "Success";
	String actualText = "Your Account Has Been Created!";
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public void loginToApplication(String un, String pwd) throws InterruptedException {
		TXT_BOX_EMAIL_ADDRESS.sendKeys(un);
		Thread.sleep(3000);
		RETURNING_CUSTOMER_PASSWORD.sendKeys(pwd);
		Thread.sleep(3000);
		BTN_LOGIN.click();
		Thread.sleep(3000);
	}
	public String verifyMyAccountTextAfterLogin() {
		return MY_ACCOUNT.getText();
	}
	public void verifyLoginTextAfterRegister() {
		VERIFY_TEXT_LOGIN.getText();
	}
	public WebElement verifyMyAccount() {
		return MY_ACCOUNT;
	}
}
