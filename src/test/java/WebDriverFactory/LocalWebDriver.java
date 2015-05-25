package WebDriverFactory;

/**
 * Created by Lili on 24.05.2015.
 */
public class LocalWebDriver {


    public String Browser;

    public String getBrowser() {
        return Browser;
    }
    public void setBrowser(String browser) {
        Browser = browser;
    }

    public LocalWebDriver(String browser)
    {
        Browser = browser;
    }
}
