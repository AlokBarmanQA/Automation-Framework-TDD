package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basepackage.Base;

public class Tutorials_Ninja_Register_Page_Objects extends Base {
	
	public WebDriver driver;
	
	public Tutorials_Ninja_Register_Page_Objects(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(id = "input-firstname")
	private WebElement TXT_BOX_FIRSTNAME;
	@FindBy(id = "input-lastname")
	private WebElement TXT_BOX_LASTNAME;
	@FindBy(id = "input-email")
	private WebElement TXT_BOX_EMAIL;
	@FindBy(id = "input-telephone")
	private WebElement TXT_BOX_TELEPHONE;
	@FindBy(id = "input-password")
	private WebElement NEW_CUSTOMER_PASSWORD;
	@FindBy(id = "input-confirm")
	private WebElement TXT_BOX_CONFIRM_PASSWORD;
	@FindBy(xpath = "//a[contains(text(),'Success')]")
	private WebElement VERIFY_TEXT_SUCCESS;
	@FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
	private WebElement VERIFY_MESSAGE_YOUR_ACCOUNT_HAS_BEEN_CREATED;
}
