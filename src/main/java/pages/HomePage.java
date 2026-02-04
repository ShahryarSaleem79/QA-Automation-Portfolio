package pages;

import base.BasePage;
import io.qameta.allure.Step;
import utils.WaitUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "search-input")
    private WebElement searchBox;

    @FindBy(id = "search-button")
    private WebElement searchButton;

    @Step("Search for product: {productName}")
    public ProductsPage searchProduct(String productName) {
        logger.info("Searching for product: " + productName);
        WaitUtils.waitForVisible(searchBox).sendKeys(productName);
        searchButton.click();
        return new ProductsPage();
    }
}