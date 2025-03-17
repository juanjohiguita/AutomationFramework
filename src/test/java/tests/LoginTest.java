package tests;

import core.actions.WaitActions;
import core.constants.Constants;
import core.pages.basePage.BasePage;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.*;
import utils.InventoryUtils;
import utils.UserFileReader;

public class LoginTest extends BaseTest {

    @Test(priority = 1, groups = {"validUser"}, description = "Fill login with valid credentials")
    public void fillLoginWithValidCredentials()  {
        UserFileReader.Account account = UserFileReader.getAccountById("validUser");
        loginPage.fillLogin(account.getUsername(), account.getPassword());
        validateInventoryPageIsDisplayed();
    }

    public void validateInventoryPageIsDisplayed() {
        Allure.step("Validate Inventory Page is displayed");
        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.validatePageIsDisplayed();
    }

    @Test(priority = 2, groups = {"invalidUser"}, description = "Fill login with invalid credentials")
    public void fillLoginWithInvalidCredentials()  {
        UserFileReader.Account account = UserFileReader.getAccountById("invalidUser");
        loginPage.fillLogin(account.getUsername(), account.getPassword());
        loginPage.verifyErrorMessageIsDisplayed();
    }

    @Test(priority = 3, groups = {"invalidUser"}, description = "Fill login with invalid credentials (Error)")
    public void fillLoginWithInvalidCredentialsError()  {
        UserFileReader.Account account = UserFileReader.getAccountById("validUser");
        loginPage.fillLogin(account.getUsername(), account.getPassword());
        loginPage.verifyErrorMessageIsDisplayed();
    }
}
