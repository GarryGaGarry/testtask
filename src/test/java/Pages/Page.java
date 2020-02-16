package Pages;

import HelpersAndActions.Log.Logger;
import org.openqa.selenium.WebDriver;

public class Page {
    static protected Logger logger = Logger.getInstance();
    static protected WebDriver webDriver;

    public Page(WebDriver webDriver){
        this.webDriver = webDriver;
    }
}
