package HelpersAndActions.BotHelpers;

import HelpersAndActions.Log.Logger;
import java.util.HashMap;

public class BotManager {
    private Logger logger = Logger.getInstance();
    private HashMap<String, Bot> botList = new HashMap<String, Bot>();
    private static BotManager instance;


    private BotManager(){
        botList.put("Pre-created user", new Bot("test@mail.ru", "Pre-created strong password like 12345"));
    }

    public static synchronized BotManager getInstance() {
        if (instance == null) {
            instance = new BotManager();
        }
        return instance;
    }

    public Bot getBot(String key){
        Bot bot = botList.get(key);
        logger.log("Bot for test: " + key, Logger.Level.DEBUG);
        return bot;
    }
}
