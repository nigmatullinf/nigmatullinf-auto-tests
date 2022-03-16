import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Keys;


import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Junit4Test {
    @BeforeEach
    public void openURL() {
        open("https://github.com/junit-team/junit4");
    }

    @Test
    public void fixtureBranchSelectionTest() {
        Pages.junit4Page.switchBranchesButton()
                .click();
        Pages.junit4Page.availableBranchesList()
                .findBy(Condition.text("fixtures"))
                .click();
        Pages.junit4Page.currentBranch()
                .shouldHave(Condition.text("fixtures"));
    }

    @Test
    @MethodSource("releaseNames")
    @ParameterizedTest()
    public void releaseSearchTest(String releaseNames) {
        Pages.junit4Page.releasesLink()
                .click();
        Pages.releasePage.findReleaseInput()
                .sendKeys(releaseNames);
        Pages.releasePage.findReleaseInput()
                .sendKeys(Keys.ENTER);
        Pages.releasePage.releaseCards()
                .first()
                .shouldHave(Condition.text(releaseNames));
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
