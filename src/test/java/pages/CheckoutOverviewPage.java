package pages;

import core.driver.DriverManager;
import core.pages.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage extends BasePage {

    public WebElement getFinishBtn() {
        return DriverManager.getWebDriver().findElement(By.id("finish"));
    }
}
