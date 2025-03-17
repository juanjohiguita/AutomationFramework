package pages;

import core.actions.WaitActions;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import core.pages.basePage.BasePage;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@Getter
public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

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
