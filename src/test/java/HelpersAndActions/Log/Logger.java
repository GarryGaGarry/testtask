package HelpersAndActions.Log;

import org.junit.rules.TestWatcher;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger extends TestWatcher {
    private int LOG_LEVEL;
    private static Logger instance;

    public enum Level {
        OFF(0),
        FATAL(1),
        ERROR(2),
        WARN(3),
        INFO(4),
        DEBUG(5),
        ALL(6);

        private int level;

        Level(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }

    public enum Color {
        RESET("\u001B[0m"),
        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        PURPLE("\u001B[35m"),
        CYAN("\u001B[36m"),
        WHITE("\u001B[37m"),
        GREEN_BACKGROUND("\u001B[42m\u001B[30m"),
        RED_BACKGROUND("\u001B[41m");

        private String color;

        Color(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }

    public static synchronized Logger getInstance(Level logLevel) {
        if (instance == null) {
            instance = new Logger(logLevel);
        }
        return instance;
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger(Level.ALL);
        }
        return instance;
    }

    private Logger(Level logLevel){
        LOG_LEVEL = logLevel.getLevel();
    }

    public void log(String text, Level logLevel){
        log(text, logLevel, null);
    }

    public void log(String text, Level logLevel, Color color){
        String logText = createLogText(text, logLevel, color);
        if (logLevel.getLevel() <= LOG_LEVEL){
            System.out.println(logText);
        }
    }

    private String createLogText(String text, Level logLevel, Color color) {
        return getDate() +
               createInfoAboutLevel(logLevel) +
               createColoredText(text, logLevel, color);
    }

    private String createColoredText(String text, Level logLevel, Color color) {
        if (color == null) {
            if (logLevel.getLevel() <= Level.WARN.getLevel()) {
                return text;
            }

            color = Color.GREEN;
        }

        return color.getColor() + text + Color.RESET.getColor();
    }

    private String createInfoAboutLevel(Level logLevel) {
        return " [" + getLevelColor(logLevel) + logLevel + Color.RESET.getColor() + "] ";
    }

    private String getLevelColor(Level logLevel) {
        switch (logLevel) {
            case OFF:
            case FATAL:
            case ERROR:
            case WARN:
                return Color.RED.getColor();
            case INFO:
            case DEBUG:
            case ALL:
                return Color.BLUE.getColor();
            default:
                throw new IllegalArgumentException("Unknown Log Level");
        }
    }

    private String getDate(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:y_HH:mm:ss");
        return sdf.format(cal.getTime());
    }
}
