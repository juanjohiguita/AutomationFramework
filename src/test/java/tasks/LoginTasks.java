package tasks;
import pages.LoginPage;
import core.actions.WaitActions;


public class LoginTasks extends LoginPage {

    public void fillLoginWithValidCredentials() {
        WaitActions.waitForElementToBeVisible(getUsername(), 5);
        getUsername().sendKeys("standard_user");
        WaitActions.waitForElementToBeVisible(getPassword(), 5);
        getPassword().sendKeys("secret_sauce");
        WaitActions.waitForElementToBeVisible(getLoginBtn(), 5);
        getLoginBtn().click();
    }


    public void fillLoginWithInvalidCredentials() {
        WaitActions.waitForElementToBeVisible(getUsername(), 5);
        getUsername().sendKeys("adb");
        WaitActions.waitForElementToBeVisible(getPassword(), 5);
        getPassword().sendKeys("123");
        WaitActions.waitForElementToBeVisible(getLoginBtn(), 5);
        getLoginBtn().click();
    }


}
