package tests;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import basepackage.Base;
import pageObjects.Tutorials_Ninja_Landing_Page_Objects;
import pageObjects.Tutorials_Ninja_Login_Page_Objects;
import utilities.PropertiesReader;

public class Tutorials_Ninja_Login_Page_Test extends Base{
	Logger log;
	public WebDriver driver;
	Tutorials_Ninja_Landing_Page_Objects landingPageObjects;
	Tutorials_Ninja_Login_Page_Objects loginPageObjects;
	@Test(dataProvider="getLoginData")
	public void loginToApplication(String email, String password, String expectedStatus) throws InterruptedException {

		landingPageObjects = new Tutorials_Ninja_Landing_Page_Objects(driver);
		loginPageObjects = new Tutorials_Ninja_Login_Page_Objects(driver);
		
		landingPageObjects.clickOnMyAccountDD();
		log.debug("Clicked on My Account dropdown");
		landingPageObjects.clickOnLogin();
		log.debug("Clicked on login button");
		Thread.sleep(2000);
		loginPageObjects.loginToApplication(email, password);
		String actualResult = null;
		try {
			if(loginPageObjects.verifyMyAccount().isDisplayed()) {
				log.debug("User got logged in");
				actualResult = "Successful";
			}
		} catch (Exception e) {
			log.debug("User didnot log in");
			actualResult = "Unsuccessful";
		}
		if(actualResult.equals(expectedStatus)) {
			log.info("Login test got passed");
		}
		else {
			log.error("Login test got failed");
		}
		Assert.assertEquals(actualResult, expectedStatus);
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
	
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = {{"alok.kumar_barman@outlook.com","test@1234","Successful"}};
		return data;
	}
}
