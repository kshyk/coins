package coins.pageobjects;

import com.codeborne.selenide.SelenideElement;
import lombok.experimental.UtilityClass;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@UtilityClass
public class MenuBar {
    private static final SelenideElement BAR = $("section.top-bar-section");

    public static void clickLoginMenuButton() {
        BAR.$(".login_menu_button>a").shouldBe(visible).hover().click();
    }

    public static void clickFreeBtcMenuButton() {
        BAR.$("#free_play_link_li>a").shouldBe(visible).hover().click();
    }

    public static String getCurrentBalance() {
        return BAR.$(".balanceli").text();
    }
}
