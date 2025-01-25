package pages.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.driver.DriverConfiguration;

public class BasePage extends DriverConfiguration implements PageBehavior {

    public BasePage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    // Open a URL
    @Override
    public void openUrl(String url) {
        getWebDriver().get(url);
    }
}
