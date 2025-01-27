package tasks;
import pages.HomePage;
import core.actions.WaitActions;


public class HomeTasks extends HomePage {

    public void clickOnMenuBtn() {
        // TODO - IS REQUIRED IMPLEMENT A WAY TO SET THE CONTEXT OF A EXECUTION IN FOCUS WITH THE DRIVER
        //WaitActions.waitForElementToBeClickable(getMenuBtn(), 20);
        WaitActions.implicitWait(3);
        getMenuBtn().click();
        WaitActions.implicitWait(3);
    }
}
