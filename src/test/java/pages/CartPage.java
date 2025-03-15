package pages;

import core.driver.DriverManager;
import core.pages.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public WebElement getCheckoutBtn() {
        return DriverManager.getWebDriver().findElement(By.id("checkout"));
    }
}
