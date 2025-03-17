package pages;

import core.pages.basePage.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.InventoryUtils;

import java.util.List;

@Getter
public class InventoryPage extends BasePage {

    @FindBy(id = "inventory_container")
    private WebElement inventoryContainer;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartBtn;

    @FindBy(className = "pricebar")
    private List<WebElement> priceBarList;

    public WebElement getLowerPriceItem() {
        String lowerPrice = "1000000000000000";
        WebElement lowerPriceItem = null;
        for (WebElement priceBar : priceBarList) {
            WebElement priceItem = priceBar.findElement(By.className("inventory_item_price"));
            if (InventoryUtils.convertToDouble(lowerPrice) > InventoryUtils.convertToDouble(
                    InventoryUtils.removeCurrencySymbol(priceItem.getText()))) {
                lowerPrice = InventoryUtils.removeCurrencySymbol(priceItem.getText());
                lowerPriceItem = priceItem;
            }
        }
        return lowerPriceItem;
    }

    public void validatePageIsDisplayed() {
        Assert.assertTrue(getInventoryContainer().isDisplayed());
    }
}
