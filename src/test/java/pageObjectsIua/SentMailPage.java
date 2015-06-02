package pageObjectsIua;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webDriverFactory.BrowserAction;

/**
 * Created by Liliia_Klymenko on 26-May-15.
 */
public class SentMailPage extends Page {

    private BrowserAction action = new BrowserAction();

    @FindBy(xpath = ".//*[@id='mesgList']/form/div[1]/a/span[2]")
    private WebElement lastMailRecipient;

    @FindBy(xpath = ".//*[@id='header_overall']/div[1]/ul[3]/li[3]/span")
    private WebElement buttonSettings;

    @FindBy(xpath = ".//*[@id='accountSettingsPopup']/ul/li[7]/a")
    private WebElement buttonExit;




    public static SentMailPage getSentMailPage() {
        SentMailPage sentMailPage = new SentMailPage();
        InitPage(sentMailPage);
        return sentMailPage;
    }

    public String getActualLastMailRecipient() {
        String actualLastMailRecipient = lastMailRecipient.getText();
        return actualLastMailRecipient;
    }

    public void exit() {
        action.buttonClick(buttonSettings);
        waiter.Waiter.waitForPresenceOfElementLocated(buttonExit, driver);
        action.buttonClick(buttonExit);
    }
}
