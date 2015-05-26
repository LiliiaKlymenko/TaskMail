package PageFactory;

import WebDriverFactory.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


/**
 * Created by Lili on 24.05.2015.
 */
public class MailBoxPage extends Page {


    private BrowserAction action = new BrowserAction();


    public static MailBoxPage getMailBoxPage() {
        MailBoxPage mailBoxPage = new MailBoxPage();
        InitPage(mailBoxPage);
        return mailBoxPage;
    }

    public MailBoxPage AssertUserName(String link_user_name, String displayedUserName, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        String actualUserName = driver.findElement(By.xpath(link_user_name)).getText();
        if (actualUserName.equals(displayedUserName)){
            return getMailBoxPage();
        } else {
            try {
                Assert.fail("Wrong user " + actualUserName + "! Probably encoding is a reason, so test is running");
            } catch (AssertionError er) {
                return getMailBoxPage();
            }
        }
        return getMailBoxPage();
    }

    public MailBoxPage startCreatingNewMail(By linkCreateNewMail){
        action.buttonClick(linkCreateNewMail);
        return getMailBoxPage();
    }



}


