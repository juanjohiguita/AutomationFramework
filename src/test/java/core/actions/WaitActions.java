package core.actions;

import core.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class WaitActions {

    public static void implicitWait(int seconds){
        DriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public static WebElement waitForElementToBeVisible(WebElement webElement, int seconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    // Espera hasta que el WebElement sea clickeable
    public static void waitForElementToBeClickable(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Espera hasta que el WebElement desaparezca (se vuelva invisible)
    public static void waitForElementToDisappear(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // Espera hasta que un elemento esté presente en el DOM (no necesariamente visible)
    public static void waitForElementToBePresent(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Espera hasta que el texto de un WebElement cambie
    public static void waitForTextToBeChanged(WebElement element, String oldText, int seconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.textToBePresentInElement(element, oldText));
    }
}
