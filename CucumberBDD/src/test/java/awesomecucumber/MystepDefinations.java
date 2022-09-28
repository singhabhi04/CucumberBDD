package awesomecucumber;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import domainobjects.BillingDetails;
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

	@When("I add a {string} to the Cart")
	public void iAddAToTheCart(String productName) throws InterruptedException {
		new StorePage(driver).addTocart(productName);

	}

	@Then("I see {int} {string} in the Cart")
	public void iSeeInTheCart(int quantity, String productName) {
		CartPage cartPage = new CartPage(driver);
		

		Assert.assertEquals(productName, cartPage.getProductName());
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
