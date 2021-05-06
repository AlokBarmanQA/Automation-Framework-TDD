package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import basepackage.Base;

public class Tutorials_Ninja_Login_Page_Objects2 extends Base{
	
	private WebDriver driver;
	public Tutorials_Ninja_Login_Page_Objects2(WebDriver driver) {
		this.driver = driver;
	}
	private By DD_MY_ACCOUNT = By.xpath("//span[contains(text(),'My Account')]");
	By SELECT_REGISTER = By.xpath("//a[contains(text(),'Register')]");
	By TXT_BOX_FIRSTNAME = By.id("input-firstname");
	By TXT_BOX_LASTNAME = By.id("input-lastname");
	By TXT_BOX_EMAIL = By.id("input-email");
	By TXT_BOX_TELEPHONE = By.id("input-telephone");
	By NEW_CUSTOMER_PASSWORD = By.id("input-password");
	By TXT_BOX_confirm_password =By.id("input-confirm");
	By VERIFY_TEXT_SUCCESS = By.xpath("//a[contains(text(),'Success')]");
	By VERIFY_MESSAGE_YOUR_ACCOUNT_HAS_BEEN_CREATED = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
	By SELECT_LOGIN = By.xpath("//a[contains(text(),'Login')]");
	By CONTINUE_NEW_CUSTOMER = By.xpath("//a[contains(text(),'Continue')]");
	By TXT_BOX_EMAIL_ADDRESS = By.xpath("//input[@id='input-email']");
	By RETURNING_CUSTOMER_PASSWORD = By.xpath("//input[@id='input-password']");
	By BTN_LOGIN = By.cssSelector("#content > div > div:nth-child(2) > div > form > input");
	By VERIFY_TEXT_LOGIN = By.xpath("//*[@id='account-login']/ul/li[3]/a");
	By VERIFY_TEXT_YOUR_STORE = By.xpath("//a[contains(text(),'Your Store')]");
	By MY_ACCOUNT = By.xpath("//h2[contains(text(),'My Account')]");
	
	String actualSuccessText = "Success";
	String actualText = "Your Account Has Been Created!";
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public void clickOnMyAccountDD() {
		driver.findElement(DD_MY_ACCOUNT).click();
	}
	public void clickOnLogin() {
		driver.findElement(SELECT_LOGIN).click();
	}
	public void loginToApplication(String un, String pwd) {
		driver.findElement(TXT_BOX_EMAIL).sendKeys(un);
		driver.findElement(RETURNING_CUSTOMER_PASSWORD).sendKeys(pwd);
		driver.findElement(BTN_LOGIN).click();
	}
	public String verifyMyAccountTextAfterLogin() {
		return driver.findElement(MY_ACCOUNT).getText();
	}
	public void verifyLoginTextAfterRegister() {
		driver.findElement(VERIFY_TEXT_LOGIN).getText();
	}
	public String verifyYourStoreText() {
		return driver.findElement(VERIFY_TEXT_YOUR_STORE).getText();
	}
}
