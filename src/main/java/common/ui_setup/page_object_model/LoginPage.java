package common.ui_setup.page_object_model;

import common.ui_setup.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage(WebDriver driver, String url) {
        super(driver);
        DriverSetup.navigateToUrl(driver, url);
    }

    //assertion elements

    @FindBy(id = "")
    public WebElement we_userName;
    @FindBy(id = "")
    public WebElement we_sideBarHamburgerButton;

    //functional methods

    //assert methods

    public void assertAdminIsLoggedIn(WebElement element, String expectedResults, String customErrorMessage) {
        BasePage.clickElement(we_sideBarHamburgerButton);
        Assert.assertEquals(BasePage.getTextFromElement(element), expectedResults, customErrorMessage);
    }
}
