package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {


public BasePage(WebDriver driver ) {
	this.driver = driver;
	wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
	PageFactory.initElements(driver, this);
}

public void load(String url) {
	driver.get(url);
}
protected WebDriver driver;
protected  WebDriverWait wait;
}
