package pages;

import core.actions.WaitActions;
import core.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import core.pages.basePage.BasePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getErrorMessage() {
        return DriverManager.getWebDriver().findElement(By.xpath("//h3[@data-test='error']"));
    }

    public WebElement getUsername() {
        return DriverManager.getWebDriver().findElement(By.id("user-name"));
    }

    public WebElement getPassword() {
        return DriverManager.getWebDriver().findElement(By.id("password"));
    }

    public WebElement getLoginBtn() {
        return DriverManager.getWebDriver().findElement(By.id("login-button"));
    }

    public void fillLoginWithValidCredentials() {
        WaitActions.waitForElementToBeVisible(getUsername(), 5);
        getUsername().sendKeys("standard_user");
        WaitActions.waitForElementToBeVisible(getPassword(), 5);
        getPassword().sendKeys("secret_sauce");
        WaitActions.waitForElementToBeVisible(getLoginBtn(), 5);
        getLoginBtn().click();
    }


    public void fillLoginWithInvalidCredentials() {
        WaitActions.waitForElementToBeVisible(getUsername(), 5);
        getUsername().sendKeys("adb");
        WaitActions.waitForElementToBeVisible(getPassword(), 5);
        getPassword().sendKeys("123");
        WaitActions.waitForElementToBeVisible(getLoginBtn(), 5);
        getLoginBtn().click();
    }

    public void verifyErrorMessageIsDisplayed() {
        WaitActions.waitForElementToBeVisible(getErrorMessage(), 2);
        Assert.assertEquals(getErrorMessage().getText(), "Epic sadface: Username and password do not match any user in this service");
    }

}
