package PageFactory;

import WebDriverFactory.BrowserAction;
import org.openqa.selenium.By;

import java.util.ResourceBundle;

/**
 * Created by Lili on 24.05.2015.
 */
public class SigninPage extends  Page {


    ResourceBundle resource = ResourceBundle.getBundle("config");
    String USER_NAME_TEXT_FIELD = resource.getString("USER_NAME_TEXT_FIELD");
    String PASS_TEXT_FIELD = resource.getString("PASS_TEXT_FIELD");
    String LOGIN_BUTTON = resource.getString("LOGIN_BUTTON");

    private By usernameTextBox = new By.ByXPath(USER_NAME_TEXT_FIELD);
    private By passwordTextBox = new By.ByXPath(PASS_TEXT_FIELD);
    private By loginButton = new By.ByXPath(LOGIN_BUTTON);
    private BrowserAction action = new BrowserAction();


    public static  SigninPage getSigninPage() {
        SigninPage signinPage = new SigninPage();
        InitPage(signinPage);
        return signinPage;
        }

    public SigninPage enterLogin(String login){
        action.textSet(usernameTextBox, login);
        return getSigninPage();
    }

    public SigninPage enterPassword(String pass){
        action.textSet(passwordTextBox, pass);
        return getSigninPage();
    }

    public SigninPage clickLoginButton(){
        action.buttonClick(loginButton);
        return getSigninPage();
    }

   /* public MailBoxPage login(String login, String pass){
        enterLogin(login);
        enterPassword(pass);
        return clickLoginButton();
    }*/
}
