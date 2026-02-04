package pages;

import base.BasePage;
import config.ConfigReader;
import driver.DriverFactory;
import io.qameta.allure.Step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(className = "title")
    private WebElement title;
    
    @FindBy(xpath="//h3[@data-test='error']")
    private WebElement errorMessage;
    		
    public LoginPage(WebDriver driver) {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    
    @Step("Enter username: {username}")
    public void enterUsername(String username) {
        type(usernameField, username);   // BasePage.type(WebElement)
    }
	@Step("Enter password: {password}")
    public void enterPassword(String password) {
        type(passwordField, password);   // BasePage.type(WebElement)
    }
	@Step("Click on Login button")
    public void clickLogin() {
        click(loginButton);              // BasePage.click(WebElement)
    }
	@Step("Get page title")
    public String getTitle() {
        return getText(title);           // BasePage.getText(WebElement)
    }
    public String getTextErrorMessage() {
		return getText(errorMessage);           // BasePage.click(WebElement)
	}
}