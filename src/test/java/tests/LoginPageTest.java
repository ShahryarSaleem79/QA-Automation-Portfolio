package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

public class LoginPageTest extends BaseTest {
	@Epic("Login Module")
	@Feature("Login Page")
	@Story("Valid Login")
	@Description("Verify user can login with valid credentials")
	@Test(priority=1, retryAnalyzer = retry.RetryAnalyzer.class)
	public void testValidLogin() {
		
		LoginPage loginPage = new LoginPage(driver);
		// Test code for valid login
		logger.info("entering valid username");
		loginPage.enterUsername("standard_user");
		logger.info("entering valid password");
		loginPage.enterPassword("secret_sauce");
		logger.info("clicking login button");
		loginPage.clickLogin();
		System.out.println(loginPage.getTitle());
		Assert.assertEquals(loginPage.getTitle(),"Products");
		logger.info("Valid login test executed");
	}
	@Test(priority=2, retryAnalyzer = retry.RetryAnalyzer.class)
	public void testInvalidLogin() {
		
		LoginPage loginPage = new LoginPage(driver);
		// Test code for invalid login
		logger.info("entering invalid username");
		loginPage.enterUsername("invalid_user");
		logger.info("entering invalid password");
		loginPage.enterPassword("wrong_password");
		logger.info("clicking login button");
		loginPage.clickLogin();
		System.out.println(loginPage.getTextErrorMessage());
//		Assert.assertEquals(loginPage.getTextErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
//		logger.info("Invalid login test executed");
		//Assert.fail("forceFailure");
	}
}
