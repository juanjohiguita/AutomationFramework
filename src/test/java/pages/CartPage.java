package pages;

import core.pages.basePage.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CartPage extends BasePage {

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;
}
