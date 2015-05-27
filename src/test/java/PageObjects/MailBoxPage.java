package PageObjects;

import WebDriverFactory.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


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
       Waiter.Waiter.waitForPresenceOfElementLocated(By.xpath(link_user_name), driver);
        String actualUserName = driver.findElement(By.xpath(link_user_name)).getText();
        Assert.assertEquals(actualUserName, displayedUserName, "Wrong user " + actualUserName);
        return getMailBoxPage();
    }

    public MailBoxPage startCreatingNewMail(By linkCreateNewMail){
        action.buttonClick(linkCreateNewMail);
        return getMailBoxPage();
    }



}


