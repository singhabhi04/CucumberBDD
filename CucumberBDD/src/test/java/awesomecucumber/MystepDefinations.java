package awesomecucumber;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import domainobjects.BillingDetails;
import domainobjects.Product;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutPage;
import pages.StorePage;

public class MystepDefinations {
	private WebDriver driver;
	private BillingDetails billingDetails;

	@Given("I am on the Store page")
	public void iAmOnTheStorePage() {
		driver = DriverFactory.getDriver();

		new StorePage(driver).load("https://askomdch.com/store/");
	}

	@When("I add a {product} to the Cart")
	public void iAddAToTheCart(Product product)  {
		new StorePage(driver).addTocart(product.getName());

	}

	@Then("I see {int} {product} in the Cart")
	public void iSeeInTheCart(int quantity, Product product) {
		CartPage cartPage = new CartPage(driver);
		

		Assert.assertEquals(product.getName(), cartPage.getProductName());
		Assert.assertEquals(quantity, cartPage.getProductQuantity());
	}

	@Given("I am a guest Customer")
	public void i_am_a_guest_customer() {
		driver = DriverFactory.getDriver();
		new StorePage(driver).load("https://askomdch.com/store/");
	}
	@Given("my billing details are")
	public void my_billing_details_are(BillingDetails billingDetails) {
	    this.billingDetails = billingDetails;
	}


	@Given("I have a product in cart")
	public void i_have_a_product_in_cart() throws InterruptedException {
		new StorePage(driver).addTocart("Blue Shoes");

	}

	@Given("I am on the checkout page")
	public void i_am_on_the_checkout_page() {
		new CartPage(driver).proceedToCheckOut();
	}

	@When("I provide billing details")
	public void i_provide_billing_details() {
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		System.out.println(billingDetails.getBillingFirstName());
		System.out.println(billingDetails.getBillingLastName());
		System.out.println(billingDetails.getBillingZip());
		System.out.println(billingDetails.getBillingAddressOne());
		checkoutPage.setBillingDetails(billingDetails);


	}

	@When("I place an order")
	public void i_place_an_order()  {
		new CheckoutPage(driver).placeOrder();
		
	}

	@Then("the order should be placed sucessfully")
	public void the_order_should_be_placed_sucessfully() {
		
		Assert.assertEquals("Thank you. Your order has been received.", new CheckoutPage(driver).getNotice());

	}

}
