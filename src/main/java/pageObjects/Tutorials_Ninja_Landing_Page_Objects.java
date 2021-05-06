package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.Base;

public class Tutorials_Ninja_Landing_Page_Objects extends Base{
	
	public WebDriver driver;
	public Tutorials_Ninja_Landing_Page_Objects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private WebElement DD_MY_ACCOUNT;
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	private WebElement SELECT_REGISTER;
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	private WebElement SELECT_LOGIN;
	//a[contains(text(),'Login')]
	public void clickOnMyAccountDD() {
		DD_MY_ACCOUNT.click();
	}
	public void clickOnRegister() {
		SELECT_REGISTER.click();
	}
	public void clickOnLogin() {
		SELECT_LOGIN.click();
	}
}
