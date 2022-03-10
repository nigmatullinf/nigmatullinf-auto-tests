import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
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
        $("[id='login_field']").sendKeys("");
        $("[id='password']").sendKeys("");
        //4. Нажать кнопку sign in
        $(".js-sign-in-button").click();
        //5. Проверить авторизацию
        $(".Header").shouldBe(visible);
        //$(byText("Your profile"));
    }
}