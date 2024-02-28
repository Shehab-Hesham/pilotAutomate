package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class demoExtentReport {
	static ExtentReports extentReport; 
	
	@BeforeTest
	public static ExtentReports config() {
		String path = System.getProperty("user.dir");//+"\\reports\index.html";
		//important classes: ExtentReports, ExtentSparkReporter
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Shopping Test");
		reporter.config().setDocumentTitle("Shopping Document");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Tester",  "Shehab Hesham");
		return extentReport;
	}
	
	
	
	
}
