package Helpers;

import BrowserInit.BrowserInitializing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GeneralHelper {

    private static int DEFAULT_WAITFOR_PAGE_SECONDS = 40; // used for all wait methods


    ///<summary>
    /// Method works in all pages
    /// The main wait method. Method waits until element will be clickable using different locators
    ///</summary>
    private static void WaitClickableElement(WebDriver driver, By by) {
        if (DEFAULT_WAITFOR_PAGE_SECONDS > 0) {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAITFOR_PAGE_SECONDS);
            wait.until(ExpectedConditions.elementToBeClickable(by));
        }
    }

    public static void WaitClickableElementByCssSelector(String CssSelector) {
        WaitClickableElement(BrowserInitializing.getDriver(), By.cssSelector(CssSelector));
    }

    public static void WaitClickableElementByXPath(String XPath) {
        WaitClickableElement(BrowserInitializing.getDriver(), By.xpath(XPath));
    }

    public static void WaitClickableElementByID(String Id) {
        WaitClickableElement(BrowserInitializing.getDriver(), By.id(Id));
    }


    ///<summary>
    /// Method works in all pages
    /// The main wait method. Method waits until element will be visible using different locators
    ///</summary>
    private static void WaitVisibleElement(WebDriver driver, By by) {
        if (DEFAULT_WAITFOR_PAGE_SECONDS > 0) {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAITFOR_PAGE_SECONDS);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
    }

    public static void WaitVisibleElementByCssSelector(String CssSelector) {
        WaitVisibleElement(BrowserInitializing.getDriver(), By.cssSelector(CssSelector));
    }

    public static void WaitVisibleElementByXPath(String XPath) {
        WaitVisibleElement(BrowserInitializing.getDriver(), By.xpath(XPath));
    }

    public static void WaitVisibleElementByID(String Id) {
        WaitVisibleElement(BrowserInitializing.getDriver(), By.id(Id));
    }

    ///<summary>
    /// Method works in all pages
    /// Method waits 1 second
    ///</summary>
    public static void DoSmallDelay() {
        BrowserInitializing.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

}
