package HelpersAndActions.BotHelpers;

import HelpersAndActions.Log.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bot {
    private Logger logger = Logger.getInstance();
    public static final Pattern EMAIL_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private String fullLogin;
    private String pass;


    public Bot(String fullLogin, String pass){
        this.fullLogin = fullLogin;
        this.pass = pass;
    }

    public String getFullLogin() {
        loginVerification();
        return fullLogin;
    }

    public String getLogin() {
        loginVerification();
        return fullLogin.split("@")[0];
    }

    public String getDomain() {
        loginVerification();
        return "@" + fullLogin.split("@")[1];
    }

    public String getPass() { return pass; }

    private void loginVerification() {
        Matcher matcher = EMAIL_REGEX.matcher(fullLogin);
        if (!matcher.find()){
            logger.log("Login:" + fullLogin + " does not email", Logger.Level.ERROR);
                throw new Error("Login:" + fullLogin + " does not email");
        }
    }
}
