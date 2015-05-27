package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Lili on 24.05.2015.
 */
public abstract class Page {

    public static WebDriver Driver;


    public static <T extends Page> void InitPage(T pageClass)
    {
        PageFactory.initElements(Driver, pageClass);
    }
}
