package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;
import driver.DriverFactory;

public class WaitUtils {
	WebDriver driver = DriverFactory.getDriver();
	private static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    private static WebDriverWait getWait() {
        int timeout = ConfigReader.getInt("explicit.wait");
        return new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
    }

    public static WebElement waitForVisible(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
 // For By locators

    public static WebElement waitForClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForUrlContains(String text) {
        return getWait().until(ExpectedConditions.urlContains(text));
    }

 // For PageFactory WebElements
    public static WebElement waitForVisible(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    
    
}
