package products;

import base.BaseTest;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;

public class HomePageTest extends BaseTest {

    @Test
    public void addProduct() throws FileNotFoundException {
        var homePage = signUpPage.LoginAndGotoHomeOfProduct(dataJsonModel().Password, dataJsonModel().Username);
        homePage.addProductToCart();
        var cartPage = homePage.navigateToCart();
        cartPage.cardDetails(
                dataJsonModel().CardDetails.Name,
                dataJsonModel().CardDetails.Number,
                dataJsonModel().CardDetails.CVC,
                dataJsonModel().CardDetails.Month,
                dataJsonModel().CardDetails.Year
        );
    }
}




