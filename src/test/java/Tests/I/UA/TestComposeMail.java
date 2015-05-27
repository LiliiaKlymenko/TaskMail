package Tests.I.UA;

import Helpers.ComposeMailHelper;
import PageFactory.MailBoxPage;
import PageFactory.SentMailPage;
import Waiter.Waiter;
import WebDriverFactory.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

/**
 * Created by Liliia_Klymenko on 25-May-15.
 */
public class TestComposeMail {

    WebDriver driver;
    private static ComposeMailHelper composeMailHelper;

    ResourceBundle resource = ResourceBundle.getBundle("config");
    String RECIPIENT = resource.getString("RECIPIENT");
    String SUBJECT = resource.getString("SUBJECT");
    String MAIL_TEXT = resource.getString("MAIL_TEXT");
    String DRAFTS = resource.getString("DRAFTS");

    String LINK_USER_NAME = resource.getString("LINK_USER_NAME");
    String LINK_CREATE_NEW_MAIL = resource.getString("LINK_CREATE_NEW_MAIL");
    String RECIPIENT_TEXT_FIELD = resource.getString("RECIPIENT_TEXT_FIELD");
    String BUTTON_SAVE_IN_DRAFTS = resource.getString("BUTTON_SAVE_IN_DRAFTS");
    String LAST_MAIL_RECIPIENT = resource.getString("LAST_MAIL_RECIPIENT");
    String SUBJECT_TEXT_FIELD = resource.getString("SUBJECT_TEXT_FIELD");
    String MAIL_TEXT_FIELD = resource.getString("MAIL_TEXT_FIELD");
    String BUTTON_SEND = resource.getString("BUTTON_SEND");
    String LINK_SENT_MAIL = resource.getString("LINK_SENT_MAIL");

    String BUTTON_SETTINGS = resource.getString("BUTTON_SETTINGS");
    String BUTTON_EXIT = resource.getString("BUTTON_EXIT");


    private By buttonSettings = new By.ByXPath(BUTTON_SETTINGS);
    private By buttonExit = new By.ByXPath(BUTTON_EXIT);

    private By lastMailRecipient = new By.ByXPath(LAST_MAIL_RECIPIENT);
    private By buttonSend = new By.ByXPath(BUTTON_SEND);
    private By linkSentMail = new By.ByXPath(LINK_SENT_MAIL);

    private By recipientTextField = new By.ByXPath(RECIPIENT_TEXT_FIELD);
    private By subjectTextField = new By.ByXPath(SUBJECT_TEXT_FIELD);
    private By mailTextField = new By.ByXPath(MAIL_TEXT_FIELD);
    private By buttonSaveInDrafts = new By.ByXPath(BUTTON_SAVE_IN_DRAFTS);


    private By linkCreateNewMail = new By.ByXPath(LINK_CREATE_NEW_MAIL);

    private static MailBoxPage mailBoxPage;
    private static SentMailPage sentMailPage;


    @BeforeClass
    public void startWebDriver() {
        driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
        composeMailHelper = new ComposeMailHelper();
        mailBoxPage = new MailBoxPage();
        sentMailPage = new SentMailPage();
    }

    @Test(groups = {"MailBox"}, dependsOnGroups = {"SignIn"})
    public void testStartCreatingNewMail() throws Exception {
        mailBoxPage.startCreatingNewMail(linkCreateNewMail);

    }

    @Test(groups = {"ComposeMail", "CreateDraft"}, dependsOnGroups = {"MailBox"})
    public void mailCreate() {
        Waiter.waitForPresenceOfElementLocated(buttonSaveInDrafts, driver);
        composeMailHelper.
                composeMail(buttonSaveInDrafts, mailTextField, subjectTextField, recipientTextField, RECIPIENT, SUBJECT, MAIL_TEXT).
                assertSuccessSaved(RECIPIENT, DRAFTS, driver, lastMailRecipient).
                assertMailRequisites(MAIL_TEXT, DRAFTS, driver,lastMailRecipient, subjectTextField, mailTextField);
    }

    @Test(groups = {"SendMail"}, dependsOnGroups = {"CreateDraft"}, priority = 5)
    public void mailSend() {
        Waiter.waitForElementToBeClickable(buttonSettings, driver);
        composeMailHelper.sendMail(buttonSend, linkSentMail);
        sentMailPage.AssertMailIsExcited(RECIPIENT, driver, lastMailRecipient).exit(buttonSettings, buttonExit);
    }


}
