package support;

import HelpersAndActions.BotHelpers.BotManager;
import HelpersAndActions.Log.Logger;
import Pages.LoginPage;
import Pages.MailDetailsPage;
import Pages.MainPage;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import ru.qatools.properties.PropertyLoader;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestLifeCycle{
    private MyConfig config;
    protected Logger logger;
    protected WebDriver webDriver;
    protected BotManager botManager;
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected MailDetailsPage mailDetailsPage;

    @Rule
    public TestName name = new TestName();

    @Rule
    public TestResultAction testResultAction = new TestResultAction();

    @Before
    public void setUp() {
        config = PropertyLoader.newInstance().populate(MyConfig.class);
        logger = Logger.getInstance(config.getLogLevel());

        Configuration.browser = config.getBrowser();
        Configuration.timeout = 8000;
        Configuration.baseUrl = config.getUrl();
        Configuration.browserSize = config.getBrowserSize();

        open("/");
        webDriver = getWebDriver();

        botManager = BotManager.getInstance();
        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        mailDetailsPage = new MailDetailsPage(webDriver);

        logger.log("START test: " + name.getMethodName(), Logger.Level.INFO, Logger.Color.YELLOW);
    }

    @After
    public void finish() {
        logger.log("FINISH test: " + name.getMethodName(), Logger.Level.INFO, Logger.Color.YELLOW);
        clearBrowserCookies();
    }
}
