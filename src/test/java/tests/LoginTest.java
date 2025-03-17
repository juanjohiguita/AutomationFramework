package tests;

import core.actions.WaitActions;
import core.constants.Constants;
import core.pages.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.*;
import utils.InventoryUtils;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test(priority = 1)
    public void fillLoginWithValidCredentials()  {
        BasePage.openPageByUrl(Constants.url);
        loginPage.fillLoginWithValidCredentials();
        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.validatePageIsDisplayed();
    }

    @Test(priority = 2)
    public void fillLoginWithInvalidCredentials()  {
        loginPage.fillLoginWithInvalidCredentials();
        loginPage.verifyErrorMessageIsDisplayed();
    }

    @Test(priority = 3)
    public void buyLowerPriceItem()  {
        loginPage.fillLoginWithValidCredentials();
        WaitActions.implicitWait(2);

        InventoryPage inventoryPage = new InventoryPage();
        WebElement lowerPriceItem = inventoryPage.getLowerPriceItem();
        String lowerPrice = InventoryUtils.removeCurrencySymbol(lowerPriceItem.getText());
        WebElement addToCardBtn = lowerPriceItem.findElement(By.xpath("//button[text()='Add to cart']"));
        addToCardBtn.click();
        WaitActions.waitForElementToBeVisible(inventoryPage.getShoppingCartBtn(), 4);
        inventoryPage.getShoppingCartBtn().click();

        CartPage cartPage = new CartPage();
        WaitActions.waitForElementToBeVisible(cartPage.getCheckoutBtn(), 4);
        cartPage.getCheckoutBtn().click();

        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
        checkoutInformationPage.getFirstName().sendKeys("firstName");
        checkoutInformationPage.getLastName().sendKeys("lastName");
        checkoutInformationPage.getPostalCode().sendKeys("postalCode");
        checkoutInformationPage.getContinueBtn().click();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutOverviewPage.getFinishBtn().click();

        // TODO - Add complete checkout validation
    }
}
