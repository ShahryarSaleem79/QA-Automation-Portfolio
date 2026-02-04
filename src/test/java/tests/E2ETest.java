package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class E2ETest extends BaseTest {

    @Test
    public void completePurchaseFlow() {
        new HomePage()
                .searchProduct("Laptop")
                .selectProduct(0)
                .addToCart()
                .proceedToCheckout()
                .placeOrder();
    }
}