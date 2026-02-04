package base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.DriverFactory;
import utils.LoggerUtil;
import utils.WaitUtils;

public class BasePage {
	protected WebDriver driver;
	protected Logger logger = LoggerUtil.getLogger(this.getClass());
	public BasePage() {
        this.driver = DriverFactory.getDriver();
    }
//
	protected WebElement find(By locator) {
        return WaitUtils.waitForVisible(locator);
    }

    protected void click(By locator) {
        WaitUtils.waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        return find(locator).getText();
    }
 // ---------- SUPPORT FOR PageFactory WebElements ----------
    protected WebElement waitFor(WebElement element) {
        return WaitUtils.waitForVisible(element);
    }

    protected void click(WebElement element) {
        WaitUtils.waitForClickable(element).click();
    }

    protected void type(WebElement element, String text) {
        WebElement el = waitFor(element);
        el.clear();
        el.sendKeys(text);
    }

    protected String getText(WebElement element) {
        return waitFor(element).getText();
    }


}
