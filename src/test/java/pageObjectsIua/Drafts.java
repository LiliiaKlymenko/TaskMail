package pageObjectsIua;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webDriverFactory.BrowserAction;

/**
 * Created by Liliia_Klymenko on 25-May-15.
 */
public class Drafts extends Page {


    @FindBy(xpath = ".//*[@name='subject']")
    private WebElement subjectTextField;

    @FindBy(xpath = ".//*[@id='text']")
    private WebElement mailTextField;

    @FindBy(xpath = "//div[1]/p[1]/input[1]")
    private WebElement buttonSend;

    @FindBy(xpath = ".//*[@id='mesgList']/form/div[1]/a/span[2]")
    private WebElement lastMailRecipient;

    @FindBy(xpath = "//div[5]/div[2]/div/div/div[2]/div[2]/div[3]/ul/li[2]/a")
    private WebElement linkSentMail;

    @FindBy(xpath = "//div/div/div[2]/div[2]/div[3]/ul/li[3]/a")
    private WebElement toDrafts;



    private BrowserAction action = new BrowserAction();
    public static Drafts getDraftsPage() {
        Drafts drafts = new Drafts();
        InitPage(drafts);
        return drafts;
    }

    public String getActualLastMailRecipient() {
        waiter.Waiter.waitForPresenceOfElementLocated(lastMailRecipient, driver);
        String actualLastMailRecipient = lastMailRecipient.getText().trim();
        return actualLastMailRecipient;
    }

    public Drafts openDrafts() {
        waiter.Waiter.waitForPresenceOfElementLocated(toDrafts, driver);
        action.buttonClick(toDrafts);
        return getDraftsPage();
    }

    public String getActualSubject() {
        String actualSubject = subjectTextField.getText().trim();
       return actualSubject;
    }

    public String getActualMail() {
        String actualMail = mailTextField.getText().trim();
        return actualMail;

    }


    public Drafts openDraftMail() {
        action.buttonClick(lastMailRecipient);
        return getDraftsPage();
    }


    public Drafts sendMail() {
        action.buttonClick(buttonSend);
        return getDraftsPage();
    }

    public Drafts openSentMail() {
        action.buttonClick(linkSentMail);
        return getDraftsPage();
    }




}
