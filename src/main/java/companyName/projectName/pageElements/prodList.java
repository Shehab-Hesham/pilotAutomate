package companyName.projectName.pageElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusables.Abstract;

public class prodList extends Abstract{

	WebDriver driver;
	
	public prodList(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//CSS: .mb-3 for all items 
	//List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	
	@FindBy(css=".mb-3")
	List <WebElement> products;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	By toastMsg = By.cssSelector("#toast-container");
	
	By animation = By.cssSelector(".ng-animating"); 
	
	public void addDesiredToCart(String desiredprod) {
		WebElement toBuy = products.stream().filter(product->
		  product.findElement(By.cssSelector("b")).
		  	getText().equals(desiredprod)).findFirst().orElse(null);

		//.card-body button:last-of-type --> Css
		toBuy.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
	}
	public void goCart() {
		//wait for confirmation
//		WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
//		waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		waiter.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		waitForVisbile(toastMsg);
		waitForInvisible(animation);
		//go to cart
		cart.click();
	}

	
}
