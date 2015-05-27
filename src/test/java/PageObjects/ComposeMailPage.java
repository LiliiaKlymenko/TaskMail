package PageObjects;

import WebDriverFactory.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Liliia_Klymenko on 25-May-15.
 */
public class ComposeMailPage extends Page {

    private BrowserAction action = new BrowserAction();


    public static ComposeMailPage getCreateMailPage() {
        ComposeMailPage composeMailPage = new ComposeMailPage();
        InitPage(composeMailPage);
        return composeMailPage;
    }

    public ComposeMailPage fillRecipient(By recipientTextField, String recipient) {
        action.textSet(recipientTextField, recipient);
        return getCreateMailPage();
    }

    public ComposeMailPage fillSubject(By subjectTextField, String subject) {
        action.textSet(subjectTextField, subject);
        return getCreateMailPage();
    }

    public ComposeMailPage fillMailText(By mailTextField, String mailText) {
        action.textSet(mailTextField, mailText);
        return getCreateMailPage();
    }

    public ComposeMailPage saveAsDraft(By buttonSaveInDrafts) {
        action.buttonClick(buttonSaveInDrafts);
        return getCreateMailPage();
    }

    public ComposeMailPage saveAsDraft(By buttonSaveInDrafts, By pop_up_yes, WebDriver driver) {
        try {
            action.buttonClick(buttonSaveInDrafts);
            action.buttonClick(pop_up_yes);
        } catch (StaleElementReferenceException ex) {
            Assert.fail("Problem with browser, becouse " + ex);
        }
        return getCreateMailPage();
    }

    public ComposeMailPage goToDrafts(By button_drafts_yandex, WebDriver driver) {
        try {
            Waiter.Waiter.waitForElementToBeClickable(button_drafts_yandex, driver);
            action.buttonClick(button_drafts_yandex);
        } catch (StaleElementReferenceException ex) {
            Assert.fail("Problem with browser because of StaleElementReferenceException. If such error occur, please, restart tests " + ex);
        }
        return getCreateMailPage();
    }
}
