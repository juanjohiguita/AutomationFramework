package core.hooks;

import core.utils.GeneralUtils;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import core.driver.DriverManager;
import core.constants.Constants;

import java.lang.reflect.Method;

public class Hooks {

    public void setupChrome(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        setupDriver(new ChromeDriver(options));
        DriverManager.getWebDriver().manage().window().maximize();
    }

    public void setupFirefox(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "/src/test/resources/firefoxdriver.exe");
        setupDriver(new FirefoxDriver(options));
    }

    private void setupEdge() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/resources/edgedriver.exe");
        setupDriver(new EdgeDriver(options));
    }

    public void setupDriver(WebDriver chromeDriver) {
        DriverManager.setDriver(chromeDriver);
        DriverManager.getWebDriver().get(Constants.url);
    }

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethodMethod(String browser, Method testMethod) {
        setupDriverByBrowserName(browser);
    }

    public void setupDriverByBrowserName(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            setupChrome();
        } else if (browser.equalsIgnoreCase("firefox")) {
            setupFirefox();
        } else if (browser.equalsIgnoreCase("edge")) {
            setupEdge();
        }
    }


    @AfterTest
    public void afterTest() {
        DriverManager.getWebDriver().quit(); // Asegúrate de cerrar el navegador
    }
}
