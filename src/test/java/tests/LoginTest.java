package tests;

import core.actions.WaitActions;
import core.constants.Constants;
import core.pages.basePage.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.*;
import utils.InventoryUtils;

public class LoginTest {

    LoginPage loginPage = new LoginPage();

    @Test(priority = 1)
    public void fillLoginWithValidCredentials()  {
        BasePage.openPageByUrl(Constants.url);
        loginPage.fillLoginWithValidCredentials();
        validateInventoryPageIsDisplayed();
    }

    @Step("Validate inventory page is displayed")
    public void validateInventoryPageIsDisplayed() {
        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.validatePageIsDisplayed();
    }

    @Test(priority = 2, description = "Fill login with invalid credentials")
    public void fillLoginWithInvalidCredentials()  {
        BasePage.openPageByUrl(Constants.url);
        loginPage.fillLoginWithInvalidCredentials();
        loginPage.verifyErrorMessageIsDisplayed();
    }
}
