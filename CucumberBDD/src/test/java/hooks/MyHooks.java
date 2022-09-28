package hooks;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {
	private WebDriver driver;
	
	@Before
	public void before() {
		driver = DriverFactory.initializeDriver();
		System.out.println("Inside Before Hook");
	}
	@After
	public void after() {
		System.out.println("Inside After Hook");
		driver.quit();
	}
	

}
