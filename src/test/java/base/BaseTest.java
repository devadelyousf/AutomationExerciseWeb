package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.SignUpPage;

public class BaseTest {

    protected WebDriver driver;
    protected SignUpPage signUpPage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        signUpPage =new SignUpPage(driver);
    }

    @AfterMethod
    public void tearDown(){
         driver.quit();
    }
}


