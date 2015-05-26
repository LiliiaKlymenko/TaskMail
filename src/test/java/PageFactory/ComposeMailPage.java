package PageFactory;

import WebDriverFactory.BrowserAction;
import org.openqa.selenium.By;

/**
 * Created by Liliia_Klymenko on 25-May-15.
 */
public class ComposeMailPage extends Page {

    private BrowserAction action = new BrowserAction();


    public static ComposeMailPage getCreateMailPage() {
        ComposeMailPage composeMailPage = new ComposeMailPage();
        InitPage(composeMailPage);
        return composeMailPage;
    }

    public ComposeMailPage fillRecipient(By recipientTextField, String recipient){
        action.textSet(recipientTextField, recipient);
        return getCreateMailPage();
    }

    public ComposeMailPage fillSubject(By subjectTextField, String subject){
        action.textSet(subjectTextField, subject);
        return getCreateMailPage();
    }

    public ComposeMailPage fillMailText(By mailTextField, String mailText){
        action.textSet(mailTextField, mailText);
        return getCreateMailPage();
    }

    public ComposeMailPage saveAsDraft(By buttonSaveInDrafts) {
        action.buttonClick(buttonSaveInDrafts);
        return getCreateMailPage();
    }

}
