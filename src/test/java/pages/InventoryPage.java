package pages;

import core.actions.WaitActions;
import core.driver.DriverManager;
import core.pages.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.InventoryUtils;

import java.util.List;

public class InventoryPage extends BasePage {

    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getLowerPriceItem() {
        List<WebElement> pricesBarList = DriverManager.getWebDriver().findElements(By.className("pricebar"));
        String lowerPrice = "1000000000000000";
        WebElement lowerPriceItem = null;
        for (WebElement priceBar : pricesBarList) {
            WebElement priceItem = priceBar.findElement(By.className("inventory_item_price"));
            if (InventoryUtils.convertToDouble(lowerPrice) > InventoryUtils.convertToDouble(
                    InventoryUtils.removeCurrencySymbol(priceItem.getText()))) {
                lowerPrice = InventoryUtils.removeCurrencySymbol(priceItem.getText());
                lowerPriceItem = priceItem;
            }
        }
        return lowerPriceItem;
    }

    public WebElement getInventoryContainer() {
        return DriverManager.getWebDriver().findElement(By.id("inventory_container"));
    }

    public void validatePageIsDisplayed() {
        Assert.assertTrue(getInventoryContainer().isDisplayed());
    }

    public WebElement getShoppingCartBtn() {
        return DriverManager.getWebDriver().findElement(By.className("shopping_cart_link"));
    }
}
