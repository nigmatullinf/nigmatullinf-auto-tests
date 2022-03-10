import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthTest {

    @Test
    public void shouldAuthorizeTest() {
        //1. Открыть страницу https://github.com/
        open("https://github.com/");
        //2. Кликнуть на кнопку sign in
        $("[href='/login']").click();
        //3. Заполнить инпуты логина и пароля
        $("[id='login_field']").sendKeys("nigmatullinf");
        $("[id='password']").sendKeys("UsalBasik666!");
        //4. Нажать кнопку sign in
        $(".js-sign-in-button").click();
        //5. Проверить авторизацию
        $(".Header").shouldBe(visible);
        //6. Открываем дропдаун профиля
        $(".js-feature-preview-indicator-container").click();
        //7. Кликаем по кнопке "Your profile"
        $("[data-ga-click='Header, go to profile, text:your profile']").click();
        //8. Открывается профиль пользователя
        $(".vcard-names  span:nth-child(1)").shouldHave(text("Fayl Nigmatullin"));
    }
}