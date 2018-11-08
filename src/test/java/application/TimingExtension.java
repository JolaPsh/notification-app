package application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.*;

import java.lang.reflect.Method;

/**
 * Created by Admin on лист, 2018
 */
public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback, BeforeAllCallback, AfterAllCallback {

    private static final Logger log = LogManager.getLogger("results");
    private static final String START_TIME = "start time";

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        log.info("Before all tests");

    }
    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        log.info("After all tests");
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        getStore(context).put(START_TIME, System.currentTimeMillis());
        Method testMethod = context.getRequiredTestMethod();
        log.info(String.format("About to execute %s()...", testMethod.getName()));
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        Method testMethod = context.getRequiredTestMethod();
        long startTime = getStore(context).remove(START_TIME, long.class);
        long duration = System.currentTimeMillis() - startTime;
        log.info(() -> String.format(">> Execution time of method [%s] = %s ms.", testMethod.getName(), duration));
    }

    private ExtensionContext.Store getStore(ExtensionContext context) {
        return context.getStore(ExtensionContext.Namespace.create(getClass(), context.getRequiredTestMethod()));
    }
}
