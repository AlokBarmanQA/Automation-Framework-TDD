package tests;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import basepackage.Base;
import utilities.PropertiesReader;

public class Tutorials_Ninja_Register_Page_Test extends Base {
	Logger log;
	public WebDriver driver;
	
	@Test
	public void registerNewUser() {
		System.out.println("Verify Register New User");
	}
	
	@BeforeMethod
	public void setup() {
		log = LogManager.getLogger(Tutorials_Ninja_Login_Page_Test.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.navigate().to(PropertiesReader.getPropertyValueByKey("appURL"));
		log.debug("Navigated to application URL");
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		log.debug("Browser got closed");
	}
}
