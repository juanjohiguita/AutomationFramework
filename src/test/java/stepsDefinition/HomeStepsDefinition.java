package stepsDefinition;

import io.cucumber.java.en.Given;
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
