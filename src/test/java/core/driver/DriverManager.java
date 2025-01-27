package core.driver;

import io.cucumber.core.plugin.ScenarioContextParallel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void openUrl(String url) {
        driver.get(url);
    }

}
