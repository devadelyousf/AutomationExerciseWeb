package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CompleteSignUpPage extends BasePage {
    public CompleteSignUpPage(WebDriver driver) {
        super(driver);
    }
    Select select;
    private final By titleBtn=By.xpath("//div[@class=\"radio-inline\" ] //input[@value=\"Mr\"]");
    private final By passwordField=By.xpath("//input[@data-qa=\"password\"]");
    private final By firstNameField=By.xpath("//input[@data-qa=\"first_name\"]");
    private final By lastNameField=By.xpath("//input[@data-qa=\"last_name\"]");
    private final By addressField=By.xpath("//input[@data-qa=\"address\"]");
    private final By stateField=By.xpath("//input[@data-qa=\"state\"]");
    private final By cityField=By.xpath("//input[@data-qa=\"city\"]");
    private final By zipCodeField=By.xpath("//input[@data-qa=\"zipcode\"]");
    private final By mobileNumberField=By.xpath("//input[@data-qa=\"mobile_number\"]");
    private final By countryDropDown=By.xpath("//select[@data-qa=\"country\"]");
    private final By submitBtn=By.xpath("//div[@class=\"login-form\"] //button[@type=\"submit\"]");
    private final By continueBtn=By.xpath("//a[@data-qa=\"continue-button\"]");


    private void selectTitle(){
        waitElements(titleBtn);
        click(titleBtn);
    }
    private void insertPassword(String text){
        sendKey(passwordField,text);
    }
    private void insertFirstName(String text){
        sendKey(firstNameField,text);
    }
    private void insertLastName(String text){
        sendKey(lastNameField,text);
    }
    private void insertAddress(String text){
        sendKey(addressField,text);
    }
    private void insertState(String text){
        sendKey(stateField,text);
    }
    private void insertCity(String text){
        sendKey(cityField,text);
    }
    private void insertZipCode(String text){
        sendKey(zipCodeField,text);
    }
    private void insertMobileNumber(String text){
        sendKey(mobileNumberField,text);
    }
    private void selectCountry(String country){
        select=new Select(driver.findElement(countryDropDown));
        select.selectByValue(country);
    }
    private void clickOnCreateAccount(){
        click(submitBtn);
    }


    private HomePage clickOnContinueBtn(){
        click(continueBtn);
        return new HomePage(driver);
    }

    public void insertAllData(){
    selectTitle();
    insertPassword("123456789");
    insertFirstName("Adel");
    insertLastName("Yousef");
    insertAddress("Street address, P.O. Box, Company name");
    selectCountry("Canada");
    insertState("Egypt");
    insertCity("Cairo");
    insertZipCode("12345678");
    insertMobileNumber("+201129427799");
    clickOnCreateAccount();
    clickOnContinueBtn();
    }












}
