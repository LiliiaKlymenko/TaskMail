package PageFactory;

import WebDriverFactory.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ResourceBundle;

/**
 * Created by Liliia_Klymenko on 25-May-15.
 */
public class Drafts extends Page{

    private BrowserAction action = new BrowserAction();

    public static Drafts getDrafts() {
        Drafts drafts = new Drafts();
        InitPage(drafts);
        return drafts;
    }

    ResourceBundle resource = ResourceBundle.getBundle("config");
    String LAST_MAIL_RECIPIENT = resource.getString("LAST_MAIL_RECIPIENT");
    private By lastMailRecipient = new By.ByXPath(LAST_MAIL_RECIPIENT);

    public Drafts AssertMailIsExcited(String recipient, WebDriver driver) {

        String actualLastMailRecipient = driver.findElement(lastMailRecipient).getText();
        if (actualLastMailRecipient.equals(recipient)) {
            return getDrafts();
        }
        else
            Assert.fail("Mail was not saved in drafts. Wrong recipient " + actualLastMailRecipient);
        return getDrafts();
    }
}
