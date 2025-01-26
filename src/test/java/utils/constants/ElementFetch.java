package utils.constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.driver.DriverManager;

import java.sql.Driver;
import java.util.List;
import java.util.Locale;

public abstract class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue) {
        switch (identifierType.toUpperCase(Locale.ROOT)) {
            case "xpath":
                return DriverManager.getWebDriver().findElement(By.xpath(identifierValue));
            case "css":
                return DriverManager.getWebDriver().findElement(By.cssSelector(identifierValue));
            case "id":
                return DriverManager.getWebDriver().findElement(By.id(identifierValue));
            case "name":
                return DriverManager.getWebDriver().findElement(By.name(identifierValue));
            case "tagname":
                return DriverManager.getWebDriver().findElement(By.tagName(identifierValue));
            case "classname":
                return DriverManager.getWebDriver().findElement(By.className(identifierValue));
            case "linkText":
                return DriverManager.getWebDriver().findElement(By.linkText(identifierValue));
            case "partialLinkText":
                return DriverManager.getWebDriver().findElement(By.partialLinkText(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getWebElements(String identifierType, String identifierValue) {
        switch (identifierType.toUpperCase(Locale.ROOT)) {
            case "xpath":
                return DriverManager.getWebDriver().findElements(By.xpath(identifierValue));
            case "css":
                return DriverManager.getWebDriver().findElements(By.cssSelector(identifierValue));
            case "id":
                return DriverManager.getWebDriver().findElements(By.id(identifierValue));
            case "name":
                return DriverManager.getWebDriver().findElements(By.name(identifierValue));
            case "tagname":
                return DriverManager.getWebDriver().findElements(By.tagName(identifierValue));
            case "classname":
                return DriverManager.getWebDriver().findElements(By.className(identifierValue));
            case "linkText":
                return DriverManager.getWebDriver().findElements(By.linkText(identifierValue));
            case "partialLinkText":
                return DriverManager.getWebDriver().findElements(By.partialLinkText(identifierValue));
            default:
                return null;
        }
    }
}
