package stepsDefinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.driver.DriverConfiguration;
import tasks.HomeTasks;

public class HomeStepsDefinition {

    public static HomeTasks homeTasks = new HomeTasks();


    @Given("^I navigate to (Online Products)")
    public void navigateTo(String option) {
        homeTasks.clickOnMenuBtn();
        if (option.equalsIgnoreCase("Online Products")) {
            homeTasks.getOnlineProductsBtn().click();
        }
    }
}
