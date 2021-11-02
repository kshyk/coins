package coins;

import coins.pageobjects.LoginPage;
import coins.pageobjects.MenuBar;
import com.codeborne.selenide.Credentials;
import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.AuthenticationType.BASIC;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Slf4j
public class CoinsTests extends TestBase {
    @BeforeAll
    void preconditions() {
        var credentials = new Credentials(EMAIL, PASSWORD);
        Selenide.open("https://freebitco.in/", BASIC, credentials);
        MenuBar.clickLoginMenuButton();
        LoginPage.login();
    }

    @Test
    void freeBitcoinCronLottery() {
        MenuBar.clickFreeBtcMenuButton();
        if ($("#time_remaining").is(not(visible))) {
            Selenide.switchTo().frame($(".h-captcha>iframe"));
            $("#checkbox").hover().setSelected(true);
            Selenide.switchTo().defaultContent();
            $("#free_play_form_button").shouldBe(visible).hover().click();
            log.info("Lucky number: {}", $("#free_play_digits").shouldBe(visible).text());
            log.info("{}", $("#free_play_result").text());
        }
        log.info("Current balance: {}", MenuBar.getCurrentBalance());
    }
}
