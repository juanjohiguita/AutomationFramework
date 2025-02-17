package core;

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
        ChromeDriver chromeDriver = new ChromeDriver(options);
        setupDriver(chromeDriver);
        DriverManager.getWebDriver().manage().window().maximize();
    }

    public void setupFirefox(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "/src/test/resources/firefoxdriver.exe");

        FirefoxDriver firefoxDriver = new FirefoxDriver(options);
        setupDriver(firefoxDriver);
    }

    private void setupEdge() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/resources/edgedriver.exe");

        EdgeDriver edgeDriver = new EdgeDriver(options);
        setupDriver(edgeDriver);
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



    @Given("I setup the execution environment and open the page")
    public void setupAndOpenPage() throws InterruptedException {
        setupChrome();
        openThePage();
    }

    @Given("I open the page")
    public void openThePage() throws InterruptedException {
        String url = "https://anupdamoda.github.io/AceOnlineShoePortal/index.html";
        DriverManager.getWebDriver().get(url);
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
    }
}
