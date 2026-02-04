package base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import driver.DriverFactory;
import utils.LoggerUtil;
import utils.WaitUtils;

public class BaseTest {
	protected WebDriver driver;
	protected Logger logger = LoggerUtil.getLogger(this.getClass());

		
	
	@BeforeMethod
	public void setUp() {
		// Initialize WebDriver and other setup tasks
		String browser = System.getProperty("browser", "chrome");
		logger.info("Setting up the test environment");
		DriverFactory.initDriver();
		driver = DriverFactory.getDriver();
	}
		
			@AfterMethod
	public void tearDown() {
		// Cleanup tasks
		if (driver != null) {
			logger.info("Tearing down the test environment");
			DriverFactory.quitDriver();
		}
	}
}
