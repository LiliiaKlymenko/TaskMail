package Helpers;

import PageObjects.ComposeMailPage;
import PageObjects.Drafts;
import PageObjects.Page;
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

    public ComposeMailHelper composeMail(By buttonSaveInDrafts, By mailTextField, By subjectTextField, By recipientTextField, String recipient, String subject, String mailText, By pop_up_yes, WebDriver driver){
        Page.InitPage(composeMailPage);
        Waiter.Waiter.waitForPresenceOfElementLocated(recipientTextField, driver);
        composeMailPage.
                fillRecipient(recipientTextField, recipient).
                fillSubject(subjectTextField, subject).
                fillMailText(mailTextField, mailText).
                saveAsDraft(buttonSaveInDrafts,
                        pop_up_yes, driver);
        return this;
    }


    public ComposeMailHelper assertSuccessSaved(String recipient, String draftsFolder, WebDriver driver, By lastMailRecipient){
        driver.navigate().to(draftsFolder);
        drafts.AssertMailIsExcited(recipient, driver, lastMailRecipient);
        return this;
    }



    public ComposeMailHelper assertSuccessSaved_encoding(String recipient, By button_drafts_yandex, WebDriver driver, By lastMailRecipient){
        composeMailPage.goToDrafts(button_drafts_yandex, driver);
        drafts.AssertMailIsExcited_encoding(recipient, driver, lastMailRecipient);
        return this;
    }


    public ComposeMailHelper assertMailRequisites(String mailText, String draftsFolder, WebDriver driver, By lastMailRecipient, By subjectTextField, By mailTextField){
        driver.navigate().to(draftsFolder);
        drafts.
                openDraftMail(lastMailRecipient).
                AssertMailRequisites(mailText, driver, subjectTextField, mailTextField);
        return this;
    }

    public ComposeMailHelper assertMailRequisites(String mailText,By button_drafts_yandex, WebDriver driver, By lastMailRecipient, By subjectTextField, By mailTextField){
        composeMailPage.goToDrafts(button_drafts_yandex, driver);
        drafts.
                openDraftMail(lastMailRecipient).
                AssertMailRequisites( mailText, driver, subjectTextField, mailTextField);
        return this;
    }

    public ComposeMailHelper composeMail(By buttonSaveInDrafts, By mailTextField, By subjectTextField, By recipientTextField, String recipient, String subject, String mailText, WebDriver driver){
        Page.InitPage(composeMailPage);
        Waiter.Waiter.waitForPresenceOfElementLocated(recipientTextField, driver);
        composeMailPage.
                fillRecipient(recipientTextField, recipient).
                fillSubject(subjectTextField, subject).
                fillMailText(mailTextField, mailText).
                saveAsDraft(buttonSaveInDrafts);
        return this;
    }

    public ComposeMailHelper sendMail(By buttonSend, By linkSentMail){
        drafts.sendMail(buttonSend).openSentMail(linkSentMail);
        return this;
    }

    public ComposeMailHelper sendMail(By buttonSend, By linkSentMail, By lastMailRecipient){
        drafts.
                sendMail(buttonSend).
                openSentMail(linkSentMail);
        return this;
    }

    public ComposeMailHelper sendMail(String root, By linkSentMail){
        drafts.sendMail(root).openSentMail(linkSentMail);
        return this;
    }
}
