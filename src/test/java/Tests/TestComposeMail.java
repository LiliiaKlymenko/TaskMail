package Tests;

import Helpers.ComposeMailHelper;
import PageFactory.MailBoxPage;
import WebDriverFactory.WebDriverFactory;
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
   // String DRAFTS = resource.getString("DRAFTS");
   private static MailBoxPage mailBoxPage;


    @BeforeClass
    public void startWebDriver() {
        driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
        composeMailHelper = new ComposeMailHelper();
        mailBoxPage = new MailBoxPage();
    }

    @Test(groups = { "MailBox" }, dependsOnGroups = { "SignIn" }, priority = 10)
    public void testStartCreatingNewMail() throws Exception {
        mailBoxPage.startCreatingNewMail();

    }

   /* @Test(groups = { "ComposeMail" }, dependsOnGroups = { "MailBox" })
    public void mailCreate() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        composeMailHelper.composeMail(RECIPIENT,SUBJECT, MAIL_TEXT).assertSuccessSaved(RECIPIENT, driver);
    }*/



}
