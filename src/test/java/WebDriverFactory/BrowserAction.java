package WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Lili on 24.05.2015.
 */
public class BrowserAction {

    WebDriver driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());

       public  void textSet(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    public  void buttonClick(By locator){
        driver.findElement(locator).click();
    }
}
