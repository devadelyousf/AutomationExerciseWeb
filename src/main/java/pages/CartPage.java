package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By iconDelete=By.cssSelector("#product-12 .cart_quantity_delete");
    private final By proceedToCheckout =By.linkText("Proceed To Checkout");
    private final By placeOrder =By.linkText("Place Order");
    private final By cardNumber=By.xpath("//input[@data-qa=\"card-number\"]");
    private final By nameOfCard=By.xpath("//input[@data-qa=\"name-on-card\"]");
    private final By cvcNumber=By.xpath("//input[@data-qa=\"cvc\"]");
    private final By expirationMonth=By.xpath("//input[@data-qa=\"expiry-month\"]");
    private final By expirationYear=By.xpath("//input[@data-qa=\"expiry-year\"]");
    private final By payAndConfirmOrder =By.xpath("//button[@data-qa=\"pay-button\"]");
    private final By continueBtn=By.linkText("Continue");



private void insertDataOfCard(String name ,String number,String cvc,String month,String year){
    sendKey(nameOfCard,name);
    sendKey(cardNumber,number);
    sendKey(cvcNumber,cvc);
    sendKey(expirationMonth,month);
    sendKey(expirationYear,year);
    click(payAndConfirmOrder);
}

    private void clickOnProceedToCheckout(){
        click(proceedToCheckout);
    }
    private void clickOnPlaceOrder(){
        click(placeOrder);
    }
    public void cardDetails(String name ,String number,String cvc , String month , String year){
        click(iconDelete);
        clickOnProceedToCheckout();
        clickOnPlaceOrder();
        insertDataOfCard(name,number,cvc,month,year);
        click(continueBtn);
    }


}
