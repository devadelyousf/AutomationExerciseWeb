package tests;
import base.BaseTest;
import org.testng.annotations.Test;


public class CompleteSignUpPageTest extends BaseTest {
    @Test
    public void CompleteRegister(){
    signUpPage.insertNameAndEmailToSignUp();
    var completeSignUpPage= signUpPage.ClickOnSignUpBtn();
    completeSignUpPage.insertAllData();
    }
}
