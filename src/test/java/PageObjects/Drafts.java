package PageObjects;

import WebDriverFactory.BrowserAction;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by Liliia_Klymenko on 25-May-15.
 */
public class Drafts extends Page {

    private BrowserAction action = new BrowserAction();
    public static Drafts getDrafts() {
        Drafts drafts = new Drafts();
        InitPage(drafts);
        return drafts;
    }

    public Drafts AssertMailIsExcited_encoding(String recipient, WebDriver driver, By lastMailRecipient) {
        Waiter.Waiter.waitForPresenceOfElementLocated(lastMailRecipient, driver);
       String actualLastMailRecipient = driver.findElement(lastMailRecipient).getText().trim();
        Assert.assertEquals(actualLastMailRecipient.length(), recipient.length(),
                "Mail was not saved in drafts. Wrong recipient " +
                        actualLastMailRecipient + "/" + recipient +
                        "! Probably encoding is a reason");

        return getDrafts();
    }

    public Drafts AssertMailIsExcited(String recipient, WebDriver driver, By lastMailRecipient) {
        Waiter.Waiter.waitForPresenceOfElementLocated(lastMailRecipient, driver);
        String actualLastMailRecipient = driver.findElement(lastMailRecipient).getText().trim();
        Assert.assertEquals(actualLastMailRecipient, recipient,
                "Mail was not saved in drafts. Wrong recipient " +
                        actualLastMailRecipient +
                        "! Probably encoding is a reason");

        return getDrafts();
    }


    public Drafts AssertMailRequisites(String mailText, WebDriver driver, By subjectTextField, By mailTextField) {
        String actualSubject = driver.findElement(subjectTextField).getText().trim();
        String actualMailText = driver.findElement(mailTextField).getText().trim();
        Asserts.check((actualMailText.equals(mailText.trim()) | actualMailText.equals("")), "Mail was saved with wrong requisites : " + actualSubject + " and " + actualMailText);
        return getDrafts();

    }


    public Drafts openDraftMail(By lastMailRecipient) {
        try {
        action.buttonClick(lastMailRecipient);
        } catch (StaleElementReferenceException ex) {
            Assert.fail("Problem with browser because of StaleElementReferenceException. If such error occurred, please, restart tests " + ex);
        }
        return getDrafts();
    }


    public Drafts sendMail(By buttonSend) {
        action.buttonClick(buttonSend);
        return getDrafts();
    }

    public Drafts openSentMail(By linkSentMail) {
        action.buttonClick(linkSentMail);
        return getDrafts();
    }

    public Drafts sendMail(String root) {
        action.sendKey(new By.ByXPath(root));
        return getDrafts();
    }

}
