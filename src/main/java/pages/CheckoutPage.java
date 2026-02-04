package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "place-order")
    private WebElement placeOrderButton;

    @Step("Place the order")
    public void placeOrder() {
        logger.info("Placing the order");
        click(placeOrderButton);
    }
}