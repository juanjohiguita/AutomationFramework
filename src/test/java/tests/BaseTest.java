package tests;

import core.constants.Constants;
import core.driver.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest extends DriverManager {

    @BeforeTest
    public void beforeTest() {
        setupDriverByBrowserName(Constants.browser);
    }

    @AfterTest
    public void afterTest() {
        quitDriver();
    }
}
