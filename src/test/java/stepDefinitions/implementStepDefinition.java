package stepDefinitions;

import java.io.IOException;

import companyName.projectName.TestComponents.baseTests;
import companyName.projectName.pageElements.cart;
import companyName.projectName.pageElements.checkout;
import companyName.projectName.pageElements.landingPage;
import companyName.projectName.pageElements.prodList;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class implementStepDefinition  extends baseTests{
	public landingPage landPage; 
	public prodList prod;
	public cart Cart;
	public checkout checkOut;
	
	@Given("Land on Ecommerce homepage")
	public void Land_on_Ecommerce_homepage() throws IOException{
		
		landPage = launchApp();
		
	}
	
	//(.+) = accept anything, no matter what ------------ ^ $ encapsulates regular expression
	@Given("^Given Logged in with username (.+) and password (.+)$")
	//(.+) -> automatically captured in variables
	public void logIn_user_and_pass(String user, String pass) {
		
		landPage.loginActions(user, pass);
	
	}
	
	@When("^I add product (.+) to cart$")
	public void add_product(String product) {
		prod.addDesiredToCart(product);
	}
	
	@And ("^checkout (.+) and submit country (.+)$") //can also use when
	public void checkOut_submit(String product, String country) {
		prod.goCart();
		Cart.checkProd(product);
		Cart.goCheckout();;
		checkOut.selCountry(country);
		checkOut.pressSubmit();
	}
	
	@Then ("{string} is displayed")
	public void msgDisp(String confirmation) {
		checkOut.confirmation(confirmation);
		driver.close();
	}
	
	@Then("{string} appears")
	public void error_msg(String msg) {
		System.out.println(msg);
		land.getErrorMsg();
	}
	
	
}
