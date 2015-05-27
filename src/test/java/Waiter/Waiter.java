package Waiter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Lili on 24.05.2015.
 */
public class Waiter {

    public static void waitForTitlePresent(String title, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.titleIs(title));
        }

    public static void waitForVisibilityOfElementLocated(By element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitForElementToBeClickable(By element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForalAertIsPresent(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitForFrameToBeAvailableAndSwitchToIt(By element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public static void waitForPresenceOfElementLocated(By element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }


}
