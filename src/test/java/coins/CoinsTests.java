package coins;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class CoinsTests extends TestBase {
    @Test
    void freeBitcoinCronLottery() {
        Selenide.open("https://freebitco.in/");
        $(".login_menu_button>a").hover().click();
        $("#login_form_btc_address").setValue("");
    }
}
