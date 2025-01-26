package tasks;
import pages.HomePage;
import core.actions.WaitActions;


public class HomeTasks extends HomePage {

    public void clickOnMenuBtn() {
        WaitActions.implicitWait(3);
        getMenuBtn().click();
        WaitActions.implicitWait(3);
    }
}
