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
    String SUBJECT_TEXT_FIELD = resource.getString("SUBJECT_TEXT_FIELD");
    String MAIL_TEXT_FIELD = resource.getString("MAIL_TEXT_FIELD");
    String BUTTON_SEND = resource.getString("BUTTON_SEND");
    String LINK_SENT_MAIL = resource.getString("LINK_SENT_MAIL");


    private By lastMailRecipient = new By.ByXPath(LAST_MAIL_RECIPIENT);
    private By subjectTextField = new By.ByXPath(SUBJECT_TEXT_FIELD);
    private By mailTextField = new By.ByXPath(MAIL_TEXT_FIELD);
    private By buttonSend = new By.ByXPath(BUTTON_SEND);
    private By linkSentMail = new By.ByXPath(LINK_SENT_MAIL);

    public Drafts AssertMailIsExcited(String recipient, WebDriver driver) {
        String actualLastMailRecipient = driver.findElement(lastMailRecipient).getText();
        if (actualLastMailRecipient.equals(recipient)) {
            return getDrafts();
        }
        else
            Assert.fail("Mail was not saved in drafts. Wrong recipient " + actualLastMailRecipient);
        return getDrafts();
    }

    public Drafts AssertMailRequisites(String subject, String mailText, WebDriver driver) {
        String actualSubject = driver.findElement(subjectTextField).getText().trim();
        String actualMailText = driver.findElement(mailTextField).getText().trim();
        if (actualMailText.equals(mailText.trim())) { //actualSubject.equals(subject.trim()) &&
            return getDrafts();
        }
        else
            Assert.fail("Mail was saved with wrong requisites :" + actualSubject + " " + actualMailText);
        return getDrafts();
    }

    public Drafts openDraftMail() {
        action.buttonClick(lastMailRecipient);
        return getDrafts();
    }

    public Drafts sendMail() {
        action.buttonClick(buttonSend);
        return getDrafts();
    }

    public Drafts openSentMail() {
        action.buttonClick(linkSentMail);
        return getDrafts();
    }

}
