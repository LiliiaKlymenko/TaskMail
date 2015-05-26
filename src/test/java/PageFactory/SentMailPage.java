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
    String BUTTON_SETTINGS = resource.getString("BUTTON_SETTINGS");
    String BUTTON_EXIT = resource.getString("BUTTON_EXIT");
    String LAST_MAIL_RECIPIENT = resource.getString("LAST_MAIL_RECIPIENT");


    private By buttonSettings = new By.ByXPath(BUTTON_SETTINGS);
    private By buttonExit = new By.ByXPath(BUTTON_EXIT);
    private By lastMailRecipient = new By.ByXPath(LAST_MAIL_RECIPIENT);


    public static SentMailPage getSentMailPage() {
        SentMailPage sentMailPage = new SentMailPage();
        InitPage(sentMailPage);
        return sentMailPage;
    }

    public SentMailPage AssertMailIsExcited(String recipient, WebDriver driver) {
        String actualLastMailRecipient = driver.findElement(lastMailRecipient).getText();
        if (actualLastMailRecipient.equals(recipient)) {
            return getSentMailPage();
        } else
            Assert.fail("Mail was not saved in drafts. Wrong recipient " + actualLastMailRecipient);
        return getSentMailPage();
    }

    public void exit() {
        action.buttonClick(buttonSettings);
        action.buttonClick(buttonExit);
    }
}
