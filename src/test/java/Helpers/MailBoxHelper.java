package Helpers;

import PageFactory.MailBoxPage;
import PageFactory.Page;

/**
 * Created by Liliia_Klymenko on 25-May-15.
 */
public class MailBoxHelper {

    MailBoxPage mailBoxPage = new MailBoxPage();


    public MailBoxHelper startCreatingNewMail(String mailText){

        Page.InitPage(mailBoxPage);
      //  mailBoxPage.

        return this;
    }


}
