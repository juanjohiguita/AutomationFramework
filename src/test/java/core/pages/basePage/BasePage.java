package core.pages.basePage;

import org.openqa.selenium.support.PageFactory;
import core.driver.DriverManager;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
}
