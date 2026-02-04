package pages;

import base.BasePage;
import io.qameta.allure.Step;
import utils.WaitUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @Step("Proceed to checkout")
    public CheckoutPage proceedToCheckout() {
        logger.info("Proceeding to checkout");
        click(checkoutButton);
        return new CheckoutPage();
    }
}