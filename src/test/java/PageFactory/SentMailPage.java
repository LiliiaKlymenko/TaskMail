package PageFactory;

import WebDriverFactory.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ResourceBundle;

/**
 * Created by Liliia_Klymenko on 26-May-15.
 */
public class SentMailPage extends Page {

    private BrowserAction action = new BrowserAction();
    ResourceBundle resource = ResourceBundle.getBundle("config");



    public static SentMailPage getSentMailPage() {
        SentMailPage sentMailPage = new SentMailPage();
        InitPage(sentMailPage);
        return sentMailPage;
    }

    public SentMailPage AssertMailIsExcited(String recipient, WebDriver driver, By lastMailRecipient) {
        String actualLastMailRecipient = driver.findElement(lastMailRecipient).getText();
        if (actualLastMailRecipient.equals(recipient)) {
            return getSentMailPage();
        } else
            Assert.fail("Mail was not saved in drafts. Wrong recipient " + actualLastMailRecipient);
        return getSentMailPage();
    }

    public void exit(By buttonSettings, By buttonExit, WebDriver driver) {
        action.buttonClick(buttonSettings);
        Waiter.Waiter.waitForElementToBeClickable(buttonExit, driver);
        action.buttonClick(buttonExit);
    }
}
