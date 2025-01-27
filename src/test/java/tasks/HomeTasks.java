package tasks;
import pages.HomePage;
import core.actions.WaitActions;


public class HomeTasks extends HomePage {

    public void clickOnMenuBtn() {
        WaitActions.waitForElementToBeClickable(getMenuBtn(), 10);
        getMenuBtn().click();
        WaitActions.implicitWait(3);
    }
}
