package Tests.I.UA;

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
    String DRAFTS = resource.getString("DRAFTS");

    String LINK_USER_NAME = resource.getString("LINK_USER_NAME");
    String LINK_CREATE_NEW_MAIL = resource.getString("LINK_CREATE_NEW_MAIL");
    String RECIPIENT_TEXT_FIELD = resource.getString("RECIPIENT_TEXT_FIELD");
    String SUBJECT_TEXT_FIELD = resource.getString("SUBJECT_TEXT_FIELD");
    String MAIL_TEXT_FIELD = resource.getString("MAIL_TEXT_FIELD");
    String BUTTON_SAVE_IN_DRAFTS = resource.getString("BUTTON_SAVE_IN_DRAFTS");


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

    @Test(groups = {"MailBox"}, dependsOnGroups = {"SignIn"}, priority = 10)
    public void testStartCreatingNewMail() throws Exception {
        mailBoxPage.startCreatingNewMail(linkCreateNewMail);

    }

    @Test(groups = {"ComposeMail", "CreateDraft"}, dependsOnGroups = {"MailBox"}, priority = 8)
    public void mailCreate() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        composeMailHelper.
                composeMail(buttonSaveInDrafts, mailTextField, subjectTextField, recipientTextField, RECIPIENT, SUBJECT, MAIL_TEXT).
                assertSuccessSaved(RECIPIENT, DRAFTS, driver).
                assertMailRequisites(SUBJECT, MAIL_TEXT, DRAFTS, driver);
    }

    @Test(groups = {"SendMail"}, dependsOnGroups = {"CreateDraft"}, priority = 5)
    public void mailSend() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        composeMailHelper.sendMail();
        sentMailPage.AssertMailIsExcited(RECIPIENT, driver).exit();
    }


    @AfterClass
    public void stopWebDriver() {
        driver.quit();
    }

}
