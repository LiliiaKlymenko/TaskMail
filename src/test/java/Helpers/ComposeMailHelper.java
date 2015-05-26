package Helpers;

import PageFactory.ComposeMailPage;
import PageFactory.Drafts;
import PageFactory.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Liliia_Klymenko on 25-May-15.
 */
public class ComposeMailHelper {

    ComposeMailPage composeMailPage = new ComposeMailPage();
    Drafts drafts = new Drafts();


    public ComposeMailHelper composeMail(By buttonSaveInDrafts, By mailTextField, By subjectTextField, By recipientTextField, String recipient, String subject, String mailText){
        Page.InitPage(composeMailPage);
        composeMailPage.fillRecipient(recipientTextField, recipient).fillSubject(subjectTextField, subject).fillMailText(mailTextField, mailText).saveAsDraft(buttonSaveInDrafts);
        return this;
    }

    public ComposeMailHelper assertSuccessSaved(String recipient, String draftsFolder, WebDriver driver){
        driver.navigate().to(draftsFolder);
        drafts.AssertMailIsExcited(recipient, driver);
        return this;
    }

    public ComposeMailHelper assertMailRequisites(String subject, String mailText, String draftsFolder, WebDriver driver){
        driver.navigate().to(draftsFolder);
        drafts.
                openDraftMail().
                AssertMailRequisites(subject, mailText, driver);
        return this;
    }

    public ComposeMailHelper sendMail(){
        drafts.sendMail().openSentMail();
        return null;
    }

}
