package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
	@FindBy(xpath = "//td[@class='product-name']/a") private WebElement productNameFld;
	@FindBy(xpath = "//input[@title='Qty']") private WebElement productQuantityFld;
	@FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]") private WebElement proceedToCheckout;
	
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getProductName() {
		return wait.until(ExpectedConditions.visibilityOf(productNameFld)).getText();
	}
	public int getProductQuantity() {
		return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(productQuantityFld)).getAttribute("value"));
	}
	public void proceedToCheckOut() {
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckout)).click();
		
	}
}
