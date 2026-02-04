package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

    @FindBy(id = "add-to-cart")
    private WebElement addToCartButton;

    @Step("Add product to cart")
    public CartPage addToCart() {
        logger.info("Adding product to cart");
        click(addToCartButton);
        return new CartPage();
    }
}