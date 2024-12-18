package base;

import data.DataJson;
import dataModel.DataModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pages.SignUpPage;
import utils.ScreenRecorderUtil;
import utils.UtilsTest;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {

    protected WebDriver driver;
    protected SignUpPage signUpPage;
    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;
    UtilsTest utilsTest;
//    ScreenRecorderUtil screenRecorderUtil;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
        setUpBrowser(browser);
        signUpPage = new SignUpPage(driver);
    }

    @BeforeMethod
    public void homePage(Method method) throws Exception {
       ScreenRecorderUtil.startRecord(method.getName());
        driver.get(dataJsonModel().URL);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    protected DataModel dataJsonModel() throws FileNotFoundException {
        DataJson dataJson = new DataJson();
        return dataJson.readDataFromFileJson();
    }
    @AfterMethod
    public void reportFileResource(Method method) throws Exception {
        utilsTest=new UtilsTest(driver);
        utilsTest.takeScreenShot(method);
        ScreenRecorderUtil.stopRecord();
    }

    @Parameters("browser")
    protected void setUpBrowser(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("headlessChrome")) {
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        }else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("headlessEdge")) {
            edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--headless");
            driver = new EdgeDriver(edgeOptions);
        }
        driver.manage().window().maximize();
    }


}


