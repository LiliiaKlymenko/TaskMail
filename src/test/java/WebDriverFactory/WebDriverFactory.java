package WebDriverFactory;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Lili on 24.05.2015.
 */
public class WebDriverFactory {

    private static String defaultHub = null;
    private static int restartFrequency = Integer.MAX_VALUE;
    public static void setDefaultHub(String newDefaultHub) {
        defaultHub = newDefaultHub;
    }
    public static void setRestartFrequency(int newRestartFrequency) {
        restartFrequency = newRestartFrequency;
    }



    public static String key = null;
    public static int count = 0;
    public static WebDriver driver;

    public static WebDriver getDriver(String hub, Capabilities capabilities) {
        count++;
        if (driver == null) {
            return newWebDriver(hub, capabilities);
        }
       else
        return driver;
    }

    public static WebDriver getDriver(Capabilities capabilities) {
        return getDriver(defaultHub, capabilities);
    }

    public static void dismissDriver() {
        if (driver != null) {
            try {
                driver.quit();
                driver = null;
                key = null;
            } catch (WebDriverException ex) {

            }
        }
    }



    private static WebDriver newWebDriver(String hub, Capabilities capabilities) {
        driver = (hub == null)
                ? createLocalDriver(capabilities)
                : createRemoteDriver(hub, capabilities);
        key = capabilities.toString() + ":" + hub;
        count = 0;
        return driver;
    }

    private static WebDriver createRemoteDriver(String hub,
                                                Capabilities capabilities) throws Error {
/*        try {
            return new RemoteWebDriver(URL(hub), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new Error("Could not connect to WebDriver hub", e);
        }*/
        return null;
    }

    private static WebDriver createLocalDriver(Capabilities capabilities) {
        String browserType = capabilities.getBrowserName();
        if (browserType.equals("firefox"))
            return new FirefoxDriver(capabilities);
        if (browserType.startsWith("internet explorer")) {
            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability(
                    InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                    true);
            System.setProperty("webdriver.ie.driver", "DriversExeLib/IEDriverServer32.exe");
            return new InternetExplorerDriver(caps);
        }
        if (browserType.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "DriversExeLib/chromedriver.exe");
            return new ChromeDriver();
        }
        if (browserType.equals("opera")) {
            System.setProperty("webdriver.opera.driver", "DriversExeLib/operadriver.exe");
            return new OperaDriver();
        }

        throw new Error("Unrecognized browser type: " + browserType);
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                dismissDriver();
            }
        });
    }

}