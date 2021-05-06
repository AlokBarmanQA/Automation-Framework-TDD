package basepackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertiesReader;

public class Base {
	
	public WebDriver driver;

	public WebDriver initializeDriver() {
		
		String browserName = PropertiesReader.getPropertyValueByKey("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
	}
	
	public String takeScreenshot(String testName, WebDriver driver) {
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinitionFilePath = System.getProperty("user.dir")+"/screenshots/"+testName+".png";
		File destination = new File(destinitionFilePath);
		try {
			FileUtils.copyFile(sourceFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destinitionFilePath;
	}
}
