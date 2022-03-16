package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ReleasePage {

    public SelenideElement findReleaseInput() {
       return $("[type='search']");
    }

    public ElementsCollection releaseCards() {
        return $$("[data-test-selector='release-card']");
    }


}
