import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Keys;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Owner("nigmatullinf")
@Feature("Тестирование репозитория Junit4")
public class Junit4Test {
    @BeforeEach
    public void openURL() {
        open("https://github.com/junit-team/junit4");
    }

    @Test
    @DisplayName("Проверка выбора ветки")
    public void fixtureBranchSelectionTest() {
        step("При выборе ветки фикстур текущая ветка меняется на fixtures", () -> {
            Pages.junit4Page.switchBranchesButton()
                    .click();
            Pages.junit4Page.availableBranchesList()
                    .findBy(text("fixtures"))
                    .click();
            Pages.junit4Page.currentBranch()
                    .shouldHave(text("fixtures"));
        });
    }

    @DisplayName("Проверка поиска релизов")
    @MethodSource("releaseNames")
    @ParameterizedTest()
    public void releaseSearchTest(String releaseNames) {
        step("Перейти на страницу с релизами", () -> {
            Pages.junit4Page.releasesLink()
                    .click();
        });
        step("Ввести название релиза в поисковую строку", () ->{
            Pages.releasePage.findReleaseInput()
                    .sendKeys(releaseNames);
            Pages.releasePage.findReleaseInput()
                    .sendKeys(Keys.ENTER);
            Pages.releasePage.releaseCards()
                    .first()
                    .shouldHave(text(releaseNames));
        });

    }

    static Stream<Arguments> releaseNames() {
        return Stream.of(
                arguments("JUnit 4.13.2"),
                arguments("JUnit 4.13.1"),
                arguments("JUnit 4.13"),
                arguments("JUnit 4.13 RC 2"),
                arguments("JUnit 4.13 RC 1"),
                arguments("JUnit 4.13 Beta 3"),
                arguments("JUnit 4.13 Beta 2"),
                arguments("JUnit 4.13 Beta 1"),
                arguments("JUnit 4.12"),
                arguments("JUnit 4.12 Beta 2"),
                arguments("JUnit 4.12 Beta 1"),
                arguments("JUnit 4.11")
        );
    }
}
