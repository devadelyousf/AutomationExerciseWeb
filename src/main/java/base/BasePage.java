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


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement webElement(By locator) {
        return driver.findElement(locator);
    }


    protected void click(By locator) {
        visibilityOfElementWait(locator,10);
        webElement(locator).click();
    }

    protected void sendKey(By locator, String text) {
        visibilityOfElementWait(locator,10);
        webElement(locator).sendKeys(text);
    }

    protected void waitElements(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void visibilityOfElementWait(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.presenceOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator)
        ));
    }



}
