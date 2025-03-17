package utils;

import core.driver.Browser;
import core.pages.basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

public abstract class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue) {
        switch (identifierType.toUpperCase(Locale.ROOT)) {
            case "xpath":
                return BasePage.getDriver().findElement(By.xpath(identifierValue));
            case "css":
                return BasePage.getDriver().findElement(By.cssSelector(identifierValue));
            case "id":
                return BasePage.getDriver().findElement(By.id(identifierValue));
            case "name":
                return BasePage.getDriver().findElement(By.name(identifierValue));
            case "tagname":
                return BasePage.getDriver().findElement(By.tagName(identifierValue));
            case "classname":
                return BasePage.getDriver().findElement(By.className(identifierValue));
            case "linkText":
                return BasePage.getDriver().findElement(By.linkText(identifierValue));
            case "partialLinkText":
                return BasePage.getDriver().findElement(By.partialLinkText(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getWebElements(String identifierType, String identifierValue) {
        switch (identifierType.toUpperCase(Locale.ROOT)) {
            case "xpath":
                return BasePage.getDriver().findElements(By.xpath(identifierValue));
            case "css":
                return BasePage.getDriver().findElements(By.cssSelector(identifierValue));
            case "id":
                return BasePage.getDriver().findElements(By.id(identifierValue));
            case "name":
                return BasePage.getDriver().findElements(By.name(identifierValue));
            case "tagname":
                return BasePage.getDriver().findElements(By.tagName(identifierValue));
            case "classname":
                return BasePage.getDriver().findElements(By.className(identifierValue));
            case "linkText":
                return BasePage.getDriver().findElements(By.linkText(identifierValue));
            case "partialLinkText":
                return BasePage.getDriver().findElements(By.partialLinkText(identifierValue));
            default:
                return null;
        }
    }
}
