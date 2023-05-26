package common.ui_setup.page_object_model;

import common.util.SetupConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {
    public static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void clickElement(WebElement element) {
        element.click();
    }

    public static void sendText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public static String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public static boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    public static boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static void selectViaVisibleTest(WebElement element, String text) {
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element, String value) {
        Select dropDown = new Select(element);
        dropDown.selectByValue(value);
    }

    public static void hoverOverElement(WebElement element) {
        Actions hover = new Actions(driver);
        hover.moveToElement(element).build().perform();
    }

    public static void clickOnHoveredElement(WebElement element) {
        Actions hover = new Actions(driver);
        hover.moveToElement(element).click().build().perform();
    }

    public static void waitForElementVisibility(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SetupConstants.ELEMENT_DETECTION_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void switchToChildWindow() {
        String parentWindow = driver.getWindowHandle();
        String childWindow = null;

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            childWindow = handle;
        }
        driver.switchTo().window(childWindow);
    }

    public static void switchToParentWindow() {
        String parentWindow = driver.getWindowHandle();
        String childWindow = null;

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            childWindow = handle;
        }
        driver.switchTo().window(parentWindow);
    }

    public static void switchToParentWin() {
        String parentWindow = driver.getWindowHandle();
        driver.switchTo().window(parentWindow);
    }
}
