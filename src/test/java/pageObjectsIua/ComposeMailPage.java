package pageObjectsIua;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webDriverFactory.BrowserAction;

/**
 * Created by Liliia_Klymenko on 25-May-15.
 */
public class ComposeMailPage extends Page {

    private BrowserAction action = new BrowserAction();

    @FindBy(xpath = "//div[2]/span/input[1]")
    private WebElement subjectTextField;

    @FindBy(xpath = ".//*[@id='text']")
    private WebElement mailTextField;

    @FindBy(xpath = "//input[contains(@name,'save_in_drafts')]")
    private WebElement buttonSaveInDrafts;

    @FindBy(xpath = ".//*[@id='to']")
    private WebElement recipientTextField;

    @FindBy(xpath = ".//*[@id='header_overall']/div[1]/ul[3]/li[1]/a")
    private WebElement linkUserName;

    public static ComposeMailPage getCreateMailPage() {
        ComposeMailPage composeMailPage = new ComposeMailPage();
        InitPage(composeMailPage);
        return composeMailPage;
    }

    public ComposeMailPage fillRecipient(String recipient) {
        waiter.Waiter.waitForPresenceOfElementLocated(recipientTextField, driver);
        action.textSet(recipientTextField, recipient);
        return getCreateMailPage();
    }

    public ComposeMailPage fillSubject(String subject) {
        waiter.Waiter.waitForPresenceOfElementLocated(subjectTextField, driver);
        action.textSet(subjectTextField, subject);
        return getCreateMailPage();
    }

    public ComposeMailPage fillMailText(String mailText) {
        waiter.Waiter.waitForPresenceOfElementLocated(mailTextField, driver);
        action.textSet(mailTextField, mailText);
        return getCreateMailPage();
    }

    public ComposeMailPage saveAsDraft() {
        waiter.Waiter.waitForPresenceOfElementLocated(buttonSaveInDrafts, driver);
        action.buttonClick(buttonSaveInDrafts);
        return getCreateMailPage();
    }

}
