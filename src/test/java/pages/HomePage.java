package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import core.pages.basePage.BasePage;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement menuBtn;

    @FindBy(xpath = "//ul[@id='menu']//li[contains(text(), 'Online Products')]")
    private WebElement onlineProductsBtn;

    public WebElement getMenuBtn() {
        return menuBtn;
    }

    public WebElement getOnlineProductsBtn() {
        return onlineProductsBtn;
    }


}
