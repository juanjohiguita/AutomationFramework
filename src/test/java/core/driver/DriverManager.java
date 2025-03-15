package core.driver;

import core.constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
    protected static WebDriver driver;

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static void openUrl(String url) {
        driver.get(url);
    }

    public static void setupDriverByBrowserName(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            setupChrome();
        } else if (browser.equalsIgnoreCase("firefox")) {
            setupFirefox();
        } else if (browser.equalsIgnoreCase("edge")) {
            setupEdge();
        }
        openUrl(Constants.url);
    }

    public static void setupChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        setupDriver(new ChromeDriver(options));
        driver.manage().window().maximize();
    }

    public static void setupFirefox(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        setupDriver(new FirefoxDriver(options));
        driver.manage().window().maximize();
    }

    private static void setupEdge() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");
        setupDriver(new EdgeDriver(options));
        driver.manage().window().maximize();
    }

    public static void setupDriver(WebDriver webDriver) {
        setDriver(webDriver);
        openUrl(Constants.url);
    }

}
