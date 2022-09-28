package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private static WebDriver driver ;
	
	public static WebDriver initializeDriver() {
		WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
//		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver 105\\chromedriver.exe");
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
