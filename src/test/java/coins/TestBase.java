package coins;

import coins.helpers.DriverHelper;
import com.codeborne.selenide.Configuration;
import com.testingbot.models.TestingbotTest;
import com.testingbot.testingbotrest.TestingbotREST;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class TestBase implements TestWatcher {
    private static final String KEY = System.getenv("TESTINGBOT_KEY");
    private static final String SECRET = System.getenv("TESTINGBOT_SECRET");
    private final TestingbotREST tbRest = new TestingbotREST(KEY, SECRET);
    private TestingbotTest tbTest;

    @BeforeAll
    protected void setupSuite() {
        Configuration.timeout = 5000;
        Configuration.remote = "https://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";
    }

    @BeforeEach
    protected void setupTest() {
        tbTest = new TestingbotTest();
        tbTest.setSessionId(DriverHelper.getSessionId());
    }

    @AfterEach
    protected void cleanupTest() {
        tbRest.updateTest(tbTest);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        tbTest.setSuccess(true);
        tbTest.setName(getTestMethodName(context));
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        tbTest.setSuccess(false);
        tbTest.setStatusMessage(cause.getMessage());
        tbTest.setName(getTestMethodName(context));
    }

    private String getTestMethodName(ExtensionContext context) {
        return context.getRequiredTestMethod().getName();
    }
}
