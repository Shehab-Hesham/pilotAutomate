package companyName.projectName.pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusables.Abstract;

public class landingPage extends Abstract{

	WebDriver driver;
	
	public landingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="userEmail")
	WebElement userMail;
	
	@FindBy(id="userPassword")
	WebElement userPass;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(css="[class*='flyInOut'")
	WebElement errorMsg;
	
	public void loginActions(String email, String pass) {
//		driver.findElement(By.id("userEmail")).sendKeys(email);
//		driver.findElement(By.id("userPassword")).sendKeys(pass);
//		driver.findElement(By.id("login")).click();
		
		userMail.sendKeys(email);
		userPass.sendKeys(pass);
		loginBtn.click();
	}
	
	public void getErrorMsg() {
		waitForWebElementVisbile(errorMsg);
		System.out.println(errorMsg.getText());
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
}
