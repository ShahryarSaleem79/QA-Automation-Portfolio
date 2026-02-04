package pages;

import base.BasePage;
import io.qameta.allure.Step;
import utils.WaitUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(css = ".product-item")
    private List<WebElement> productList;

    @Step("Select product at index: {index}")
    public ProductDetailsPage selectProduct(int index) {
        logger.info("Selecting product at index: " + index);
        waitFor(productList.get(index)).click();
        return new ProductDetailsPage();
    }
}