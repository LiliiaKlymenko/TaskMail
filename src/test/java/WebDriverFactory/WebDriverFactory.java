package WebDriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Lili on 24.05.2015.
 */
public class WebDriverFactory {

    private DesiredCapabilities capabilities = null;
    private static WebDriver driver = null;



    public  WebDriver Create(LocalWebDriver config)
    {

        switch (config.Browser)
        {
            case "chrome":
                driver = new ChromeDriver();
                break;

             case "opera":
                driver = new OperaDriver();
                break;


            case "internet explorer":
                driver = new InternetExplorerDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "html unit driver" :
                driver = new HtmlUnitDriver();
                break;

            default:
                driver = new FirefoxDriver();
                break;
        }

        return driver;
    }

     public WebDriver Create(RemoteWebDriver config)
    {

        switch (config.Browser)
        {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "internet explorer":
            driver = new InternetExplorerDriver();
            break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "html unit driver" :
                driver = new HtmlUnitDriver();
                break;

            default:
                driver = new FirefoxDriver();
                break;
        }

        return driver;
    }


}
