package tests;


import core.actions.WaitActions;
import core.constants.Constants;
import core.pages.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.*;
import utils.InventoryUtils;
import utils.UserFileReader;

public class PurchaseTest extends BaseTest{

    @Test(priority = 1, groups = {"validUser"}, description = "Buy lower price item")
    public void buyLowerPriceItem()  {

        String userId = "validUser";
        UserFileReader.Account account = UserFileReader.getAccountById(userId);
        loginPage.fillLogin(account.getUsername(), account.getPassword());

        WaitActions.implicitWait(2);

        InventoryPage inventoryPage = new InventoryPage();
        WebElement lowerPriceItem = inventoryPage.getLowerPriceItem();
        String lowerPrice = InventoryUtils.removeCurrencySymbol(lowerPriceItem.getText());
        WebElement addToCardBtn = lowerPriceItem.findElement(By.xpath("//button[text()='Add to cart']"));
        addToCardBtn.click();
        WaitActions.waitForElementToBeClickable(inventoryPage.getShoppingCartBtn(), 4);
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
