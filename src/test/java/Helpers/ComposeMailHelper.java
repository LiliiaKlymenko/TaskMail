package Helpers;

import PageFactory.ComposeMailPage;
import PageFactory.Drafts;
import PageFactory.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        composeMailPage.
                fillRecipient(recipientTextField, recipient).
                fillSubject(subjectTextField, subject).
                fillMailText(mailTextField, mailText).
                saveAsDraft(buttonSaveInDrafts,
                        pop_up_yes, driver);
        return this;
    }
    //_I.ua
    public ComposeMailHelper assertSuccessSaved(String recipient, String draftsFolder, WebDriver driver, By lastMailRecipient){
        driver.navigate().to(draftsFolder);
        drafts.AssertMailIsExcited(recipient, driver, lastMailRecipient);
        return this;
    }

    //_yandex
    public ComposeMailHelper assertSuccessSaved(String recipient, By button_drafts_yandex, WebDriver driver, By lastMailRecipient){
        composeMailPage.goToDrafts(button_drafts_yandex);
        drafts.AssertMailIsExcited(recipient, driver, lastMailRecipient);
        return this;
    }

    //_I.ua
    public ComposeMailHelper assertMailRequisites(String mailText, String draftsFolder, WebDriver driver, By lastMailRecipient, By subjectTextField, By mailTextField){
        driver.navigate().to(draftsFolder);
        drafts.
                openDraftMail(lastMailRecipient).
                AssertMailRequisites(mailText, driver, subjectTextField, mailTextField);
        return this;
    }

    //_yandex
    public ComposeMailHelper assertMailRequisites(String mailText,By button_drafts_yandex, WebDriver driver, By lastMailRecipient, By subjectTextField, By mailTextField){
        composeMailPage.goToDrafts(button_drafts_yandex);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        drafts.
                openDraftMail(lastMailRecipient).
                AssertMailRequisites( mailText, driver, subjectTextField, mailTextField);
        return this;
    }

    public ComposeMailHelper sendMail(By buttonSend, By linkSentMail){
        drafts.sendMail(buttonSend).openSentMail(linkSentMail);
        return null;
    }

    public ComposeMailHelper sendMail(By buttonSend, By linkSentMail, By lastMailRecipient){
        drafts.
                sendMail(buttonSend).
                openSentMail(linkSentMail);
        return null;
    }
}
