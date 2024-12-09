package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By LinkKids=By.xpath("//a[@href=\"#Kids\"]");
    private final By LinkKidsOfShirts=By.xpath("//a[@href=\"/category_products/5\"]");
    private final By listOfProducts=By.xpath("//div[@class=\"productinfo text-center\"]");
    private final By continueShopping=By.xpath("//button[@data-dismiss=\"modal\"]");
    private final By linkOfCart=By.xpath("//div[@class=\"shop-menu pull-right\"] //a[@href=\"/view_cart\"]");

    private void clickOnLinkKids(){
        click(LinkKids);
        waitElements(LinkKidsOfShirts);
        click(LinkKidsOfShirts);
    }

    public void addProductToCart(){
        clickOnLinkKids();
        List<WebElement> allProducts = driver.findElements(listOfProducts);
        try {
            for (int i = 0; i < allProducts.size(); i++) {
                int priceOfProduct = Integer.parseInt(driver.findElement(By.xpath("(//div[@class=\"productinfo text-center\"]/h2)[" + (i + 1) + "]")).getText().replaceAll("[^0-9]", ""));
                if (priceOfProduct < 500) {
                    driver.findElement(By.xpath("(//div[@class=\"productinfo text-center\"]/a)[" + (i + 1) + "]")).click();
                    waitElements(continueShopping);
                    click(continueShopping);
                }
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }


    public CartPage navigateToCart(){
        waitElements(linkOfCart);
        click(linkOfCart);
        return new CartPage(driver);
    }








}
