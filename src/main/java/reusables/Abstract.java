package reusables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstract {
	
	WebDriver driver;
	
	public Abstract(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	
	
	public void waitForVisbile(By finder) {
		WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
		waiter.until(ExpectedConditions.visibilityOfElementLocated(finder));
	}
	
	public void waitForWebElementVisbile(WebElement finder) {
		WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
		waiter.until(ExpectedConditions.visibilityOf(finder));
	}
	
	public void waitForInvisible(By finder) {
		WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
		waiter.until(ExpectedConditions.invisibilityOf(driver.findElement(finder)));
	}
	
	public void waitForClickable(By finder) {
		WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
		waiter.until(ExpectedConditions.elementToBeClickable(finder));
	}
	
}
