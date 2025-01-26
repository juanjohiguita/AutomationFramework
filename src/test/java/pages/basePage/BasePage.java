package pages.basePage;

import org.openqa.selenium.support.PageFactory;
import core.driver.DriverManager;

public class BasePage extends DriverManager implements PageBehavior {

    public BasePage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    // Open a URL
    @Override
    public void openUrl(String url) {
        getWebDriver().get(url);
    }
}
