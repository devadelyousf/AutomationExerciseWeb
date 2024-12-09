package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
   protected WebDriverWait wait;


    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    protected WebElement findLocator(By locator){
       return driver.findElement(locator);
    }

    protected void click(By locator){
        findLocator(locator).click();
    }

    protected void sendKey(By locator,String text){
        findLocator(locator).sendKeys(text);
    }

    protected void waitElements(By locator){
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }






















}
