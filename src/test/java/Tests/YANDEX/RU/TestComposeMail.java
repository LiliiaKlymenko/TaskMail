package Tests.YANDEX.RU;

import Helpers.ComposeMailHelper;
import PageFactory.MailBoxPage;
import PageFactory.SentMailPage;
import WebDriverFactory.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

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
    String BUTTON_DRAFTS_YANDEX = resource.getString("BUTTON_DRAFTS_YANDEX");
    String LAST_MAIL_RECIPIENT = resource.getString("LAST_MAIL_RECIPIENT_YANDEX");
    String BUTTON_SEND = resource.getString("BUTTON_SEND_YANDEX");
    String LINK_CREATE_NEW_MAIL = resource.getString("LINK_CREATE_NEW_MAIL_YANDEX");
    String RECIPIENT_TEXT_FIELD = resource.getString("RECIPIENT_TEXT_FIELD_YANDEX");
    String SUBJECT_TEXT_FIELD = resource.getString("SUBJECT_TEXT_FIELD_YANDEX");
    String MAIL_TEXT_FIELD = resource.getString("MAIL_TEXT_FIELD_YANDEX");
    String BUTTON_SAVE_IN_DRAFTS = resource.getString("BUTTON_SAVE_IN_DRAFTS_YANDEX");
    String POP_UP_YES = resource.getString("POP_UP_YES");
    String LINK_SENT_MAIL = resource.getString("LINK_SENT_MAIL_YANDEX");
    String BUTTON_SETTINGS = resource.getString("BUTTON_SETTINGS_YANDEX");
    String BUTTON_EXIT = resource.getString("BUTTON_EXIT_YANDEX");


    private By buttonSettings = new By.ByCssSelector(BUTTON_SETTINGS);
    private By buttonExit = new By.ByXPath(BUTTON_EXIT);
    private By buttonSend = new By.ByXPath(BUTTON_SEND);
    private By lastMailRecipient = new By.ByXPath(LAST_MAIL_RECIPIENT);
    private By pop_up_yes = new By.ByXPath(POP_UP_YES);
    private By recipientTextField = new By.ByXPath(RECIPIENT_TEXT_FIELD);
    private By subjectTextField = new By.ByXPath(SUBJECT_TEXT_FIELD);
    private By mailTextField = new By.ByXPath(MAIL_TEXT_FIELD);
    private By buttonSaveInDrafts = new By.ByXPath(BUTTON_SAVE_IN_DRAFTS);
    private By button_drafts_yandex = new By.ByXPath(BUTTON_DRAFTS_YANDEX);
    private By linkSentMail = new By.ByXPath(LINK_SENT_MAIL);


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

    @Test(groups = {"MailBoxYandex"}, dependsOnGroups = {"SignInYandex"}, priority = 10)
    public void testStartCreatingNewMail() throws Exception {
        mailBoxPage.startCreatingNewMail(linkCreateNewMail);

    }

    @Test(groups = {"ComposeMailYandex", "CreateDraftYandex"}, dependsOnGroups = {"MailBoxYandex"}, priority = 8)
    public void mailCreate() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        composeMailHelper.
                composeMail(buttonSaveInDrafts, mailTextField, subjectTextField, recipientTextField, RECIPIENT, SUBJECT, MAIL_TEXT, pop_up_yes, driver).
                assertSuccessSaved(RECIPIENT, button_drafts_yandex, driver, lastMailRecipient).
                assertMailRequisites(MAIL_TEXT, button_drafts_yandex, driver, lastMailRecipient, subjectTextField, mailTextField);
    }

    @Test(groups = {"SendMailYandex"}, dependsOnGroups = {"ComposeMailYandex", "CreateDraftYandex"}, priority = 1)
    public void mailSend() {
        composeMailHelper.sendMail(buttonSend, linkSentMail, lastMailRecipient);
        sentMailPage.exit(buttonSettings, buttonExit);
    }


    @AfterClass
    public void stopWebDriver() {
        driver.quit();
    }

}