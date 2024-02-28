package companyName.projectName.pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import reusables.Abstract;

public class checkout extends Abstract{
	
	WebDriver driver;
	public checkout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement countrySel;
	
	@FindBy(css=".ta-results")
	WebElement clickableCountry;
	
	@FindBy(css=".btnn.action__submit")
	WebElement clickableSubmit;
	
	@FindBy(css=".hero-primary")
	WebElement confirmation;
	
	By Country = By.cssSelector(".ta-results");
	
	By submit = By.cssSelector(".btnn.action__submit");
	
	public void selCountry(String desCountry) {
		//ANOTHER WAY BELOW driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("EGY");
		Actions act = new Actions(driver);
		act.sendKeys(countrySel, desCountry).build().perform();
		waitForVisbile(Country);
		clickableCountry.click();
	}
	public void pressSubmit() {
		waitForClickable(submit);
		clickableSubmit.click();
	}

	public void confirmation(String expectedMsg) {
		String confirrm_msg = confirmation.getText();
		System.out.println(confirrm_msg);
	//	Assert.assertTrue(confirrm_msg.equalsIgnoreCase(expectedMsg));

	}

}
