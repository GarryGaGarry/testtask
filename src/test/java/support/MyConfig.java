package support;

import HelpersAndActions.Log.Logger;
import ru.qatools.properties.Property;
import ru.qatools.properties.Resource;

@Resource.Classpath("config.properties")
public interface MyConfig {

    @Property("logLevel")
    Logger.Level getLogLevel();

    @Property("browser")
    String getBrowser();

    @Property("browserSize")
    String getBrowserSize();

    @Property("url")
    String getUrl();
}
