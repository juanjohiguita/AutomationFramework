package stepsDefinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.driver.DriverConfiguration;

public class Hooks {

    public static ChromeOptions options = new ChromeOptions();

    @BeforeTest
    @Given("I setup the execution environment")
    public void setup(){
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

        String url = "https://anupdamoda.github.io/AceOnlineShoePortal/index.html";
        ChromeDriver chromeDriver = new ChromeDriver(options);
        DriverConfiguration.setDriver(chromeDriver);
        DriverConfiguration.getWebDriver().get(url);
    }

    @Given("I setup the execution environment and open the page")
    public void setupAndOpenPage() throws InterruptedException {
        setup();
        openThePage();
    }

    @Given("I open the page")
    public void openThePage() throws InterruptedException {
        String url = "https://anupdamoda.github.io/AceOnlineShoePortal/index.html";
        DriverConfiguration.getWebDriver().get(url);
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
    }
}
