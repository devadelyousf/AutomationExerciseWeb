package products;

import base.BaseTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;


public class CompleteSignUpPageTest extends BaseTest {

    @Test
    public void CompleteRegister() throws FileNotFoundException {
        signUpPage.insertNameAndEmailToSignUp();
        var completeSignUpPage = signUpPage.ClickOnSignUpBtn();
        completeSignUpPage.insertAllData(
                dataJsonModel().SignUp.Password,
                dataJsonModel().SignUp.Firstname,
                dataJsonModel().SignUp.Lastname,
                dataJsonModel().SignUp.Address,
                dataJsonModel().SignUp.Country,
                dataJsonModel().SignUp.State,
                dataJsonModel().SignUp.City,
                dataJsonModel().SignUp.Zipcode,
                dataJsonModel().SignUp.Mobile);
    }
}
