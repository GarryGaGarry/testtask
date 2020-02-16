package Pages;

import HelpersAndActions.Log.Logger;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class MailDetailsPage extends Page{
    private final String AUTHOR = ".letter__author .letter-contact";
    private final String MAIL_SUBJECT = ".thread__subject";
    private final String MAIL_TEXT = ".letter__body";

    public MailDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getAuthorName(){
        String authorName = $(AUTHOR).getText();
        logger.log("Name of the author of the mail: " + authorName, Logger.Level.DEBUG);
        return authorName;
    }

    public String getMailText(){
        String mailText = $(MAIL_TEXT).getText();
        logger.log("Content of the mail:\n " + mailText, Logger.Level.DEBUG);
        return mailText;
    }

    public String getMailSubject(){
        String mailSubject = $(MAIL_SUBJECT).getText();
        logger.log("Subject of the mail: " + mailSubject, Logger.Level.DEBUG);
        return mailSubject;
    }
}
