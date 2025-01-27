package stepsDefinition;

import core.actions.WaitActions;
import core.driver.DriverManager;
import core.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.qameta.allure.Allure;
import tasks.HomeTasks;

public class HomeStepsDefinition {

    public static HomeTasks homeTasks = new HomeTasks();


    @Given("^I navigate to (Online Products)")
    public void navigateTo(String option)  {
        Allure.step("I navigate to " + option);
        homeTasks.clickOnMenuBtn();
        if (option.equalsIgnoreCase("Online Products")) {
            WaitActions.waitForElementToBeClickable(homeTasks.getOnlineProductsBtn(), 10);
            homeTasks.getOnlineProductsBtn().click();
        }
    }

    @Given("I open the page")
    public void openThePage() throws InterruptedException {
        Allure.step("I open the page");
        String url = "https://anupdamoda.github.io/AceOnlineShoePortal/index.html";
        DriverManager.openUrl(url);
    }

    @Given("I setup the execution environment and open the page")
    public void setupAndOpenPage() throws InterruptedException{
        Allure.step("I setup the execution environment and open the page");

        new Hooks().setupDriverByBrowserName("chrome");
        openThePage();
    }

}
