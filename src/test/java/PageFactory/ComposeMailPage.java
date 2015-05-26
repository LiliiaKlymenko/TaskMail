package PageFactory;

import WebDriverFactory.BrowserAction;
import org.openqa.selenium.By;

import java.util.ResourceBundle;

/**
 * Created by Liliia_Klymenko on 25-May-15.
 */
public class ComposeMailPage extends Page {

    private BrowserAction action = new BrowserAction();


    ResourceBundle resource = ResourceBundle.getBundle("config");
    String RECIPIENT_TEXT_FIELD = resource.getString("RECIPIENT_TEXT_FIELD");
    String SUBJECT_TEXT_FIELD = resource.getString("SUBJECT_TEXT_FIELD");
    String MAIL_TEXT_FIELD = resource.getString("MAIL_TEXT_FIELD");
    String BUTTON_SAVE_IN_DRAFTS= resource.getString("BUTTON_SAVE_IN_DRAFTS");


    private By recipientTextField = new By.ByXPath(RECIPIENT_TEXT_FIELD);
    private By subjectTextField = new By.ByXPath(SUBJECT_TEXT_FIELD);
    private By mailTextField = new By.ByXPath(MAIL_TEXT_FIELD);
    private By buttonSaveInDrafts = new By.ByXPath(BUTTON_SAVE_IN_DRAFTS);


    public static ComposeMailPage getCreateMailPage() {
        ComposeMailPage composeMailPage = new ComposeMailPage();
        InitPage(composeMailPage);
        return composeMailPage;
    }

    public ComposeMailPage fillRecipient(String recipient){
        action.textSet(recipientTextField, recipient);
        return getCreateMailPage();
    }

    public ComposeMailPage fillSubject(String subject){
        action.textSet(subjectTextField, subject);
        return getCreateMailPage();
    }

    public ComposeMailPage fillMailText(String mailText){
        action.textSet(mailTextField, mailText);
        return getCreateMailPage();
    }

    public ComposeMailPage saveAsDraft() {
        action.buttonClick(buttonSaveInDrafts);
        return getCreateMailPage();
    }

}
