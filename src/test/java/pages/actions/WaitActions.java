package pages.actions;

import pages.driver.DriverConfiguration;
import java.time.Duration;

public abstract class WaitActions {

    public static void implicitWait(int seconds){
        DriverConfiguration.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
