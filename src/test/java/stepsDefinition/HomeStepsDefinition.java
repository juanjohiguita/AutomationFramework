package stepsDefinition;

import core.driver.DriverManager;
import core.hooks.Hooks;
import io.cucumber.java.en.Given;
import tasks.HomeTasks;

public class HomeStepsDefinition {

    public static HomeTasks homeTasks = new HomeTasks();


    @Given("^I navigate to (Online Products)")
    public void navigateTo(String option)  {
        homeTasks.clickOnMenuBtn();
        if (option.equalsIgnoreCase("Online Products")) {
            homeTasks.getOnlineProductsBtn().click();
        }
    }

    @Given("I open the page")
    public void openThePage() throws InterruptedException {
        String url = "https://anupdamoda.github.io/AceOnlineShoePortal/index.html";
        DriverManager.openUrl(url);
    }

    @Given("I setup the execution environment and open the page")
    public void setupAndOpenPage() throws InterruptedException{
        new Hooks().setupDriverByBrowserName("chrome");
        openThePage();
    }

}
