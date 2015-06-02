package Tests.I.UA;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Liliia_Klymenko on 25-May-15.
 */
public class TestComposeMail extends BaseTest {

    String MAIL_TEXT = "hello";
    String RECIPIENT = "lilialexxx@mail.ru";
    String SUBJECT = "test";

    String LOGIN = "liliia.klymenko";
    String PASS = "Mun123456";
    String IUA = "http://www.i.ua/";
    String DISPLAYED_USERNAME = "Liliia";


    @Test(groups = {"SignIn"})
    public void doLogin() {
        loginHelper.
                signIn(IUA, LOGIN, PASS);
        Assert.assertEquals(mailBoxPage.getActualUserName(), DISPLAYED_USERNAME);
    }

    @Test(dependsOnGroups = "SignIn")
    public void testMailBox() throws Exception {
        mailBoxPage.startCreatingNewMail();
        composeMailHelper.composeMail(RECIPIENT, SUBJECT, MAIL_TEXT);
        drafts.openDrafts();
        Assert.assertEquals(drafts.getActualLastMailRecipient(), RECIPIENT, "Wrong recipient " + drafts.getActualLastMailRecipient());
        drafts.openDraftMail();
        Assert.assertEquals(drafts.getActualSubject(), SUBJECT, "Wrong subject " + drafts.getActualSubject());
        Assert.assertEquals(drafts.getActualMail(), MAIL_TEXT, "Wrong mail text " + drafts.getActualMail());
        composeMailHelper.sendMail();
        Assert.assertEquals(sentMailPage.getActualLastMailRecipient(), RECIPIENT, "Wrong recipient " + sentMailPage.getActualLastMailRecipient());
        sentMailPage.exit();
    }

}
