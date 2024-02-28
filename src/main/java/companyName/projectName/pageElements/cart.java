package companyName.projectName.pageElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import reusables.Abstract;

public class cart extends Abstract {

	WebDriver driver;
	
	public cart(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//get list of products in cart compared to desired
	//xpath: //*[@class='cartSection']/h3
	//List <WebElement> productsToBuy = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
	@FindBy(xpath="//*[@class='cartSection']/h3")
	List <WebElement> productsToBuy;

	@FindBy(css=".totalRow button")
	WebElement toCheckout;
	
	public void checkProd(String desiredprod) {
		boolean correct = productsToBuy.stream().anyMatch(prod->prod.getText().equals(desiredprod));
		//Assert.assertTrue(correct);
	}
	
	public void goCheckout() {
		toCheckout.click();
	}
	
}
