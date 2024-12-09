package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void addProduct() {
        var homePage = signUpPage.LoginAndGotoHomeOfProduct("123456789", "adelyousf100@gmail.com");
        homePage.addProductToCart();
        var cartPage = homePage.navigateToCart();
        cartPage.completeCheckOut();
    }
}




