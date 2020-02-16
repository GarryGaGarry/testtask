package Pages;

import HelpersAndActions.BotHelpers.Bot;
import HelpersAndActions.Log.Logger;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends Page{
    private final String LOGIN_INPUT = "input[id$=login]";
    private final String SUBMIT_BUTTON = "input.o-control";
    private final String LOGIN_DOMAIN = "select[name=domain]";
    private final String PASSWORD_INPUT = "input[id$=password]";
    private final String LOGGIN_ERROR = "div[id$=error]";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void login(Bot bot) {
        logger.log("Login as user: " + bot.getFullLogin(), Logger.Level.DEBUG);
        $(LOGIN_INPUT).sendKeys(bot.getLogin());
        $(LOGIN_DOMAIN).selectOptionContainingText(bot.getDomain());
        $(SUBMIT_BUTTON).click();
        $(PASSWORD_INPUT).sendKeys(bot.getPass());
        $(SUBMIT_BUTTON).click();
        try {
            if ($(LOGGIN_ERROR).waitUntil(Condition.appear, 2000).isDisplayed()) {
                throw new Error("Can't login. Wrong name or password");
            }
        }
        catch(ElementNotFound e){
            logger.log("Login success as user: " + bot.getFullLogin(), Logger.Level.DEBUG);
        }
    }
}
