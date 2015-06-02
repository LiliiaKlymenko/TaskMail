package helperIua;

import pageObjectsIua.Page;
import pageObjectsIua.SigninPage;

/**
 * Created by Lili on 24.05.2015.
 */
public class LoginHelper {



    SigninPage signinPage = new SigninPage();

    public LoginHelper signIn(String iua, String login, String pass) {
        Page.InitPage(signinPage);
        signinPage.
                openSignInPage(iua).
                enterLogin(login).
                enterPassword(pass).
                clickLoginButton();
        return this;
    }

}
