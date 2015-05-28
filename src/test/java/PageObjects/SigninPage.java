package PageObjects;

import WebDriverFactory.BrowserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Lili on 24.05.2015.
 */
public class SigninPage extends  Page {


    private BrowserAction action = new BrowserAction();


    public static  SigninPage getSigninPage() {
        SigninPage signinPage = new SigninPage();
        InitPage(signinPage);
        return signinPage;
        }

    public SigninPage enterLogin(By usernameTextBox, String login){
        action.textSet(usernameTextBox, login);
        return getSigninPage();
    }

    public SigninPage enterPassword(By passwordTextBox, String pass){
        Waiter.Waiter.waitForVisibilityOfElementLocated(passwordTextBox, WebDriverFactory.WebDriverFactory.getDriver(DesiredCapabilities.firefox()));
        action.textSet(passwordTextBox, pass);
        return getSigninPage();
    }

    public SigninPage clickLoginButton(By loginButton){
        action.buttonClick(loginButton);
        return getSigninPage();
    }

    public SigninPage clickButtonNext(By buttonNext){
        action.buttonClick(buttonNext);
        return getSigninPage();
    }

   /* public MailBoxPage login(String login, String pass){
        enterLogin(login);
        enterPassword(pass);
        return clickLoginButton();
    }*/
}