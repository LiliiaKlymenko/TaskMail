package Helpers;

import PageFactory.MailBoxPage;
import PageFactory.Page;
import PageFactory.SigninPage;

/**
 * Created by Lili on 24.05.2015.
 */
public class LoginHelper {

    SigninPage signinPage = new SigninPage();
    MailBoxPage mailBoxPage = new MailBoxPage();

    public LoginHelper signIn(String userName, String password){

        Page.InitPage(signinPage);
        signinPage.
                enterLogin(userName).
                enterPassword(password).
                clickLoginButton();
        return this;
    }

    public LoginHelper assertSuccessSignIn(String userName) {
        mailBoxPage.AssertUserName(userName);
        return  this;
    }
}
