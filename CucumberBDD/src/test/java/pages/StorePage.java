package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {

	@FindBy(xpath = "//a[@title='View cart']")
	private WebElement viewCartLink;

	public StorePage(WebDriver driver) {
		super(driver);

	}

	public void addTocart(String productName) {
		By addTocartBtn = By
				.xpath("//h2[text()='" + productName + "']/parent::a/following-sibling::a[text()='Add to cart']");
		wait.until(ExpectedConditions.elementToBeClickable(addTocartBtn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
		}
}
