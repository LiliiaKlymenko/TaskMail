package PageFactory;

import WebDriverFactory.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ResourceBundle;


/**
 * Created by Lili on 24.05.2015.
 */
public class MailBoxPage extends Page {


    private BrowserAction action = new BrowserAction();


    ResourceBundle resource = ResourceBundle.getBundle("config");
    String LINK_USER_NAME = resource.getString("LINK_USER_NAME");
    String LINK_CREATE_NEW_MAIL = resource.getString("LINK_CREATE_NEW_MAIL");


    private By linkCreateNewMail = new By.ByXPath(LINK_CREATE_NEW_MAIL);


    public static MailBoxPage getMailBoxPage() {
        MailBoxPage mailBoxPage = new MailBoxPage();
        InitPage(mailBoxPage);
        return mailBoxPage;
    }

    public MailBoxPage AssertUserName(String displayedUserName, WebDriver driver) {
        String actualUserName = driver.findElement(By.xpath(LINK_USER_NAME)).getText();
        if (actualUserName.equals(displayedUserName)){
            return getMailBoxPage();
        } else
            Assert.fail("Wrong user " + actualUserName);

        return getMailBoxPage();
    }

    public MailBoxPage startCreatingNewMail(){
        action.buttonClick(linkCreateNewMail);
        return getMailBoxPage();
    }



}


