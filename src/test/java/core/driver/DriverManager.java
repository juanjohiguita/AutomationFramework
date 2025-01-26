package core.driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

}
