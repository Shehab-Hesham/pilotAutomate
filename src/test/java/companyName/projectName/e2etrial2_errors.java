package companyName.projectName;


import reusables.Abstract;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import companyName.projectName.TestComponents.baseTests;
import companyName.projectName.pageElements.cart;
import companyName.projectName.pageElements.checkout;
import companyName.projectName.pageElements.landingPage;
import companyName.projectName.pageElements.prodList;
import resources.demoExtentReport;
public class e2etrial2_errors extends baseTests{
	
//	@Test (dependsOnMethods= {"ProducterrorValidation"})
//	public void errorValidation() throws IOException {
//
//		String email = "email2001@gmail.com";
//		String pass = "Ess2001aitch";
//		
//		String desiredprod = "IPHONE 13 PRO";
//		String country = "Egypt";
//		
//		String confirmation = "THANKYOU FOR THE ORDER.";
//		
//		
//		//landing
//		land.loginActions(email+"abc", pass+"254");
//		land.getErrorMsg();
//		System.out.println("Second");
//		
//		/*
//		//List of Products
//		prodList prod = new prodList(driver);
//		prod.addDesiredToCart(desiredprod);
//		prod.goCart();
//		
//		//Cart
//		cart Cart = new cart(driver);
//		Cart.checkProd(desiredprod);
//		Cart.goCheckout();;
//		
//		//Payment Info
//		checkout checkOut = new checkout(driver);
//		checkOut.selCountry(country);
//		checkOut.pressSubmit();
//		checkOut.confirmation(confirmation);
//*/		
//		
//
//	}
	
	@Test 
	
	public void ProducterrorValidation() throws IOException {

		String email = "email2001@gmail.com";
		String pass = "Ess2001aitch";
		
		String desiredprod = "IPHONE 13 PRO";
		String desiredprod_incorrect = "IPHONE 78";
		String country = "Egypt";
		
		String confirmation = "THANKYOU FOR THE ORDER.";
		
		ExtentReports extentReport = demoExtentReport.config();
		ExtentTest test = extentReport.createTest("Second Test");
		
		//landing
		land.loginActions(email, pass);
//		land.getErrorMsg();
		
		
		//List of Products
		prodList prod = new prodList(driver);
		prod.addDesiredToCart(desiredprod);
		prod.goCart();
		
		//Cart
		cart Cart = new cart(driver);
		Cart.checkProd(desiredprod_incorrect);
		System.out.println("Third");
		extentReport.flush(); //will not generate without
		/*Cart.goCheckout();;
		
		//Payment Info
		checkout checkOut = new checkout(driver);
		checkOut.selCountry(country);
		checkOut.pressSubmit();
		checkOut.confirmation(confirmation);*/

		

	}
}
