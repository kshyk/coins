package coins.pageobjects;

import lombok.experimental.UtilityClass;

import static com.codeborne.selenide.Selenide.$;

@UtilityClass
public class MenuBar {
    public static void clickLoginMenuButton() {
        $(".login_menu_button>a").hover().click();
    }
}
