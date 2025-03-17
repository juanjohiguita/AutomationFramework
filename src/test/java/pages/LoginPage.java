package pages;

import core.actions.WaitActions;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
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

    @Step("Fill login with username: {username} and password: {password}")
    public void fillLogin(String username, String password) {
        Allure.step("Fill login with valid credentials");
        WaitActions.waitForElementToBeVisible(getUsername(), 5);
        getUsername().sendKeys(username);
        WaitActions.waitForElementToBeVisible(getPassword(), 5);
        getPassword().sendKeys(password);
        WaitActions.waitForElementToBeVisible(getLoginBtn(), 5);
        getLoginBtn().click();
    }

    @Step
    public void verifyErrorMessageIsDisplayed() {
        Allure.step("Verify Error message is displayed");
        WaitActions.waitForElementToBeVisible(getErrorMessage(), 2);
        Assert.assertEquals(getErrorMessage().getText(), "Epic sadface: Username and password do not match any user in this service");
    }

}
