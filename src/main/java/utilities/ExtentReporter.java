package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	static ExtentReports extent;
	
	public static ExtentReports setupExtentReport() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		String reportPath = System.getProperty("user.dir")+"/Reports/ExecutionReport_"+actualDate+".html";
		ExtentSparkReporter extentSparkReport = new ExtentSparkReporter(reportPath);
		extentSparkReport.config().setReportName("Tutorials Ninja Automation Result");
		extentSparkReport.config().setDocumentTitle("DocumentTitle");
		extentSparkReport.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(extentSparkReport);
		extent.setSystemInfo("Environment URL: ", PropertiesReader.getPropertyValueByKey("appURL"));
		extent.setSystemInfo("Execution on Browser: ", PropertiesReader.getPropertyValueByKey("browser"));
		extent.setSystemInfo("Execution on OS", System.getProperty("os.name"));
		extent.setSystemInfo("Execution by user", System.getProperty("user.name"));

		return extent;
	}
}
