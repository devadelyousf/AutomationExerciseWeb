package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private final By loginBtn = By.xpath("//a[@href=\"/login\"]");

    private final By loginWithEmail=By.xpath("//input[@data-qa=\"login-email\"]");
    private final By loginWithPassword=By.xpath("//input[@data-qa=\"login-password\"]");
    private final By clickOnLogin=By.xpath("//button[@data-qa=\"login-button\"]");

    private final By nameFieldInput=By.xpath("//input[@name=\"name\"]");
    private final By emailFieldInput=By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By signUpBtn=By.xpath("//button[@data-qa=\"signup-button\"]");

    private void newUserName(String text){
        sendKey(nameFieldInput,text);
    }
    private void newUserEmail(String text){
        sendKey(emailFieldInput,text);
    }
    private void clickOnLoginBtn(){
        click(loginBtn);
    }

    public CompleteSignUpPage ClickOnSignUpBtn(){
        click(signUpBtn);
        return new CompleteSignUpPage(driver);
    }

    public void insertNameAndEmailToSignUp(){
        newUserEmail("adelyousf100@gmail.com");
        newUserName("Adel Ali Mohammed Yousef");
        clickOnLoginBtn();
    }

    private void enterEmail(String mail){
        sendKey(loginWithEmail,mail);
    }
    private void enterPassword(String pass){
        sendKey(loginWithPassword,pass);
    }
    private void loginAndNavigateHomePage(){
        click(clickOnLogin);
    }

    public HomePage LoginAndGotoHomeOfProduct(String pass,String mail){
        clickOnLoginBtn();
        enterEmail(mail);
        enterPassword(pass);
        loginAndNavigateHomePage();
        return new HomePage(driver);
    }





}
