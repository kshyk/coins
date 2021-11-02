package coins.helpers;

import com.codeborne.selenide.WebDriverRunner;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.remote.RemoteWebDriver;

@UtilityClass
public class DriverHelper {
    public static String getSessionId() {
        return ((RemoteWebDriver) WebDriverRunner.getWebDriver()).getSessionId().toString();
    }
}
