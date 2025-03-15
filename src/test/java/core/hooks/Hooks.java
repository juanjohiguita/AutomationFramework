package core.hooks;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import core.driver.DriverManager;

import java.lang.reflect.Method;

public class Hooks extends DriverManager {

    @BeforeTest
    @Parameters("browser")
    public void beforeMethodMethod(String browser, Method testMethod) {
        setupDriverByBrowserName(browser);
    }

    @AfterTest
    public void afterTest() {
        quitDriver();
    }
}
