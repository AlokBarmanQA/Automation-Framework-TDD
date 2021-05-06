package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import basepackage.Base;

public class Tutorials_Ninja_MyAccount_Page_Objects extends Base{
	public WebDriver driver;

	public Tutorials_Ninja_MyAccount_Page_Objects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
