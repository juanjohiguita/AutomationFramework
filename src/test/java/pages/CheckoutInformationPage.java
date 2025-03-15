package pages;

import core.driver.DriverManager;
import core.pages.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutInformationPage extends BasePage {

    public WebElement getFirstName() {
        return DriverManager.getWebDriver().findElement(By.id("first-name"));
    }

    public WebElement getLastName() {
        return DriverManager.getWebDriver().findElement(By.id("last-name"));
    }

    public WebElement getPostalCode() {
        return DriverManager.getWebDriver().findElement(By.id("postal-code"));
    }

    public WebElement getContinueBtn() {
        return DriverManager.getWebDriver().findElement(By.id("continue"));
    }
}
