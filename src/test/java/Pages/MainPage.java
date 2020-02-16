package Pages;

import HelpersAndActions.Log.Logger;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends Page{
    private final String LOGOUT = "#PH_logoutLink";
    private final String MAILS_LIST = "a.js-letter-list-item";
    private final String AUTHOR_NAME = ".ll-crpt";

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void logout(){
        $(LOGOUT).click();
        logger.log("Разлогинились", Logger.Level.DEBUG);
    }

    public SelenideElement getFirstMail(){
        return getMailByIndex(0);
    }


    public SelenideElement getMailByIndex(int index){
        return getAllMail().get(index);
    }

    public SelenideElement getFirstMailByName(String name){
        for (SelenideElement mail : getAllMail()) {
            logger.log(mail.$(AUTHOR_NAME).getText(), Logger.Level.DEBUG);
            if (name.equals(mail.$(AUTHOR_NAME).getText())){
                return mail;
            }
        }
        logger.log("Mail with author: " + name + " was not found", Logger.Level.ERROR);
        throw new Error("can't find mail by name");
    }

    public void openMail(SelenideElement mail){
        mail.click();
    }

    private ElementsCollection getAllMail(){
        if ($$(MAILS_LIST).isEmpty()){
            logger.log("Mails was not found", Logger.Level.ERROR);
            throw new Error("list of mail is empty");
        }
        return $$(MAILS_LIST);
    }

}
