package coins;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.codeborne.selenide.Selenide.$;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CoinsTests {
    @Test
    void freeBitcoinCronLottery() {
        Selenide.open("https://freebitco.in/");
        $(".login_menu_button>a").hover().click();
        $("#login_form_btc_address").setValue("");
    }
}
