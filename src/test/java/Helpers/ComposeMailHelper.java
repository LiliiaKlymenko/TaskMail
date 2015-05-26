package Helpers;

import PageFactory.ComposeMailPage;
import PageFactory.Drafts;
import PageFactory.Page;
import org.openqa.selenium.WebDriver;

/**
 * Created by Liliia_Klymenko on 25-May-15.
 */
public class ComposeMailHelper {

    ComposeMailPage composeMailPage = new ComposeMailPage();
    Drafts drafts = new Drafts();


    public ComposeMailHelper composeMail(String recipient, String subject, String mailText){
        Page.InitPage(composeMailPage);
        composeMailPage.fillRecipient(recipient).fillSubject(subject).fillMailText(mailText).saveAsDraft();
        return this;
    }

    public ComposeMailHelper assertSuccessSaved(String recipient, WebDriver driver){
        drafts.AssertMailIsExcited(recipient,driver);
        return this;
    }


}
