package core.hooks;

import core.constants.Constants;
import core.listeners.TestListener;
import core.pages.basePage.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import core.browser.Browser;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Slf4j
@Listeners(TestListener.class)
public class Hooks {

    @Before(order = 0)
    public void initDriver() {
        BasePage.setDriver(Browser.createWebDriver());
    }

    @After(order = 2)
    public void assertAll() {
        //SoftAssertManager.getSoftAssert().assertAll();
    }

    @After(order = 1)
    public void closeDriver() {
        BasePage.getDriver().quit();
    }

}
