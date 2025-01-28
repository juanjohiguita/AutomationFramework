package pages;

import core.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import core.pages.basePage.BasePage;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement menuBtn;

    @FindBy(xpath = "//ul[@id='menu']//li[contains(text(), 'Online Products')]")
    private WebElement onlineProductsBtn;

    public WebElement getMenuBtn() {
        return DriverManager.getWebDriver().findElement(By.xpath("//input[@type='checkbox']"));
    }

    public WebElement getOnlineProductsBtn() {
        return DriverManager.getWebDriver().findElement(By.xpath("//ul[@id='menu']//li[contains(text(), 'Online Products')]"));
    }


}
