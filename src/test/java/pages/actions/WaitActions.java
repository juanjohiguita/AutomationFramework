package pages.actions;

import pages.driver.DriverManager;
import java.time.Duration;

public abstract class WaitActions {

    public static void implicitWait(int seconds){
        DriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
