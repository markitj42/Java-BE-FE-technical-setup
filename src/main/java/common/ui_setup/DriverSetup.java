package common.ui_setup;

import common.util.SetupConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverSetup {
    private WebDriver driver;
    private ChromeOptions chromeOptions;

    public DriverSetup(DriverType browserType){

        switch(browserType) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                this.driver = new ChromeDriver(chromeOptions);
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                this.driver = new FirefoxDriver();
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                this.driver = new EdgeDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public static void navigateToUrl(WebDriver driver, String url) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(SetupConstants.PAGE_LOAD_TIME));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SetupConstants.ELEMENT_DETECTION_TIMEOUT));
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void closeBrowserTab() {
        driver.close();
    }

    public void quitBrowser() {
        driver.quit();
    }
}
