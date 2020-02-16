
import org.junit.Test;
import support.TestLifeCycle;

import static org.junit.Assert.assertEquals;


public class TestTaskCases extends TestLifeCycle {
    @Test
    public void checkMailDetails() {
        loginPage.login(botManager.getBot("Pre-created user"));
        mainPage.openMail(mainPage.getFirstMailByName("Pre-created name"));
        assertEquals("Pre-creates name", mailDetailsPage.getAuthorName());
        assertEquals("Pre-creates mail subject", mailDetailsPage.getMailSubject());
        assertEquals("Pre-creates mail text", mailDetailsPage.getMailText());
        mainPage.logout();
    }
}