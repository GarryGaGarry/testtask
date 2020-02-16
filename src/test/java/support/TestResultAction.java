package support;

import HelpersAndActions.Log.Logger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


public class TestResultAction extends TestWatcher {
    private Logger logger = Logger.getInstance();


    @Override
    public void succeeded(Description description) {
        logger.log("TEST: " + description.getMethodName() + " SUCCESS\n", Logger.Level.INFO, Logger.Color.GREEN_BACKGROUND);
    }

    @Override
    protected void failed(Throwable e, Description description) {
        logger.log("TEST: " + description.getMethodName() + " FAIL\n", Logger.Level.ERROR, Logger.Color.RED_BACKGROUND);
    }
}
