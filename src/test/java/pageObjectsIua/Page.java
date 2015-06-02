package pageObjectsIua;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import webDriverFactory.WebDriverFactory;

/**
 * Created by Lili on 24.05.2015.
 */
public abstract class Page {

    public static WebDriver driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());


    public static <T extends Page> void InitPage(T pageClass)
    {
        PageFactory.initElements(driver, pageClass);
    }

    public static void quitDriver(){
        driver.quit();
    }
}
