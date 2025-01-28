package core.pages.basePage;

import org.openqa.selenium.support.PageFactory;
import core.driver.DriverManager;

public class BasePage extends DriverManager{

    public BasePage() {
        PageFactory.initElements(getWebDriver(), this);
    }
}
