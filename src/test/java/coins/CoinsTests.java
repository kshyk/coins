package coins;

import coins.pageobjects.LoginPage;
import coins.pageobjects.MenuBar;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CoinsTests extends TestBase {
    @BeforeAll
    void openPage() {
        Selenide.open("https://freebitco.in/");
    }

    @Test
    void freeBitcoinCronLottery() {
        MenuBar.clickLoginMenuButton();
        LoginPage.login();
    }
}
