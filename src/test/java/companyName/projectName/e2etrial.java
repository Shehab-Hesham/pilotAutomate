package companyName.projectName;

import reusables.Abstract;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import companyName.projectName.TestComponents.baseTests;
import companyName.projectName.pageElements.cart;
import companyName.projectName.pageElements.checkout;
import companyName.projectName.pageElements.landingPage;
import companyName.projectName.pageElements.prodList;
import resources.demoExtentReport;
public class e2etrial extends baseTests{
	
	@Test(dataProvider="getData", groups = "Purchase") 
	public void submitOrder(HashMap<String,String> inputMap) throws IOException {

		ExtentReports extentReport = demoExtentReport.config();
		ExtentTest test = extentReport.createTest("Pilot Test");
		
		//String email = "email2001@gmail.com";
		//String pass = "Ess2001aitch";
		
		String desiredprod = "IPHONE 13 PRO";
		String country = "Egypt";
		
		String confirmation = "THANKYOU FOR THE ORDER.";
		
		
		//landing
		land.loginActions(inputMap.get("email"), inputMap.get("pass"));
		
		
		//List of Products
		prodList prod = new prodList(driver);
		prod.addDesiredToCart(desiredprod);
		prod.goCart();
		
		//Cart
		cart Cart = new cart(driver);
		Cart.checkProd(desiredprod);
		Cart.goCheckout();;
		
		//Payment Info
		checkout checkOut = new checkout(driver);
		checkOut.selCountry(country);
		checkOut.pressSubmit();
		checkOut.confirmation(confirmation);
		
		System.out.println("First");
		
		extentReport.flush(); //will not generate without

	}
	
//	public File getScreenshot(String testCaseName) throws IOException {
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
//		FileUtils.copyFile(source, file);
//		return file;
//	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "email2001@gmail.com");
//		map.put("pass", "Ess2001aitch");
//		
//		HashMap<String,String> map2 = new HashMap<String,String>();
//		map2.put("email", "shetty@gmail.com");
//		map2.put("pass", "IamKing@000");
//		
		List<HashMap<String, String>> from_json = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\data\\PurchaseOrder.json");
		return new Object[][] {{from_json.get(0)}, {from_json.get(1)}};
	}
}
