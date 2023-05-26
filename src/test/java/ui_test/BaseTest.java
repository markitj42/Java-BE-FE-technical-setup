package ui_test;

import common.api_setup.ApiConfig;
import common.ui_setup.DriverSetup;
import common.ui_setup.DriverType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends ApiConfig {
    protected DriverSetup driverSetup;
    protected WebDriver driver;

    @BeforeClass
    public void setupBeforeClass() {
        driverSetup = new DriverSetup(DriverType.CHROME);
        driver = driverSetup.getDriver();
    }

    @BeforeMethod
    public void setupBeforeMethod() {
    }

    @AfterMethod
    public void tearDownAfterMethod() {
        driverSetup.closeBrowserTab();
    }

    @AfterClass
    public void tearDownAfterClass() {
        //driverSetup.quitBrowser();
    }

    public void insertBearerToLocalStorage(String token) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String localStorageCode = "localStorage.setItem('token', '" + token + "');";
        js.executeScript(localStorageCode);
    }
}
