package Tests.I.UA;

import Helpers.ComposeMailHelper;
import PageFactory.MailBoxPage;
import PageFactory.SentMailPage;
import WebDriverFactory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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

   private static MailBoxPage mailBoxPage;
    private static SentMailPage sentMailPage;


    @BeforeClass
    public void startWebDriver() {
        driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
        composeMailHelper = new ComposeMailHelper();
        mailBoxPage = new MailBoxPage();
        sentMailPage = new SentMailPage();
    }

    @Test(groups = { "MailBox" }, dependsOnGroups = { "SignIn" }, priority = 10)
    public void testStartCreatingNewMail() throws Exception {
        mailBoxPage.startCreatingNewMail();

    }

    @Test(groups = { "ComposeMail", "CreateDraft" }, dependsOnGroups = { "MailBox" })
    public void mailCreate() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        composeMailHelper.
                composeMail(RECIPIENT,SUBJECT, MAIL_TEXT).
                assertSuccessSaved(RECIPIENT, DRAFTS, driver).
                assertMailRequisites(SUBJECT, MAIL_TEXT, DRAFTS, driver);
    }

    @Test(groups = { "SendMail" }, dependsOnGroups = { "MailBox" }, priority = 5)
    public void mailSend() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        composeMailHelper.sendMail();
        sentMailPage.AssertMailIsExcited(RECIPIENT, driver).exit();
    }




}
