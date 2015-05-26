package Tests.I.UA;

import Helpers.LoginHelper;
import WebDriverFactory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lili on 24.05.2015.
 */
public class TestSignIn {


    WebDriver driver;
    private static LoginHelper loginHelper;

    ResourceBundle resource = ResourceBundle.getBundle("config");
    String USERNAME = resource.getString("USERNAME");
    String PASSWORD = resource.getString("PASSWORD");
    String DISPLAYEDUSERNAME = resource.getString("DISPLAYEDUSERNAME");
    String IUA = resource.getString("IUA");




    @BeforeClass
    public void startWebDriver() {
       driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
        loginHelper = new LoginHelper();
    }

    @Test(groups = { "SignIn" }, priority = 10)
    public void doLogin() {
        driver.get(IUA);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        loginHelper.signIn(USERNAME, PASSWORD).assertSuccessSignIn(DISPLAYEDUSERNAME, driver);
    }


}
