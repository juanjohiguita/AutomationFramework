package core.hooks;

import core.Listeners.TestListener;
import core.pages.basePage.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import core.driver.Browser;
import io.cucumber.java.Scenario;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class Hooks {

    @Before( order = 0)
    public void initDriver(Scenario scenario) {
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
