package stepsDefinition;

import core.actions.WaitActions;
import core.driver.DriverManager;
import core.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import tasks.HomeTasks;

public class HomeStepsDefinition {

    public static HomeTasks homeTasks = new HomeTasks();

    @Given("^I navigate to (Online Products)")
    public void navigateTo(String option)  {
        homeTasks.clickOnMenuBtn();
        if (option.equalsIgnoreCase("Online Products")) {
            WaitActions.waitForElementToBeClickable(homeTasks.getOnlineProductsBtn(), 10);
            homeTasks.getOnlineProductsBtn().click();
        }
    }

    @Step("I open the page")
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
