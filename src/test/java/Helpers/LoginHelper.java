package Helpers;

import PageFactory.MailBoxPage;
import PageFactory.Page;
import PageFactory.SigninPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lili on 24.05.2015.
 */
public class LoginHelper {



    SigninPage signinPage = new SigninPage();
    MailBoxPage mailBoxPage = new MailBoxPage();


    public LoginHelper signIn(By usernameTextBox, By passwordTextBox, String userName, String password, By loginButton) {

        Page.InitPage(signinPage);
        signinPage.
                enterLogin(usernameTextBox, userName).
                enterPassword(passwordTextBox, password).
                clickLoginButton(loginButton);
        return this;
    }

    public LoginHelper signIn(By usernameTextBox, By passwordTextBox, By buttonNext, String userName, String password, By loginButton) {
        Page.InitPage(signinPage);
        signinPage.enterLogin(usernameTextBox, userName).
                clickButtonNext(buttonNext).
                enterPassword(passwordTextBox, password).
                clickLoginButton(loginButton);
        return this;
    }

    public LoginHelper assertSuccessSignIn(String link_user_name, String displayedUserName, WebDriver driver) {
        mailBoxPage.AssertUserName(link_user_name,displayedUserName, driver);
        return  this;
    }
}
