package PageFactory;

import org.openqa.selenium.By;
import org.testng.Assert;


/**
 * Created by Lili on 24.05.2015.
 */
public class MailBoxPage extends Page{

    public final String USER_NAME_TEXT = "css=a.user_name";

    public static  MailBoxPage getMailBoxPage() {
        MailBoxPage mailBoxPage = new MailBoxPage();
        InitPage(mailBoxPage);
        return mailBoxPage;
    }

    public MailBoxPage AssertUserName(String displayedUserName)
    {
        for (int second = 0;; second++) {
            if (second >= 60) Assert.fail("Time is off");

       if (By.xpath(USER_NAME_TEXT).equals(displayedUserName))
                return getMailBoxPage();

    }


}

}
