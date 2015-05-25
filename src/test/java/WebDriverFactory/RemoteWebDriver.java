package WebDriverFactory;

import java.net.URL;

/**
 * Created by Lili on 24.05.2015.
 */
public class RemoteWebDriver {

    public String Browser;

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public URL url;

    public String getBrowser() {
        return Browser;
    }
    public void setBrowser(String browser) {
        Browser = browser;
    }

    public RemoteWebDriver(String browser)
    {
        Browser = browser;
        this.url = url;

    }

}
