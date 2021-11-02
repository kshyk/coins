package coins.pageobjects;

import lombok.experimental.UtilityClass;

import static com.codeborne.selenide.Selenide.$;

@UtilityClass
public class LoginPage {
    public static void login() {
        $("#login_form_btc_address").setValue(System.getenv("EMAIL"));
        $("#login_form_password").setValue(System.getenv("PASSWORD"));
        $("#login_button").hover().click();
    }
}
