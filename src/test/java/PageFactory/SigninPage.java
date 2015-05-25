package PageFactory;

import WebDriverFactory.BrowserAction;
import org.openqa.selenium.By;

/**
 * Created by Lili on 24.05.2015.
 */
public class SigninPage extends  Page {

    private static final String USER_NAME_TEXT_FIELD = "login";
    private static final String PASS_TEXT_FIELD = "pass";
    private static final String LOGIN_BUTTON  = "css=p > input[type=\'submit\\']";


    private By usernameTextBox = By.name(USER_NAME_TEXT_FIELD);
    private By passwordTextBox = By.name(PASS_TEXT_FIELD);
    private By loginButton = By.xpath(LOGIN_BUTTON);
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
